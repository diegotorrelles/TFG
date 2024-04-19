/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.CentroSaludInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class CentroSaludImpl extends DatabaseSistemaSalud implements CentroSaludInterface {

    @Override
    public String buscarCentroSaludPorComunidades(String comunidad) {
        
        		String sql = " select cs.nombre as nombrecentro, cs.tipo as tipo, es.nombre as especialidad from centro_de_salud cs\n" +
"		INNER JOIN centro_salud_tiene_especialidad cste ON cste.nombre = cs.nombre and \n" +
"        cste.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        INNER JOIN especialidad es ON cste.id_especialidad = es.id_especialidad\n" +
"        where cs.comunidad = ? ;";
		
		this.openConnection();
		
                //String res = "";
                StringBuilder resBuilder = new StringBuilder();
                
                resBuilder.append("Nombre del Centro                                Tipo                        \n\n");
		PreparedStatement pst = null;
		ResultSet rs = null;
                String nombreAnterior = "";
                int variante = 1;
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, comunidad);
			rs = pst.executeQuery();
			
			while (rs.next()){
				//System.out.println("Nombre del medico: " + rs.getString("nombre"));
                                
                            String nombre = rs.getString("nombrecentro");
                            String tipo = rs.getString("tipo");
                            String especialidad = rs.getString("especialidad");
                            
                            
                            
                            String formattedNombre = String.format("%-30s", nombre);
                            String espacio1 = String.format("%-20s","");
                            String formattedTipo = String.format("%-50s", tipo);  
                            String formattedEspecialidad = String.format("%-20s", especialidad);
                            
                             //res += formattedNombre + formattedApellido + formattedCentro + "\n";
                            
                             if(!(nombreAnterior.equals(nombre)) ){
                            resBuilder.append("\n")
                                    .append(formattedNombre)
                                    .append(espacio1)
                                    //.append("               ")
                                    .append(formattedTipo)
                                    .append("\n\n")
                                    .append("Especialidades:")
                                    .append("\n")
                                    .append(formattedEspecialidad)
                                    .append("\n");
                            variante = 2;
                            nombreAnterior = nombre;
                             }
                             else {
                                 resBuilder.append(formattedEspecialidad)
                                           .append("\n");  
                             }
                             
                             }
                                	
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar los centros de salud por comunidad: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar los centros de salud por comunidad: ");
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
  
    @Override
    public String buscarCentroSaludPorEspecialidad(String especialidad) {
                		String sql = " select cs.nombre as nombrecentro, cs.tipo as tipo, cs.comunidad as comunidad from centro_de_salud cs\n" +
"		INNER JOIN centro_salud_tiene_especialidad cste ON cste.nombre = cs.nombre and \n" +
"        cste.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        INNER JOIN especialidad es ON cste.id_especialidad = es.id_especialidad\n" +
"        where es.nombre = ? ;";
		
		this.openConnection();
		
                //String res = "";
                StringBuilder resBuilder = new StringBuilder();
                resBuilder.append(String.format("%-50s",""));
                resBuilder.append(especialidad + "\n\n");
		PreparedStatement pst = null;
		ResultSet rs = null;
                
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, especialidad);
			rs = pst.executeQuery();
			
			while (rs.next()){
				//System.out.println("Nombre del medico: " + rs.getString("nombre"));
                                
                            String nombre = rs.getString("nombrecentro");
                            String tipo = rs.getString("tipo");
                            String comunidad = rs.getString("comunidad");
                      
                            String formattedNombre = String.format("%-20s", nombre);
                            String formattedTipo = String.format("%-30s", tipo);  
                            String formattedComunidad = String.format("%-20s", comunidad);
                             //res += formattedNombre + formattedApellido + formattedCentro + "\n";
                            resBuilder.append("\n") 
                                    .append("Nombre del Centro Sanitario:")
                                    .append(String.format("%-10s",""))
                                    .append(formattedNombre)  
                                    .append("\n")
                                    .append("Tipo del Centro:")
                                    .append(String.format("%-29s",""))
                                    .append(formattedTipo)
                                    .append("\n")
                                    .append("Comunidad:")
                                    .append(String.format("%-34s",""))
                                    .append(formattedComunidad)
                                    .append("\n");
                                
                        }
                     
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar los centros de salud por Especialidad: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar los centros de salud por Especialidad: ");
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

   
    

