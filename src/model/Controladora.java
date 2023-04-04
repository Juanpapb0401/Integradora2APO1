package model;


public class Controladora {

    private Proyecto[] proyectos;
    private Capsula[] capsulas;
    private Etapa[] etapas;

    public Controladora(){
        proyectos=new Proyecto[10];
        capsulas= new Capsula[50];
        etapas= new Etapa[6];
        
    }
    
    public boolean registrarProyecto(String nombreProyecto, String nombreCliente, int diaInicial, int mesInicial, int añoInicial, int diaFinal, int mesFinal, int añoFinal, double presupuestoProyecto, String numeroGerente, String nombreGerente, int[] mesesEtapas){

        Proyecto nuevoProyecto= new Proyecto(nombreProyecto, nombreCliente, diaInicial, mesInicial, añoInicial, diaFinal, mesFinal, añoFinal, presupuestoProyecto, numeroGerente, nombreGerente);
        nuevoProyecto.seisEtapas(mesesEtapas);


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





    public void culminarEtapaProyecto(int etapaActual){

        



}

    public boolean registrarCapsula(String identificador, String descripcion, String tipo, String nombre, String cargo, String leccion){

        Capsula nuevaCapsula= new Capsula(identificador, descripcion, tipo, nombre, cargo, leccion);

        for (int i=0; i<capsulas.length; i++){

            if (capsulas[i]==null){
                capsulas[i]=nuevaCapsula;
                return true;

            }
        }
       return false;
    }

    
	public String getIdCapsulas(){

		String msg="";

        for (int i = 0; i < capsulas.length; i++){
            
            if (capsulas[i]!=null){

                 msg += "\n"+(i+1)+". "+capsulas[i].getIdentificador();
            }
        }

        return msg;
		}


}
