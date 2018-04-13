/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constantes;

/**
 *
 * @author usuario
 */
public class Proceso implements Runnable{
    private ArrayList<Integer> tiemposInicios;
    private ArrayList<Integer> tiemposFinales;
    
    private int quantum = 2;
    private String nombre, texto;
    private int tiempoLlegada, tiempoInicioAbsoluto, tiempoEspera, tiempoFinalTotal, 
            rafaga, prioridad, tiempoRetorno, tiempoFinalizacion, tiempoEnCola;
    private ListenerHilos listener;
    
    // Para por donde se quedó
    private int reemplazosRealizados;

    public Proceso(String nombre, String texto, int tiempoLlegada, int prioridad) {
        this.nombre = nombre;
        this.texto = texto;
        this.tiempoLlegada = tiempoLlegada;
        this.rafaga = calcularRafaga();
        this.prioridad = prioridad;
        this.tiempoFinalizacion = -1;
        this.reemplazosRealizados = 0;
        this.tiempoInicioAbsoluto = -1;
        this.tiempoEspera = -1;
        this.tiempoRetorno = -1;
        this.tiempoEnCola = 0;
        tiemposInicios = new ArrayList<>();
        tiemposFinales = new ArrayList<>();
       
    }

    public void agregarTiempoInicio(int tiempo){
        tiemposInicios.add(tiempo);
    }
    
    public void agregarTiempoFinal(int tiempo){
        tiemposFinales.add(tiempo);
    }
   
    
    public void aumentarTiempoEnCola(int tiempo){
        tiempoEnCola += tiempo;
    }
    
    public int getTiempoFinalTotal() {
        return tiempoFinalTotal;
    }

    public void setTiempoFinalTotal(int tiempoFinal) {
        this.tiempoFinalTotal = tiempoFinal;
    }

    public int getTiempoInicioAbsoluto() {
        return tiempoInicioAbsoluto;
    }

    public void setTiempoInicioAbsoluto(int tiempoInicio) {
        this.tiempoInicioAbsoluto = tiempoInicio;
    }
    
    
    public void setListenerHilo(ListenerHilos listener){
        this.listener = listener;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public int calcularTiempoRetorno(){
        tiempoRetorno = tiempoFinalTotal - tiempoLlegada;
        
        return tiempoRetorno;
    }
    
    public int calcularTiempoEspera(){
        tiempoEspera = tiempoInicioAbsoluto - tiempoLlegada;
        
        if(tiemposInicios.size() > 1){
            for(int tiempo = 1; tiempo < tiemposInicios.size(); tiempo++){
                tiempoEspera += tiemposInicios.get(tiempo) - tiemposFinales.get(tiempo - 1);
            }
        }
        
        return tiempoEspera;
    }
 
    //Cuenta las "S" o "s" en el texto
    public int calcularRafaga(){
        int rafaga = 0;
        
        for(int i=0; i < texto.length(); i++){
            if(texto.charAt(i) == 'S' || texto.charAt(i) == 's'){
                rafaga++;
            }
        }
        
        return rafaga;
    }

    public int getReemplazosRealizados() {
        return reemplazosRealizados;
    }

    public void setReemplazosRealizados(int reemplazosRealizados) {
        this.reemplazosRealizados = reemplazosRealizados;
    }
    
    

    @Override
    public void run() { 
        int contadorReemplazos = 0;
      
        int i = 0;
        
        // Mientras no se supere el quantum, tampoco se supere el tamaño del texto, o
        // mientras no se haya alcanzado el numero de refagas, o si la prioridad es alta
        while((contadorReemplazos < quantum && reemplazosRealizados < rafaga) || prioridad == 0 && i < texto.length()){
            if(texto.charAt(i) == 'S' || texto.charAt(i) == 's'){
                listener.caracterProcesado(this, texto, i);
                
                reemplazosRealizados++;
                contadorReemplazos++;

                StringBuilder stringBuilder = new StringBuilder(texto);
                stringBuilder.setCharAt(i, 'x');// cambiamos el caracter 's' por el 'x'
                texto = stringBuilder.toString();
 
                try {
                    // Hacemos una pausa para poder apreciar la palabra
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            i++;
        }
        
        
        listener.notificar(this, reemplazosRealizados == rafaga ? Constantes.TERMINO_RAFAGA : Constantes.TERMINO_QUANTUM);
    }
}
