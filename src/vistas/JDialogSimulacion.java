/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelos.ListenerHilos;
import modelos.Proceso;
import utils.Constantes;

/**
 *
 * @author usuario
 */
public class JDialogSimulacion extends javax.swing.JDialog implements ListenerHilos{

    private ArrayList<Proceso> procesos;
    private ArrayList<Proceso> cola;
    private ArrayList<Proceso> terminados;
    
    private String [][] datos = {};
    
    private int tiempo;
    private DefaultTableModel modeloCola;
    private DefaultTableModel modeloTerminados;
    private DefaultTableModel modeloHistorico;
    
    private boolean estaEjecutando;
    
    private Thread hiloActual;
    
    /**
     * Creates new form JDialogSimulacion
     */
    public JDialogSimulacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
    public JDialogSimulacion(java.awt.Frame parent, boolean modal, ArrayList<Proceso> procesos) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.estaEjecutando = false;
        this.tiempo = 0;
        
        hiloActual = null;
        this.terminados = new ArrayList<>();
        this.procesos = procesos;
        this.cola = new ArrayList<>();
        this.cola.add( procesos.get(0) );// al principio el primero proceso es el listo
        
        for(Proceso proceso : procesos){
            proceso.setListenerHilo(this);
        }
        
        //Listos
        String [] cabeceraListos = {"NOMBRE", "TIEMPO LLEGADA", "RAFAGA", "PRIORIDAD"};
        modeloCola = new DefaultTableModel(datos, cabeceraListos);
        jTableCola.setModel(modeloCola);
        jTableCola.setEnabled(false);
        
        //Terminados
        String [] cabeceraTerminados = {"NOMBRE", "LLEGADA", "INICIO", "FINAL", "ESPERA", "RETORNO", "RAFAGA", "PRIORIDAD"};
        modeloTerminados = new DefaultTableModel(datos, cabeceraTerminados);
        jTableTerminados.setModel(modeloTerminados);
        jTableTerminados.setEnabled(false);
        
