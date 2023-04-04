package model;

import java.util.Calendar;

public class Etapa {

    private Calendar fechaInicialPlaneada;
    private Calendar fechaFinalPlaneada;
    private Calendar fechaInicialReal;
    private Calendar fechaFinalReal;
    private boolean aprobacionCumplimiento;
    private Type type; 
   


    public Etapa(int meses, int añoInicialReal, int mesInicialReal, int diaInicialReal, int añoFinalReal, int mesFinalReal, int diaFinalReal, boolean aprobacionCumplimiento, Type type){

        this.fechaInicialPlaneada=fechaInicialPlaneada;
        this.fechaFinalPlaneada=fechaFinalPlaneada;
        this.fechaInicialReal=Calendar.getInstance();
        fechaInicialReal.set(añoInicialReal,mesInicialReal,diaInicialReal);
        this.fechaFinalReal=Calendar.getInstance();
        fechaFinalReal.set(añoFinalReal,mesFinalReal,añoFinalReal);
        this.aprobacionCumplimiento=aprobacionCumplimiento;
        this.type=type;

    }
    
    public enum Type{

        INICIO, ANALISIS, DISEÑO, EJECUCCION, CIERRE_SEGUIMIENTO, CONTROL_PROYECTO;
    }




}
