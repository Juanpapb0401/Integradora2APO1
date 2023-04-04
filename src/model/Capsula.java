package model;

public class Capsula {

    private String identificador;
    private String descripcion;
    private Type type;
    private String nombreColaborador;
    private String cargoColaborador;
    private String leccion;


    public Capsula(String identificador, String descripcion, String tipo, String nombreColaborador, String cargoColaborador, String leccion){

        this.identificador=identificador;
        this.descripcion=descripcion;
        this.type=type;
        this.nombreColaborador=nombreColaborador;
        this.cargoColaborador=cargoColaborador;
        this.leccion=leccion;
    }

    public String getIdentificador(){
        return identificador;
    }

    public enum Type{

        TECNICO, GESTION, DOMINIO, EXPERIENCIAS;
    }



}


