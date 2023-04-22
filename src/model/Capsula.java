package model;

public class Capsula {

    private String identificador;
    private String descripcion;
    private TipoCapsula type;
    private String nombreColaborador;
    private String cargoColaborador;
    private String leccion;
    private boolean aprobar;
    private boolean publicar;


    public Capsula(String identificador, String descripcion, TipoCapsula type, String nombreColaborador, String cargoColaborador, String leccion, boolean aprobar, boolean publicar){

        this.identificador=identificador;
        this.descripcion=descripcion;
        this.type=type;
        this.nombreColaborador=nombreColaborador;
        this.cargoColaborador=cargoColaborador;
        this.leccion=leccion;
        this.aprobar=false;
        this.publicar=false;
    }

    public String getIdentificador(){
        return identificador;
    }

    public String getLeccion(){
        return leccion;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setType(TipoCapsula type) {
        this.type = type;
    }

    public String getNombreColaborador() {
        return nombreColaborador;
    }

    public void setNombreColaborador(String nombreColaborador) {
        this.nombreColaborador = nombreColaborador;
    }

    public String getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(String cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }

    public void setLeccion(String leccion) {
        this.leccion = leccion;
    }

    public TipoCapsula getType(){
        return type;
    }

    
    public boolean getAprobar() {
        return aprobar;
    }

    public void setAprobar(boolean aprobar) {
        this.aprobar = aprobar;
    }

    public boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicado) {
        this.publicar = publicado;
    }

    

    
}


