/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Proceso;
import utils.Constantes;

/**
 *
 * @author usuario
 */
public class JFramePrincipal extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private String [][] datos = {};
    private ArrayList<Proceso> procesos;
    
    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
        procesos = new ArrayList<>();
        
        this.setLocationRelativeTo(null);
        
        // Establecemos la cabecera y el array de datos que contendra la tabla mediante el modelo
        String [] cabecera = {"NOMBRE", "TIEMPO LLEGADA", "RAFAGA", "PRIORIDAD"};
        modelo = new DefaultTableModel(datos, cabecera);
        jTableProcesos.setModel(modelo);
        jTableProcesos.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldQuantum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProcesos = new javax.swing.JTable();
        jButtonAgregarProceso = new javax.swing.JButton();
        jButtonIniciarSimulacion = new javax.swing.JButton();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelNombre3 = new javax.swing.JLabel();
        jTextFieldNombreProceso1 = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("PROCESOS");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 270, 40));

        jLabelNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Texto: ");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, -1));

        jTextFieldQuantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantumActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQuantum, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 140, 30));

        jTextAreaTexto.setColumns(20);
        jTextAreaTexto.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTexto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 400, 130));

        jTableProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableProcesos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 490, 170));

        jButtonAgregarProceso.setText("AGREGAR PROCESO");
        jButtonAgregarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProcesoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 230, 40));

        jButtonIniciarSimulacion.setText("IR A SIMULACION");
        jButtonIniciarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSimulacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciarSimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 230, 40));

        jLabelNombre2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre2.setText("Quantum");
        getContentPane().add(jLabelNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 100, -1));

        jLabelNombre3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre3.setText("Nombre:");
        getContentPane().add(jLabelNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, -1));

        jTextFieldNombreProceso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProceso1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombreProceso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo_rojo.jpg"))); // NOI18N
        jLabelFondo.setText("jLabelFondo");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 560, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantumActionPerformed

    private void jButtonAgregarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProcesoActionPerformed
        // TODO add your handling code here:
        if(verificarCampos()){
            String nombre = jTextFieldNombreProceso1.getText();
            String texto = jTextAreaTexto.getText();
            int tiempoLlegada = procesos.size();
            int prioridad = generarPrioridad();
            int quantum = Integer.parseInt( jTextFieldQuantum.getText() );
            
            Proceso proceso = new Proceso(nombre, texto, tiempoLlegada, prioridad);
            proceso.setQuantum(quantum);
            
            jTextFieldQuantum.setEnabled(false);
            
            procesos.add(proceso);
            
            Object [] row = new Object[] {nombre, tiempoLlegada, proceso.getRafaga(), Constantes.describirPrioridad(prioridad)};
            
            modelo.addRow(row);
        }
    }//GEN-LAST:event_jButtonAgregarProcesoActionPerformed

    private void jButtonIniciarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSimulacionActionPerformed
        // TODO add your handling code here:
        if(jTableProcesos.getModel().getRowCount() > 0){
            JDialogSimulacion jdSimulacion = new JDialogSimulacion(this, rootPaneCheckingEnabled, procesos);
            jdSimulacion.setVisible(true);
            
            dispose();
        }else{
            Utilidades.mostrarMensaje("Advertencia", "No tiene procesos agregados");
        }
    }//GEN-LAST:event_jButtonIniciarSimulacionActionPerformed

    private void jTextFieldNombreProceso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProceso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProceso1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }
    
    private boolean verificarCampos(){
        if(jTextFieldNombreProceso1.getText().trim().isEmpty()){
            Utilidades.mostrarMensaje("Advertencia", "Debe ingresar el nombre");
            
            return false;
        }
        
        if(jTextAreaTexto.getText().trim().isEmpty()){
            Utilidades.mostrarMensaje("Advertencia", "Debe ingresar el texto a procesar");
            
            return false;
        }
        
        if(jTextFieldQuantum.getText().trim().isEmpty()){
            Utilidades.mostrarMensaje("Advertencia", "Debe ingresar el quantum");
            
            return false;
        }
        
        return true;
    }
    
    private int generarPrioridad(){
        return ( (int) (Math.random() * 3) );
    }
   
    
    private void agregarProceso(Proceso proceso){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProceso;
    private javax.swing.JButton jButtonIniciarSimulacion;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProcesos;
    private javax.swing.JTextArea jTextAreaTexto;
    private javax.swing.JTextField jTextFieldNombreProceso1;
    private javax.swing.JTextField jTextFieldQuantum;
    // End of variables declaration//GEN-END:variables
}
