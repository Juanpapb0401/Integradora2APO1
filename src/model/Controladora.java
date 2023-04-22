package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controladora {

    private Proyecto[] proyectos;

    public Controladora(){
        proyectos=new Proyecto[10];
        int[] array = new int[6];
        array[0] = 1;array[1] = 1;array[2] = 1;array[3] = 1;array[4] = 1;array[5] = 1;
        proyectos[0] = new Proyecto("Proyecto prueba", null, Calendar.getInstance(), null, 0, null, null, array);
        

    }
    
    public boolean registrarProyecto(String nombreProyecto, String nombreCliente, Calendar fechaInicial, Calendar fechaFinal, double presupuestoProyecto, String numeroGerente, String nombreGerente, int[] mesesEtapas){

        Proyecto nuevoProyecto= new Proyecto(nombreProyecto, nombreCliente,fechaInicial, fechaFinal, presupuestoProyecto, numeroGerente, nombreGerente,mesesEtapas);

        for (int i=0; i<proyectos.length; i++){

            if (proyectos[i]==null){
                proyectos[i]=nuevoProyecto;
                
                return true;

            }
        }
       return false;
    }

    public String consultarProyectosRegistrados(){
        String msg="";

        for (int i = 0; i < proyectos.length; i++){
            
            if (proyectos[i]!=null){

                 msg += "\n"+(i+1)+". "+proyectos[i].getNombreProyecto();
            }
        }

        return msg;
    }
    public Calendar crearCalendario(int dia, int mes, int año){

		Calendar calendario = new GregorianCalendar(dia,mes,año);

		return calendario; 
	}

    public boolean culminarEtapaProyecto(int posProyecto, Calendar fechaFinal){
    
        boolean exito = false;

        if(proyectos[posProyecto].getEtapaActiva() != -1){

            //Etapa Actual
            proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].setCumplimiento(true); //0
            proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].setFechaFinalReal(fechaFinal); //0
            
            if(proyectos[posProyecto].getEtapaActiva() !=5){
                proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()+1].setEstado(true); //0
            }
           
            proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].setEstado(false); //1 
           
            if(proyectos[posProyecto].getEtapaActiva() !=5){
           //Etapa Siguiente
           proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].setCumplimiento(false); //1
           proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].setFechaInicialReal(fechaFinal);
             }
            exito = true;
        }

        return exito;

    }

    public boolean publicarCapsula(int posProyecto, int posCapsula){

        boolean exito = false;

        proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].getCapsulas()[posCapsula].setPublicar(true);

        exito=true;
    
        return exito;
    }

    public boolean aprobarCapsula(int posProyecto, int posCapsula){

        boolean exito = false;

        proyectos[posProyecto].getEtapas()[proyectos[posProyecto].getEtapaActiva()].getCapsulas()[posCapsula].setAprobar(true);;

        exito=true;
    
        return exito;
    }

    public String consultarEtapaActiva(int posProyecto){
        String msg="";
        for (int i = 0; i < this.proyectos[posProyecto].getEtapas().length; i++){         
            if (this.proyectos[posProyecto].getEtapas()[i]!=null){

                 msg += "\n"+(posProyecto+1)+". "+this.proyectos[posProyecto].getEtapas()[i].getTipo();
            }
        }

        return msg;
    }

    public String getEtapaActiva(int pos){
        String msg ="";

        if (proyectos[pos]!=null){
            int posi = (proyectos[pos].getEtapaActiva()); //Aca va un -1
            msg += (posi+1) + ". " + proyectos[pos].getEtapas()[posi].getTipo();
        }
        return msg;   
    }

    public boolean registrarCapsula(String identificador, String descripcion, int type, String nombre, String cargo, String leccion,  boolean publicar, boolean aprobar, int posProyecto){

        TipoCapsula tipoCapsula = TipoCapsula.TECNICO;

        switch(type){
            case 1:
            tipoCapsula=TipoCapsula.TECNICO;
            break;
            case 2:
            tipoCapsula=TipoCapsula.GESTION;
            break;
            case 3:
            tipoCapsula= TipoCapsula.DOMINIO;
            break;
            case 4:
            tipoCapsula= TipoCapsula.EXPERIENCIAS;
        }

        /*proyectos[0].getEtapas()[1].getCapsulas(); especifico */

        int posi = (proyectos[posProyecto].getEtapaActiva());

        Capsula nuevaCapsula= new Capsula(identificador, descripcion, tipoCapsula, nombre, cargo, leccion, aprobar, publicar);

        return proyectos[posProyecto].getEtapas()[posi].addCapsula(nuevaCapsula);

    }

    public String getCapsulas(int pos){
        String msg ="";

        if (proyectos[pos]!=null){
            int posi = (proyectos[pos].getEtapaActiva());
            int tamaño = proyectos[pos].getEtapas()[posi].getCapsulas().length;

            for(int i=0; i<tamaño;i++){

                if (proyectos[pos].getEtapas()[posi].getCapsulas()[i]!=null){

                    msg += (posi+1) + ". " + proyectos[pos].getEtapas()[posi].getCapsulas()[i].getIdentificador();

                }
                    
            }

        }
        return msg;   
    }

    public String listadoLeccionesCadaCapsulaEtapa(int pos){

        String msg="";

        for (int i=0;i<proyectos.length; i++){
            Proyecto proyecto= proyectos[i];
            if (proyecto!=null && proyecto.getEtapas()!= null){
                for (int j=0; j <proyecto.getEtapas().length;j++){
                    Etapa etapa = proyecto.getEtapas()[j];
                    if (etapa != null && etapa.getCapsulas() !=null){
                        for (int k=0; k <etapa.getCapsulas().length;k++){
                        Capsula capsula = etapa.getCapsulas()[k];
                        if(etapa.getCapsulas()[k]!=null){
                            msg += "\n"+etapa.getCapsulas()[j].getLeccion(); 
                    }
                }
            }
        }
     }
    }
        return msg;  
     
    }
    
    public String capsulasRegistradasCadaTipoCapsula(){

        String msg= "";
        int contadorTecnico = 0;
        int contadorGestion = 0;
        int contadorDominio = 0;
        int contadorExperiencias = 0;
        
        for (int i=0; i<proyectos.length;i++){
            Proyecto proyecto = proyectos[i];
            if (proyecto != null && proyecto.getEtapas()!=null){
                for (int j=0; j<proyecto.getEtapas().length;j++){
                    Etapa etapa = proyecto.getEtapas()[j];
                    if (etapa != null && etapa.getCapsulas()!=null){
                        for (int k=0; k<etapa.getCapsulas().length;k++){
                            Capsula capsula = etapa.getCapsulas()[k];
                            if (capsula!= null){
                                switch (capsula.getType()){
                                    case TECNICO:
                                    contadorTecnico++;
                                    break;
                                    case GESTION:
                                    contadorGestion++;
                                    break;
                                    case DOMINIO:
                                    contadorDominio++;
                                    break;
                                    case EXPERIENCIAS:
                                    contadorExperiencias++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        msg += "Técnico: " +contadorTecnico;
        msg += "Gestion: "+contadorGestion;
        msg += "Dominio "+contadorDominio;
        msg += "Experiencias: "+contadorExperiencias;

        return msg;
    }
    
    public String nombreProyectoMasCapsulas(){
        String nombreProyecto = "";
        int cantidadCapsulas = 0;
    
        for (int i = 0; i<proyectos.length;i++){
            if (proyectos[i]!= null) {
                int capsulasProyecto = 0;
                for (int j = 0;j<proyectos[i].getEtapas().length;j++){
                    Etapa etapa = proyectos[i].getEtapas()[j];
                    if (etapa!= null) {
                        capsulasProyecto += etapa.getCapsulas().length;
                    }
                }
                if (capsulasProyecto>cantidadCapsulas){
                    cantidadCapsulas = capsulasProyecto;
                    nombreProyecto = proyectos[i].getNombreProyecto();
                }
            }
        }
        System.out.println(nombreProyecto);
        return nombreProyecto;
    }

    public boolean buscarColaborador(String nombreColaborador){

        boolean encontrado = false;

        for (int i= 0; i<proyectos.length && !encontrado; i++){
            Proyecto proyecto = proyectos[i];
            if (proyecto!= null && proyecto.getEtapas()!=null){
                for (int j= 0; j<proyecto.getEtapas().length && !encontrado; j++){
                    Etapa etapa = proyecto.getEtapas()[j];
                    if (etapa!= null && etapa.getCapsulas() != null){
                        for (int k= 0; k<etapa.getCapsulas().length && !encontrado; k++){
                            Capsula capsula = etapa.getCapsulas()[k];
                            if (capsula!= null && capsula.getNombreColaborador().equalsIgnoreCase(nombreColaborador)){
                                encontrado = true;
                            }
                        }
                    }
                }
            }
        }
        return encontrado;
    }
    
    public String buscarCadenaHastag(String palabrasABuscar){

        String msg="";
        palabrasABuscar= palabrasABuscar.toLowerCase();

        for (int i=0;i<proyectos.length; i++){
            Proyecto proyecto= proyectos[i];
            if (proyecto!=null && proyecto.getEtapas()!= null){
                for (int j=0; j <proyecto.getEtapas().length;j++){
                    Etapa etapa = proyecto.getEtapas()[j];
                    if (etapa != null && etapa.getCapsulas() !=null){
                        for (int k=0; k <etapa.getCapsulas().length;k++){
                            if(etapa.getCapsulas()[k] != null){
                                Capsula capsula = etapa.getCapsulas()[k];
                                if (capsula.getLeccion().toLowerCase().contains(palabrasABuscar)){
                                    msg = "La leccion es " +etapa.getCapsulas()[j].getLeccion();
                                }else{
                                    msg = "La busqueda no tuvo exito";
                                }
                            }
                     
                }
            }
        }
     }
    }
        return msg;  
     
    }






    




    
}