        //Historico
        String [] cabeceraHistorico = {"NOMBRE", "TIEMPO"};
        modeloHistorico = new DefaultTableModel(datos, cabeceraHistorico);
        jTableHistorico.setModel(modeloHistorico);
        jTableHistorico.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEjecucion = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCola = new javax.swing.JTable();
        jLabelTituloListos1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTerminados = new javax.swing.JTable();
        jLabelTituloListos2 = new javax.swing.JLabel();
        jTextFieldPalabra = new javax.swing.JTextField();
        jLabelTituloListos3 = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jLabelTituloListos4 = new javax.swing.JLabel();
        jLabelTituloListos5 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEjecucion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelEjecucion.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelEjecucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 270, 30));

        jLabelTitulo1.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("SIMULACION");
        getContentPane().add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 270, 40));

        jTableCola.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableCola);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 670, 140));

        jLabelTituloListos1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloListos1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloListos1.setText("Historico");
        getContentPane().add(jLabelTituloListos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 100, 30));

        jTableTerminados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableTerminados);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 670, 150));

        jLabelTituloListos2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloListos2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloListos2.setText("Texto procesado");
        getContentPane().add(jLabelTituloListos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 170, 30));

        jTextFieldPalabra.setEditable(false);
        jTextFieldPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPalabraActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPalabra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 260, 30));

        jLabelTituloListos3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloListos3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloListos3.setText("Procesos terminados");
        getContentPane().add(jLabelTituloListos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 30));

        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 250, 40));

        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableHistorico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 150, 510));

        jLabelTituloListos4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloListos4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloListos4.setText("Cola");
        getContentPane().add(jLabelTituloListos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 270, 30));

        jLabelTituloListos5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTituloListos5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloListos5.setText("Proceso en ejecución:");
        getContentPane().add(jLabelTituloListos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 270, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo_azul.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPalabraActionPerformed

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        // TODO add your handling code here:
        /*if(!estaEjecutando){
            ejecutarProceso();
            
            jButtonIniciar.setText("Pausar");
            
            estaEjecutando = true;
        }else{
            hiloActual.stop();
            
            estaEjecutando = false;
            
            jButtonIniciar.setText("Iniciar");
        }*/
        
        ejecutarProceso();
        
    }//GEN-LAST:event_jButtonIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogSimulacion dialog = new JDialogSimulacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabelEjecucion;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTituloListos1;
    private javax.swing.JLabel jLabelTituloListos2;
    private javax.swing.JLabel jLabelTituloListos3;
    private javax.swing.JLabel jLabelTituloListos4;
    private javax.swing.JLabel jLabelTituloListos5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCola;
    private javax.swing.JTable jTableHistorico;
    private javax.swing.JTable jTableTerminados;
    private javax.swing.JTextField jTextFieldPalabra;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notificar(Proceso proceso, int mensaje) {
        System.out.println("Proceso "+proceso.getNombre()+", mensaje: "+mensaje);
        
        switch(mensaje){
            case Constantes.TERMINO_QUANTUM:
                proceso.agregarTiempoFinal(tiempo);
                
                // Lo metemos a listos
                cola.add(proceso);
                
                actualizarTablaCola(cola);
                
                break;
            case Constantes.TERMINO_RAFAGA:
                proceso.agregarTiempoFinal(tiempo);
                proceso.setTiempoFinalTotal(tiempo);
                              
                //  Lo metemos a terminados
                terminados.add(proceso);
                
                actualizarTablaTerminados(terminados);
                break;
        }
        
        ejecutarProceso();
    }
    
    private void ejecutarProceso(){
        if(cola.size() > 0){
            // Ejecutamos el primer proceso que esté en la lista
            Proceso proceso = cola.remove(0);
            
            proceso.agregarTiempoInicio(tiempo);
            
            // Si es la primera vez que se ejecuta seteamos el tiemo inicio
            if(proceso.getTiempoInicioAbsoluto() == -1){
                proceso.setTiempoInicioAbsoluto(tiempo);
            }
            
            /*if(hiloActual != null){
                hiloActual.resume();
            }else{
                hiloActual = new Thread( proceso );
                hiloActual.start();
            }*/
            
            hiloActual = new Thread( proceso );
            hiloActual.start();
        }else{
            jTextFieldPalabra.setText("");
        }
    }

    @Override
    public void caracterProcesado(Proceso proceso, String texto, int pos) {
        System.out.println("posicion caracter " + pos);
        
        jLabelEjecucion.setText(proceso.getNombre());

        jTextFieldPalabra.setText(texto);
        
        jTextFieldPalabra.requestFocus();
        jTextFieldPalabra.select(pos, pos+1);
        jTextFieldPalabra.setSelectedTextColor(Color.red);
        
        
        tiempo++;
        
        System.out.println("Tiempo "+tiempo);
        
        // Vemos que procesos entran en este tiempo
        for(Proceso p : procesos){
            if(p.getTiempoLlegada() == tiempo){
                cola.add(p);
            }
        }
        
        actualizarTablaCola(cola);
        agregarProcesoAlHistorico(proceso.getNombre(), tiempo + "");

    }
    
    private void actualizarTablaCola(ArrayList<Proceso> cola){
        modeloCola.setRowCount(0);// Limpiamos la tabla
        
        for(Proceso proceso : cola){
            Object [] row = new Object[] {proceso.getNombre(), proceso.getTiempoLlegada(),
                                        proceso.getRafaga(), Constantes.describirPrioridad( proceso.getPrioridad() )};
        
            modeloCola.addRow(row);
        }
    }
    
    private void actualizarTablaTerminados(ArrayList<Proceso> terminados){
        modeloTerminados.setRowCount(0);// Limpiamos la tabla
        
        for(Proceso proceso : terminados){
            Object [] row = new Object[] {proceso.getNombre(), proceso.getTiempoLlegada(), 
                                        proceso.getTiempoInicioAbsoluto(), proceso.getTiempoFinalTotal(),
                                        proceso.calcularTiempoEspera(), proceso.calcularTiempoRetorno(),
                                        proceso.getRafaga(), Constantes.describirPrioridad( proceso.getPrioridad() )};
        
            modeloTerminados.addRow(row);
        }
    }
    
    private void agregarProcesoAlHistorico(String nombre, String tiempo){
        modeloHistorico.addRow(new Object[] { nombre, tiempo });
       
    }
}