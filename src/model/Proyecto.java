package model;

import java.util.Calendar;

import model.Etapa.Type;

public class Proyecto{
     
    private String nombreProyecto;
    private String nombreCliente;
    private Calendar fechaInicio;
    private Calendar fechaFinal;
    private double presupuestoProyecto;
    private String nombreGerente;
    private String numeroGerente;
    private Etapa[] etapas;

    public Proyecto(String nombreProyecto, String nombreCliente, int diaInicial, int mesInicial, int añoInicial, int diaFinal, int mesFinal, int añoFinal, double presupuestoProyecto, String numeroGerente, String nombreGerente){

        this.nombreProyecto=nombreProyecto;
        this.nombreCliente=nombreCliente;
        this.fechaInicio=Calendar.getInstance();
        fechaInicio.set(añoInicial,mesInicial,diaInicial);
        this.fechaFinal=Calendar.getInstance();
        fechaFinal.set(añoFinal,mesFinal,añoFinal);
        this.presupuestoProyecto=presupuestoProyecto;
        this.nombreGerente=nombreGerente;
        this.numeroGerente=numeroGerente;
        this.etapas= new Etapa[6];
    
    }

    public String getNombreProyecto(){
        return nombreProyecto;
    }

    public String toString(){
        
        String msg= "";
        msg= "El nombre del proyecto: "+ nombreProyecto+ "\nNombre del cliente: "+ nombreCliente+ "\nLa fecha de inicio del proyecto: "+ fechaInicio+ "\nFecha de supuesta finalizacion del proyecto: "+ fechaFinal+ "\nEl presupuesto del proyecto: "+presupuestoProyecto+"\nLos nombres de los gerentes: "+nombreGerente+"Numero de lo gerentes: "+numeroGerente;

        return msg;
    }

    public void seisEtapas(int[] mesesEtapas){
        etapas[0]= new Etapa(0, 0, 0, 0, 0, 0, 0, false, Type.INICIO);
        etapas[1]= new Etapa(0, 0, 0, 0, 0, 0, 0, false, Type.ANALISIS);
        etapas[2]= new Etapa(0, 0, 0, 0, 0, 0, 0, false, Type.EJECUCCION);
        etapas[3]= new Etapa(0, 0, 0, 0, 0, 0, 0, false,Type.CIERRE_SEGUIMIENTO);
        etapas[4]= new Etapa(0, 0, 0, 0, 0, 0, 0, false, Type.CONTROL_PROYECTO);
        etapas[5]= new Etapa(0, 0, 0, 0, 0, 0, 0, false, Type.CONTROL_PROYECTO);
    }
}