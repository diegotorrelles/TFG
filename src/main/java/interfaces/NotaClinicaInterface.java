/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author diego
 */
public interface NotaClinicaInterface {
    
    public String buscarNotaClinica(String dniPaciente);
    public String agregarNotaClinica(String dniPaciente,String dniMedico,String texto);
    
}
