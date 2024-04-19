/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.EnfermerosInterface;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diego
 */




public class EnfermerosImpl extends DatabaseSistemaSalud implements EnfermerosInterface {

    
    
    @Override
    public String buscarEnfermero(String dni) {
        
        System.out.println("Entra el principio de busca enfermero");
        System.out.println("EL DNI del enfermero es : " +  dni);
        
		String sql = " select e.Primer_Apellido as pp,e.Segundo_Apellido as sp ,e.nombre as nombre, cs.nombre as centro, e.especialidad_Asignada as especialidad from enfermero e\n" +
"        INNER JOIN enfermero_trabaja_Centro_Salud etcs ON etcs.dni_enfermero = e.Dni\n" +
"        INNER JOIN centro_de_salud cs ON etcs.nombre_Centro_Salud = cs.nombre and \n" +
"        etcs.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        where e.Dni= ? ;";
		
		this.openConnection();
		
                int offset = 0;
                String res = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean entra = false;
                 
		try {
                      
			pst = conn.prepareStatement(sql);
			pst.setString(1, dni);
			rs = pst.executeQuery();
			                      
			while (entra = rs.next()){
                           if(offset == 0){
                               
				System.out.println(entra);
                                res = "Nombre del Enfermero:           " + rs.getString("nombre") + " " + rs.getString("pp") + " " + rs.getString("sp") + "\n\n";
                                res+= "Especialidad Asignada:           " + rs.getString("especialidad") + "\n\n";
                                res+= "Centro Sanitario Donde trabaja:  " + rs.getString("centro") + "\n\n";
                                offset++;
                           }
                           else if(offset>0) {
                               res+= "                                              " + rs.getString("centro") + "\n\n";
                           }
                        }
                        if(res.equals("")) {
                            res = "No existe ningún enfermero con ese dni";
                            //System.out.println("No existe ningún medico con ese id.");
                        }
                        
                        System.out.println(res);
				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar enfermero por ID: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar enfermero por ID: kkk");
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
                System.out.println(res);
                return res;
	}
        
    

    @Override
    public String buscarEnfermerosPorEspecialidad(String especialidad) {
        	String sql = " select e.Dni as dni ,e.Primer_Apellido as pp,e.Segundo_Apellido as sp ,e.nombre as nombre, cs.nombre as centro, e.especialidad_Asignada as especialidad from enfermero e\n" +
"        INNER JOIN enfermero_trabaja_Centro_Salud etcs ON etcs.dni_enfermero = e.Dni\n" +
"        INNER JOIN centro_de_salud cs ON etcs.nombre_Centro_Salud = cs.nombre and \n" +
"        etcs.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        where e.especialidad_Asignada = ?;";
                
                this.openConnection();
		
                //String res = "Nombre                    Apellido                            Trabaja En \n";
                //res +="\n";
                StringBuilder resBuilder = new StringBuilder();
                
                resBuilder.append("Nombre               Apellido             Trabaja En \n\n");
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, especialidad);
			rs = pst.executeQuery();
                        String dniAnterior = "";
			
                        //rs.next();
                        
			while (rs.next()){
				//System.out.println("Nombre del medico: " + rs.getString("nombre"));
                                //System.out.println("dni del medico: " + rs.getString("dni"));
                                //res +=rs.getString("nombre")+ "                 " + rs.getString("primerApellido")+ "                            " + rs.getString("centro") + " " + "\n";
                            String nombre = rs.getString("nombre");
                            String apellido = rs.getString("pp");
                            String centro = rs.getString("centro");
                            String dni = rs.getString("dni");
                            
                            
                            String formattedNombre = String.format("%-20s", nombre);
                            String formattedApellido = String.format("%-20s", apellido);  
                            String formattedCentro = String.format("%-20s", centro);
                             //res += formattedNombre + formattedApellido + formattedCentro + "\n";
                            
                             if(!(dniAnterior.equals(dni))){
                            resBuilder.append("\n")
                                    .append(formattedNombre)  
                                    .append(formattedApellido)
                                    .append(formattedCentro)
                                    .append("\n");
                            dniAnterior = dni;
                             }
                             else{
                                 String formattedCentro2 = String.format("%-20s", centro);
                                 resBuilder.append("                                                ");
                                 resBuilder.append(formattedCentro2)
                                           .append("\n");
                             }
                        }

				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar los enfermeros por especialidad: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar los enfermeros por especialidad: ");
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
                System.out.println(res);
                return res;
	}
    }
    

