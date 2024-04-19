/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.NotaClinicaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author diego
 */
public class NotaClinicaImpl extends DatabaseSistemaSalud implements NotaClinicaInterface {

    @Override
    public String buscarNotaClinica(String dniPaciente) {
               String sql = " select especialidad,texto,fecha_realizacion from nota_clinica no where dni_paciente = ?";
		
		this.openConnection();
		
               
                StringBuilder resBuilder = new StringBuilder();
                
                
		PreparedStatement pst = null;
		ResultSet rs = null;
		  
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, dniPaciente);
			rs = pst.executeQuery();
			
                        
                        
                        if (rs.next()) {

                        resBuilder.append("Nota Clinica:" + "\n");
                        String especialidad = rs.getString("especialidad");
                        String texto = rs.getString("texto");
                        String fecha = rs.getString("fecha_realizacion");
                        
                        resBuilder.append("Especialidad Medica: " + especialidad + "\n");
                        resBuilder.append("Fecha: " + fecha.substring(0, 9) + "\n");
                        resBuilder.append("Texto: " + texto + "\n\n");

                        while (rs.next()) {
                            resBuilder.append("Nota Clinica:" + "\n");
                            String especialidad2 = rs.getString("especialidad");
                            String texto2 = rs.getString("texto");
                            String fecha2 = rs.getString("fecha_realizacion");
                            resBuilder.append("Especialidad Medica: " + especialidad2 + "\n");
                            resBuilder.append("Fecha: " + fecha2.substring(0, 10) + "\n");
                            resBuilder.append("Texto: " + texto2 + "\n\n");
                        }

                    } else {
                        resBuilder.append("No hay ninguna nota clinica asociada al DNI del paciente");
                    }

				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar las notas clinicas por dni: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar las notas clinicas por dni: ");
			System.err.println(e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close(); 
				if (rs != null) rs.close();
			} catch (SQLException e) {
				System.err.println("Error al cerrar las estructuras: ");
				System.err.println(e.getMessage());
			}
		}
                String res = resBuilder.toString();
                //System.out.println(res);
                return res;
	
    }

    @Override
    public String agregarNotaClinica(String dniPaciente, String dniMedico,String texto) {
            // Fecha , texto , especialidad , dni_paciente
            
            
            String sql1 = " select es.nombre as especialidad from medico me "
                    + "INNER JOIN medico_tiene_especialidad mte ON mte.dni_medico = me.Dni "
                    + "INNER JOIN especialidad es ON es.id_especialidad = mte.id_especialidad"
                    + " where me.Dni = ?";
            String sql2 = " INSERT INTO nota_clinica VALUES (?,?,?,?); ";
            
            //Dni del medico , fecha de la nota clinica , Dni del paciente
            String sql3 ="INSERT INTO medico_escribe_nota_clinica VALUES (?,?,?);";
		
		this.openConnection();
		
               
                StringBuilder resBuilder = new StringBuilder();
                
                
		PreparedStatement pst1 = null; 
		ResultSet rs1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs2 = null; 
                PreparedStatement pst3 = null;
		ResultSet rs3 = null; 
		try {
                         pst2 = conn.prepareStatement(sql2);
                         pst3 = conn.prepareStatement(sql3);
			pst1 = conn.prepareStatement(sql1);
			
			pst1.setString(1, dniMedico);
			rs1 = pst1.executeQuery();
                        String especialidad = "";
                        if(rs1.next()){
                            especialidad = rs1.getString("especialidad");
                        }
                        else {
                            resBuilder.append("No existe ningun medico con ese dni");
                            throw new Exception("No existe n1ngun medico con ese dni");
                        }
                          
                        
                        LocalDateTime fechaActual = LocalDateTime.now();
                        //System.out.println(fechaActual);
                        
                        pst2.setString(1,fechaActual.toString() );
                        pst2.setString(2, texto);
                        pst2.setString(3, especialidad);
                        pst2.setString(4,dniPaciente);
                        
                        int r1 = pst2.executeUpdate();
                        if(r1 != 1){
                             resBuilder.append("La nota clinica no se ha añadido correctamente");
                            throw new Exception("La nota clinica no se ha añadido correctamente");
                        }
                        
                        pst3.setString(1, dniMedico);
                        pst3.setString(2, fechaActual.toString());
                        pst3.setString(3, dniPaciente);
                        
                        int r3 = pst3.executeUpdate();
                        if(r3 != 1){
                             resBuilder.append("La nota clinica no se ha añadido al historial del medico correctamente");
                            throw new Exception("La nota clinica no se ha añadido al historial del medico correctamente");
                        }
			
			resBuilder.append("La nota clinica se ha añadido correctamente al historial del paciente");	
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar las notas clinicas por dni: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar las notas clinicas por dni: ");
			System.err.println(e.getMessage());
		} finally {
			try {
				if (pst1 != null) pst1.close(); 
				if (rs1 != null) rs1.close();
                                if (pst2 != null) pst2.close(); 
				if (rs2 != null) rs2.close();
                                if (pst3 != null) pst3.close(); 
				if (rs3 != null) rs3.close();
			} catch (SQLException e) {
				System.err.println("Error al cerrar las estructuras: ");
				System.err.println(e.getMessage());
			}
		}
                String res = resBuilder.toString();
                //System.out.println("Esto es res: " + res);
                return res;
    }
    
}
