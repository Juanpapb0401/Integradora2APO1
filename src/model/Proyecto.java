package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Proyecto{
     
    private String nombreProyecto;
    private String nombreCliente;
    private Calendar fechaInicio;
    private Calendar fechaFinal;
    private double presupuestoProyecto;
    private String nombreGerente;
    private String numeroGerente;
    private Etapa[] etapas;

    public Proyecto(String nombreProyecto, String nombreCliente, Calendar fechaInicio, Calendar fechaFinal, double presupuestoProyecto, String numeroGerente, String nombreGerente, int[] mesesEtapas){

        this.nombreProyecto=nombreProyecto;
        this.nombreCliente=nombreCliente;
        this.fechaInicio=fechaInicio;
        this.fechaFinal=fechaFinal;
        this.presupuestoProyecto=presupuestoProyecto;
        this.nombreGerente=nombreGerente;
        this.numeroGerente=numeroGerente;      
        seisEtapas(mesesEtapas);
    
    }


    public String getNombreProyecto(){
        return nombreProyecto;
    }

    public Etapa[] getEtapas(){
        return etapas;
    }

    public int getEtapaActiva(){
        
        int etapa = -1;
            
        for(int i=0;i<etapas.length;i++){
           
            if(etapas[i].getEstado()==true){
                return i;
            }
        }
        return etapa;
    }

    public String toString(){
        
        String msg= "";
        msg= "El nombre del proyecto: "+ nombreProyecto+ "\nNombre del cliente: "+ nombreCliente+ "\nLa fecha de inicio del proyecto: "+ fechaInicio+ "\nFecha de supuesta finalizacion del proyecto: "+ fechaFinal+ "\nEl presupuesto del proyecto: "+presupuestoProyecto+"\nLos nombres de los gerentes: "+nombreGerente+"Numero de lo gerentes: "+numeroGerente;

        return msg;
    }

    public void seisEtapas(int[] mesesEtapas){
        this.etapas= new Etapa[6];

        Calendar fechaInicialPlanned0 = fechaInicio;
        Calendar fechaFinalPlanned0 = fechaInicio;

        fechaFinalPlanned0.add(Calendar.MONTH, mesesEtapas[0]);

        etapas[0]= new Etapa(fechaInicialPlanned0, fechaFinalPlanned0, true, TypeEtapa.INICIO, true);
        
        Calendar fechaFinalPlanned1 = fechaFinalPlanned0;

        fechaFinalPlanned1.add(Calendar.MONTH, mesesEtapas[1]);
      
        etapas[1]= new Etapa(fechaFinalPlanned0, fechaFinalPlanned1, false, TypeEtapa.ANALISIS, false);
        
        Calendar fechaFinalPlanned2= fechaFinalPlanned1;

        fechaFinalPlanned2.add(Calendar.MONTH,mesesEtapas[2]);

        etapas[2]= new Etapa(fechaFinalPlanned1, fechaFinalPlanned2, false, TypeEtapa.DISEÑO, false);

        Calendar fechaFinalPlanned3= fechaFinalPlanned2;

        fechaFinalPlanned3.add(Calendar.MONTH,mesesEtapas[3]);

        etapas[3]= new Etapa(fechaFinalPlanned2, fechaFinalPlanned3, false, TypeEtapa.EJECUCCION, false);

        Calendar fechaFinalPlaneed4 = fechaFinalPlanned3;

        fechaFinalPlaneed4.add(Calendar.MONTH, mesesEtapas[4]);

        etapas[4]= new Etapa(fechaFinalPlanned3, fechaFinalPlaneed4, false, TypeEtapa.CIERRE_SEGUIMIENTO, false);

        Calendar fechaFinalPlanned5 = fechaFinalPlaneed4;

        fechaFinalPlanned5.add(Calendar.MONTH, mesesEtapas[5]);
        
        etapas[5]= new Etapa(fechaFinalPlaneed4, fechaFinalPlanned5, false, TypeEtapa.CONTROL_PROYECTO, false);
        
    }
}