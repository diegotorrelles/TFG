/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.MedicosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diego
 */


public class MedicosImpl extends DatabaseSistemaSalud implements MedicosInterface {

    @Override
    public void queryMedicos() {
       String sql = "SELECT * FROM medico;";
		Statement st = null;
		ResultSet rs = null;

                 this.openConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("Consulta ejecutada correctamente.");

			while (rs.next()) {
				System.out.println(" - " + rs.getString("nombre"));
			}
		} catch (SQLException e) {
			System.err.println("Error SQL al ejecutar la consulta de las cervezas:");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al ejecutar la consulta de las cervezas:");
			System.err.println(e.getMessage());
		} finally {
			try {
				if (st!=null) st.close();
				if (rs!=null) rs.close();
			} catch (SQLException e) {
				System.err.println("Error al liberar los recursos:");
				System.err.println(e.getMessage());
			}
		}
    }

    public String buscaMedico(String dni) {
        
		String sql = " select m.Primer_Apellido as pp,m.Segundo_Apellido as sp ,"
                        + "m.nombre as nombre, cs.nombre as centro, es.nombre as especialidad from medico m\n" +
"		INNER JOIN medico_tiene_especialidad mte ON m.Dni = mte.dni_medico\n" +
"        INNER JOIN especialidad es ON mte.id_especialidad = es.id_especialidad\n" +
"        INNER JOIN medico_trabaja_Centro_Salud mtcs ON mtcs.dni_medico = m.Dni\n" +
"        INNER JOIN centro_de_salud cs ON mtcs.nombre_Centro_Salud = cs.nombre and \n" +
"        mtcs.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        where m.Dni= ?;";
		
		this.openConnection();
		
                String res = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, dni);
			rs = pst.executeQuery();
			
			if (rs.next()){
				//System.out.println("Nombre del medico: " + rs.getString("nombre"));
                                res = "Nombre del medico: " + rs.getString("nombre") + "    " + rs.getString("pp") + "    " + rs.getString("sp") + "\n\n";
                                res+= "Especialidad: " + rs.getString("especialidad") + "\n\n";
                                res+= "Centro Sanitario Donde trabaja:  " + rs.getString("centro");
                        }
                        else {
                            res = "No existe ningún medico con ese dni";
                            System.out.println("No existe ningún medico con ese id.");
                        }
				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar medico por ID: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar medico por ID: ");
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
    public String buscarMedicosEspecialidad(String especialidad) {
        String sql = " select m.Primer_Apellido as primerApellido ,m.nombre as nombre, cs.nombre as centro from medico m\n" +
"		INNER JOIN medico_tiene_especialidad mte ON m.Dni = mte.dni_medico\n" +
"        INNER JOIN especialidad es ON mte.id_especialidad = es.id_especialidad\n" +
"        INNER JOIN medico_trabaja_Centro_Salud mtcs ON mtcs.dni_medico = m.Dni\n" +
"        INNER JOIN centro_de_salud cs ON mtcs.nombre_Centro_Salud = cs.nombre and \n" +
"        mtcs.fecha_inauguracion = cs.fecha_inauguracion\n" +
"        where es.nombre= ?;";
		
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
			
                        //rs.next();
                        
			while (rs.next()){
				//System.out.println("Nombre del medico: " + rs.getString("nombre"));
                                //System.out.println("dni del medico: " + rs.getString("dni"));
                                //res +=rs.getString("nombre")+ "                 " + rs.getString("primerApellido")+ "                            " + rs.getString("centro") + " " + "\n";
                            String nombre = rs.getString("nombre");
                            String apellido = rs.getString("primerApellido");
                            String centro = rs.getString("centro");

                            String formattedNombre = String.format("%-20s", nombre);
                            String formattedApellido = String.format("%-20s", apellido);  
                            String formattedCentro = String.format("%-20s", centro);
                             //res += formattedNombre + formattedApellido + formattedCentro + "\n";
                             
                            resBuilder.append(formattedNombre)  
                                    .append(formattedApellido)
                                    .append(formattedCentro)
                                    .append("\n");
                        }

				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar los medicos por especialidad: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar los medicos por especialidad: ");
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

   
    

   

   
    

