/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.CitasAnterioresInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diego
 */
public class CitasAnterioresImpl extends DatabaseSistemaSalud implements CitasAnterioresInterface {

    @Override
    public String buscarCitasAnteriores(String dniPaciente) {
        
        String sql1 = "select dni_medico as dniMedico, fecha_realizacion as fechaR, motivo, nombre_centro_Salud as centro from medico_atiende_a_paciente_en_Centro_salud "
                + "where dni_paciente = ?";
        
           String sql2 = " select es.nombre as especialidad, me.nombre as nombreM, me.Primer_apellido as ppm, me.Segundo_Apellido as spm from medico me 	\n"
                + "INNER JOIN medico_tiene_especialidad mte ON me.Dni = mte.dni_medico\n"
                + "INNER JOIN especialidad es ON mte.id_especialidad = es.id_especialidad"
                   + " where me.Dni = ";
           
           String sql3 = " select nombre,Primer_Apellido as pp, Segundo_Apellido as sp, fecha_nacimiento as fechan from paciente where Dni = ?";
		
		this.openConnection();
		
               
                StringBuilder resBuilder = new StringBuilder();
                
                
		PreparedStatement pst = null;
                PreparedStatement pst3 = null;
		ResultSet rs = null;
		Statement st = null;
		ResultSet rs2 = null;
                ResultSet rs3 = null;
                boolean entro = false;
		try {
			pst = conn.prepareStatement(sql1);
			
                        
			pst.setString(1, dniPaciente);
			rs = pst.executeQuery();
			
                        pst3 = conn.prepareStatement(sql3);
			
                        
			pst3.setString(1, dniPaciente);
			rs3 = pst3.executeQuery();
                        
                        
			if (rs.next()){
                            
                            
                            
                            rs3.next();
                            String nombreP = rs3.getString("nombre");
                            String PrimerApellidoP = rs3.getString("pp");
                            String SegundoApellidoP = rs3.getString("sp");
                            
                            
                            resBuilder.append("Nombre del Paciente: ")
                                       .append(nombreP)
                                       .append(" ")
                                       .append(PrimerApellidoP)
                                       .append(" ")
                                       .append(SegundoApellidoP)
                                       .append("\n\n");
                                             
                            
                            entro = true;
                            String dniMedico = rs.getString("dniMedico");
                            String sql22 = sql2 + "'" +  dniMedico+ "'" + ";";
                            
                            st = conn.createStatement();
                            rs2 = st.executeQuery(sql22);
                            
                            rs2.next();
                            String especialidad = rs2.getString("especialidad");
                            String nombreM = rs2.getString("nombreM");
                            String PrimerApellidoM = rs2.getString("ppm");
                            String SegundoApellidoM = rs2.getString("spm");
                            String centro = rs.getString("centro");
                            String fechaRealizacion = rs.getString("fechaR");
                            String motivo = rs.getString("motivo");
                            
                            resBuilder.append("Atendido En: ")
                                      .append(centro + "    En la fecha: " + fechaRealizacion + "\n")
                                      .append("Con motivo de: " + motivo + "\n");
                                      
                            resBuilder.append("Atendido Por: ")
                                      .append(nombreM)
                                      .append(" ")
                                      .append(PrimerApellidoM)
                                      .append(" ")
                                      .append(SegundoApellidoM + "\n")
                                      .append("Especialidad del Medico: " + especialidad )
                                      .append("\n\n");
                        }
                        if(!entro){
                            resBuilder.append("NO HAY NINGUNA CITA DE ESTE PACIENTE REGISTRADA");
                        }
                        
                        
                        while(rs.next()){
                            
                            String dniMedico = rs.getString("dniMedico");
                            String sql22 = sql2 + "'" +  dniMedico+ "'" + ";";
                            
                            st = conn.createStatement();
                            rs2 = st.executeQuery(sql22);
                            
                            rs2.next();
                            String especialidad = rs2.getString("especialidad");
                            String nombreM = rs2.getString("nombreM");
                            String PrimerApellidoM = rs2.getString("ppm");
                            String SegundoApellidoM = rs2.getString("spm");
                            String centro = rs.getString("centro");
                            String fechaRealizacion = rs.getString("fechaR");
                            String motivo = rs.getString("motivo");
                            
                            resBuilder.append("Atendido En: ")
                                      .append(centro + "    En la fecha: " + fechaRealizacion + "\n")
                                      .append("Con motivo de: " + motivo + "\n");
                                      
                            resBuilder.append("Atendido Por: ")
                                      .append(nombreM)
                                      .append(" ")
                                      .append(PrimerApellidoM)
                                      .append(" ")
                                      .append(SegundoApellidoM + "\n")
                                      .append("Especialidad del Medico: " + especialidad )
                                      .append("\n\n");
                        }

				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar las citas anteriores de un determinado paciente: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar las citas anteriores de un determinado paciente: ");
			System.err.println(e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close(); 
				if (rs != null) rs.close();
                                if(pst3 != null) pst3.close();
                                if (st != null) st.close();
                                if (rs2 != null) rs2.close();
                                if (rs3 != null) rs3.close();
         
			} catch (SQLException e) {
				System.err.println("Error al cerrar las estructuras: ");
				System.err.println(e.getMessage());
			}
		}
                String res = resBuilder.toString();
                System.out.println(res);
                return res;
	}
    
  
    
    }
    
    
    

