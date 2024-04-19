/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import com.mycompany.giusistemasalud.NotaClinicaImpl;
import java.awt.Color;

/**
 *
 * @author diego
 */
public class NotaClinica extends javax.swing.JPanel {

    /**
     * Creates new form NotaClinica
     */
    public NotaClinica() {
        initComponents();
        InitStyles();
    }
    
     private void InitStyles(){
        EtiquetaDniMedico.putClientProperty("FlatLaf.style", "font: 14 $light.font");
        EtiquetaDniMedico.setForeground(Color.BLACK);
        EtiquetaDniPaciente.putClientProperty("FlatLaf.style", "font: 14 $light.font");
        EtiquetaDniPaciente.setForeground(Color.BLACK);
        TextFieldDniMedico.putClientProperty("JTextField.placeholderText", "Ingrese el Dni del Medico");
        TextFieldDniPaciente.putClientProperty("JTextField.placeholderText", "Ingrese el Dni del Paciente");
        Texto.putClientProperty("FlatLaf.style", "font: 16 $light.font");
        Texto.setForeground(Color.BLACK);
        
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EtiquetaDniPaciente = new javax.swing.JLabel();
        TextFieldDniPaciente = new javax.swing.JTextField();
        EtiquetaDniMedico = new javax.swing.JLabel();
        TextFieldDniMedico = new javax.swing.JTextField();
        BotonBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Texto = new javax.swing.JTextArea();

        EtiquetaDniPaciente.setText("Dni Paciente");

        TextFieldDniPaciente.setText("Ingrese Dni del Paciente");
        TextFieldDniPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldDniPacienteMouseClicked(evt);
            }
        });

        EtiquetaDniMedico.setText("Dni Medico");

        TextFieldDniMedico.setText("Ingrese Dni del Medico");
        TextFieldDniMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldDniMedicoMouseClicked(evt);
            }
        });
        TextFieldDniMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldDniMedicoActionPerformed(evt);
            }
        });

        BotonBuscar.setText("Buscar Nota Clinica");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Nota Clinica");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Texto.setColumns(20);
        Texto.setRows(5);
        jScrollPane1.setViewportView(Texto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(EtiquetaDniPaciente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TextFieldDniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EtiquetaDniMedico)
                            .addComponent(TextFieldDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 450, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtiquetaDniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtiquetaDniMedico)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotonBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldDniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldDniMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldDniMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldDniMedicoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(Texto.getText() != "" && TextFieldDniMedico.getText().length() == 9 && TextFieldDniPaciente.getText().length() == 9){
            NotaClinicaImpl prob = new NotaClinicaImpl();
            String res = prob.agregarNotaClinica(TextFieldDniPaciente.getText(), TextFieldDniMedico.getText(), Texto.getText());
            Texto.setText(res);
            TextFieldDniPaciente.setText("");
            TextFieldDniMedico.setText("");
           
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        NotaClinicaImpl prob = new NotaClinicaImpl();
        String res = prob.buscarNotaClinica(TextFieldDniPaciente.getText());
        Texto.setText(res);
        Texto.setCaretPosition(0);
        TextFieldDniPaciente.setText("");
        
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void TextFieldDniPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldDniPacienteMouseClicked
        TextFieldDniPaciente.setText("");
    }//GEN-LAST:event_TextFieldDniPacienteMouseClicked

    private void TextFieldDniMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldDniMedicoMouseClicked
       TextFieldDniMedico.setText("");
    }//GEN-LAST:event_TextFieldDniMedicoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JLabel EtiquetaDniMedico;
    private javax.swing.JLabel EtiquetaDniPaciente;
    private javax.swing.JTextField TextFieldDniMedico;
    private javax.swing.JTextField TextFieldDniPaciente;
    private javax.swing.JTextArea Texto;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
