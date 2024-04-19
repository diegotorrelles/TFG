/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giusistemasalud;

import db.DatabaseSistemaSalud;
import interfaces.PacientesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class PacientesImpl extends DatabaseSistemaSalud implements PacientesInterface {

    @Override
    public String buscarPaciente(String dni) { 
        		String sql = "select pa.nombre as nombre, pa.Primer_Apellido as pp, pa.Segundo_Apellido as sp, pa.comunidad as comunidad, pa.sexo as sexo, en.nombre as enfe, en.descripcion as descr from paciente pa \n"
                + "INNER JOIN paciente_tiene_enfermedad pti ON pa.Dni = pti.dni_paciente\n"
                + "INNER JOIN enfermedad en ON pti.id_enfermedad = en.id_enfermedad\n"
                + "where pa.Dni = ? ;";

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
                                res = "\n";
                                res+= "Nombre del Paciente:" + "              "  + rs.getString("nombre") + " " + rs.getString("pp") + "  " + rs.getString("sp") + "\n";
                                res+= "Sexo:  " + "                                     "  + rs.getString("sexo")+ "               "+"\n";
                                res+= "Comunidad donde Reside: " + "       "  + rs.getString("comunidad")+ "             " + "\n\n";
                                res+= "Enfermedades:" + "\n";
                                res+= rs.getString("enfe") + ": " + rs.getString("descr")+ "\n\n";
                        }
                        else {
                            res = "No existe ningún medico con ese dni";
                            System.out.println("No existe ningún paciente con ese id.");
                        } 
                        
                         while(rs.next()){
                             
                            res+= rs.getString("enfe") + ": " + rs.getString("descr")+ "\n\n";
                        }
                         
				
		} catch (SQLException e) { 
			System.err.println("Error SQL al consultar paciente por ID: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Otro tipo de error al consultar paciente por ID: ");
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
    
}
