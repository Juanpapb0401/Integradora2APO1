package model;

import java.util.Calendar;

public class Etapa {

    private Calendar fechaInicialPlaneada;
    private Calendar fechaFinalPlaneada;
    private Calendar fechaInicialReal;
    private Calendar fechaFinalReal;
    private boolean estado;
    private boolean cumplimiento;
    private TypeEtapa type; 
    private Capsula[] capsulas;
   
    public Etapa(Calendar fechaInicialPlaneada, Calendar fechaFinalPlaneada, boolean estadoCumplimiento, TypeEtapa type, boolean estado){

        this.fechaInicialPlaneada=fechaInicialPlaneada;
        this.fechaFinalPlaneada=fechaFinalPlaneada;
        fechaInicialReal = null;
        fechaFinalReal = null;
        this.estado = estado;
        cumplimiento=estadoCumplimiento;
        this.type=type;
        this.capsulas = new Capsula[50];

    }


    public Capsula[] getCapsulas(){
        return capsulas;
    }

    public Capsula getCapsula(int pos){
        return capsulas[pos];
    }

 

    public boolean getEstado() {
        return estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public boolean getCumplimiento() {
        return cumplimiento;
    }


    public void setCumplimiento(boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }


    public void setFechaFinalReal(Calendar fechaFinal){
        this.fechaFinalReal = fechaFinal;
    }

    public TypeEtapa getTipo(){
        return type;
    }

    public boolean addCapsula(Capsula nuevaCapsula)  {

    for (int i=0; i<capsulas.length; i++){

        if (capsulas[i]==null){
            capsulas[i]=nuevaCapsula;
            return true;

        }
    }
   return false;
}

    public Calendar getFechaInicialPlaneada() {
        return fechaInicialPlaneada;
    }

    public void setFechaInicialPlaneada(Calendar fechaInicialPlaneada) {
        this.fechaInicialPlaneada = fechaInicialPlaneada;
    }

    public Calendar getFechaFinalPlaneada() {
        return fechaFinalPlaneada;
    }

    public void setFechaFinalPlaneada(Calendar fechaFinalPlaneada) {
        this.fechaFinalPlaneada = fechaFinalPlaneada;
    }

    public Calendar getFechaInicialReal() {
        return fechaInicialReal;
    }

    public void setFechaInicialReal(Calendar fechaInicialReal) {
        this.fechaInicialReal = fechaInicialReal;
    }

    public Calendar getFechaFinalReal() {
        return fechaFinalReal;
    }

    public TypeEtapa getType() {
        return type;
    }

    public void setType(TypeEtapa type) {
        this.type = type;
    }

    public void setCapsulas(Capsula[] capsulas) {
        this.capsulas = capsulas;
    }





}
