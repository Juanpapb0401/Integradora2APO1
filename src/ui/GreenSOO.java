package ui;

import model.Controladora;



import java.util.Calendar;
import java.util.Scanner;



public class GreenSOO{

    private Scanner lector;
    private Controladora controladora;
    private Calendar calendario;

    public GreenSOO(){

        lector= new Scanner(System.in);
        controladora= new Controladora();
        calendario= Calendar.getInstance();
        

    }

    public void menu(){

        System.out.println("Bienvenido al menu de GreenSQA");
        boolean flag=false;
    
        while (!flag){

            System.out.println("1.Crear un proyecto"); 
            System.out.println("2.Culminar etapa de un proyecto"); 
            System.out.println("3.Registrar capsula"); 
            System.out.println("4.Aprobar capsula"); 
            System.out.println("5.Publicar capsula"); 
            System.out.println("6.Informar capsulas por tipo");
            System.out.println("7.Informar listado de lecciones por etapa");
            System.out.println("8.Informar usuario nombre del proyecto con mas capsulas");
            System.out.println("9.Informar si un colaborador registro capsula");
            System.out.println("10.Informar lecciones de capsulas aprobadas y publicadas");
            System.out.println("11.Salir");
            int opcion=lector.nextInt();


            switch (opcion){
                case 1:
                registrarProyecto();
                break;
                case 2:
                culminarEtapaProyecto();
                break;
                case 3:
                registrarCapsula();
                break;
                case 4:
                aprobarCapsula();
                break;
                case 5:
                publicarCapsula();
                break;
                case 6:
                capsulasRegistradasCadaTipoCapsula();
                break;
                case 7:
                listadoLeccionesCadaCapsulaEtapa();
                break;
                case 8:
                nombreProyectoMasCapsulas();
                break;
                case 9:
                buscarColaborador();
                break;
                case 10:
                buscarCadenaHastag();
                break;
                case 11:
                flag=true;
                break;
            }
        }
    }

    public static void main(String[] args){
        GreenSOO ejecutable= new GreenSOO();        
        ejecutable.menu();
    }


/**Method title: RegistrarProyecto
*Description: The method allows you to register a maximum of 10 new projects, where you will be asked for all the necessary information
*Return: Registering a new object of the Project class
*/
    public void registrarProyecto(){

        lector.nextLine();

        System.out.println("Digite a contunuacion la informacion de un proyecto");

        System.out.println("Digite el nombre del proyecto");
        String nombreProyecto= lector.nextLine();

        System.out.println("Digite el nombre del cliente");
        String nombreCliente= lector.nextLine();

        System.out.println("Digite la fecha de inicio del proyecto");
        System.out.println("Digite el dia");
        int diaInicio= lector.nextInt();
        System.out.println("Digite el mes");
        int mesInicio= lector.nextInt();
        System.out.println("Digite el año");
        int añoInicio= lector.nextInt();

        System.out.println("Digite la fecha planeada para la finalizacion del proyecto");
        System.out.println("Digite el dia");
        int diaFinal= lector.nextInt();
        System.out.println("Digite el mes");
        int mesFinal= lector.nextInt();
        System.out.println("Digite el año");
        int añoFinal= lector.nextInt();

        lector.nextLine();

        System.out.println("Digite los nombres de los gerentes");
        String nombreGerente= lector.nextLine();

        System.out.println("Digite los numeros de los gerentes");
        String celularGerente= lector.nextLine();
        

        System.out.println("Digite el presupuesto del proyecto");
        double presupuestoProyecto= lector.nextDouble();

        String[] nombresEtapas = {"Inicio", "Analisis", "Diseño", "Ejecuccion", "Cierre y Seguimiento", "Control de proyecto"}; 
        int[] mesesEtapas = new int[6];

        for(int i = 0; i<mesesEtapas.length;i++){
            System.out.println("Ingrese porfavor la cantidad de meses que la etapa "+(i+1)+":"+ nombresEtapas[i]);
            mesesEtapas[i]= lector.nextInt();
        }

        if (controladora.registrarProyecto(nombreProyecto, nombreCliente, controladora.crearCalendario(diaInicio, mesInicio, añoInicio),controladora.crearCalendario(diaFinal, mesFinal, añoFinal),presupuestoProyecto, celularGerente, nombreGerente, mesesEtapas)){
            
            System.out.println("El proyecto ha sido registrado exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar el Proyecto");
            
        }

    }
/**Method title: consultarProyectos
*Description: The method allows to consult the registered projects
*Return: View registered projects
*/
    public void consultarProyectos(){
            
        System.out.println("Esta es la informacion registrada en el sistema");

        String consulta=controladora.consultarProyectosRegistrados();

        if (consulta.equals("")){
            System.out.println("No hay proyectos registrados");
        }else {
            System.out.println(controladora.consultarProyectosRegistrados());
        }
    }
/**Method title: culminarEtapaProyecto
*Description: The method allows the culmination of a stage of a specific project
*Return: The culmination of a stage of a project
*/
    public void culminarEtapaProyecto(){

        String consulta= controladora.consultarProyectosRegistrados();
        
        if (consulta.equals("")){
            System.out.println("No hay proyectos registrados");
        }else {

            System.out.println("Estos son los proyectos registrados");

            System.out.println(consulta);

            System.out.println("Digite a que proyecto le va a culminar la etapa");
            int opcion= lector.nextInt();
            String consultaEtapa = controladora.getEtapaActiva(opcion-1);

            System.out.println("El proyecto actual se encuentra en la etapa: ");

            System.out.println(consultaEtapa);


            System.out.println("Ingrese la fecha de finalizacion");
            System.out.println("Digite el dia");
            int diaCulminar= lector.nextInt();
            System.out.println("Digite el mes");
            int mesCulminar= lector.nextInt();
            System.out.println("Digite el año");
            int añoCulminar= lector.nextInt();

            controladora.culminarEtapaProyecto(opcion-1, controladora.crearCalendario(diaCulminar, mesCulminar, añoCulminar));
        } 
        
    }
/**Method title: RegistrarCapsula
*Description: The method allows to record a capsule of a project at the stage in which it is located.
*Return: Registering a new object of the Capsula class
*/
    public void registrarCapsula(){
        
        System.out.println("Estos son los proyectos registrados "); 

        consultarProyectos();

        System.out.println("Digite el proyecto en el cual quiere registrar la capsula");
        int opcionProyecto= lector.nextInt();

        String consultaEtapa = controladora.getEtapaActiva(opcionProyecto-1);
       
        System.out.println("El proyecto esta en la etapa: ");

        System.out.println(consultaEtapa);

        lector.nextLine();

        System.out.println("Digite a contunuacion la informacion de una capsula");

        System.out.println("Digite el identificador");
        String identificador= lector.nextLine();

        System.out.println("Digite la descripcion");
        String descripcion= lector.nextLine();

        System.out.println("Digite el tipo de capsula.\n1.Técnico\n2.gestión\n3.dominio\n4.experiencias");
        int tipo= lector.nextInt();

        lector.nextLine();

        System.out.println("Digite tu nombre");
        String nombre= lector.nextLine();

        System.out.println("Digite el carpo que tienes");
        String cargo= lector.nextLine();

        System.out.println("Digite la leccion aprendida con dicha situacion");
        String leccion= lector.nextLine();

        if (controladora.registrarCapsula(identificador, descripcion, tipo, nombre, cargo, leccion, false, false, opcionProyecto-1)){
            
            System.out.println("La capsula ha sido registra exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar la capsula");
            
        }
    }
/**Method title: AprobarCapsula
*Description: The method allows to approve a capsule and a project entered by the user
*Return: Approve a capsule
*/
    public void aprobarCapsula(){

        String consulta= controladora.consultarProyectosRegistrados();
        
        if (consulta.equals("")){
            System.out.println("No hay proyectos registrados");
        }else {

            System.out.println("Estos son los proyectos registrados");

            System.out.println(consulta);

            System.out.println("Digite a que proyecto le va a aprobar");
            int opcion= lector.nextInt();
            String consultaEtapa = controladora.getEtapaActiva(opcion-1);

            System.out.println("El proyecto actual se encuentra en la etapa: ");

            System.out.println(consultaEtapa);

            System.out.println("Esta etapa tiene estas capsulas: ");

            String consultaCapsulas = controladora.getCapsulas(opcion-1);
            if (consultaCapsulas.equals("")){
        
                System.out.println("No hay capsulas registradas");

            }else{
            
            System.out.println(consultaCapsulas);

            System.out.println("Digite que capsula quiere aprobaR");
            int opcionCapsula= lector.nextInt();

            System.out.println("Ingrese la fecha de aprobacion");
            System.out.println("Digite el dia");
            int diaCulminar= lector.nextInt();
            System.out.println("Digite el mes");
            int mesCulminar= lector.nextInt();
            System.out.println("Digite el año");
            int añoCulminar= lector.nextInt();
            
            if (controladora.aprobarCapsula(opcion-1, opcionCapsula-1)){
                System.out.println("Se ha aprobado esta capsula");
                }
            }

        }
    }
/**Method title: PublicarCapsula
*Description: The method allows to publish a capsule and a project entered by the user
*Return: Publish a capsule
*/
    public void publicarCapsula(){

        String consulta= controladora.consultarProyectosRegistrados();
        
        if (consulta.equals("")){
            System.out.println("No hay proyectos registrados");
        }else {

            System.out.println("Estos son los proyectos registrados");

            System.out.println(consulta);

            System.out.println("Digite a que proyecto le va a aprobar");
            int opcionProyecto= lector.nextInt();
            String consultaEtapa = controladora.getEtapaActiva(opcionProyecto-1);

            System.out.println("El proyecto actual se encuentra en la etapa: ");

            System.out.println(consultaEtapa);

            System.out.println("Esta etapa tiene estas capsulas: ");

            String consultaCapsulas = controladora.getCapsulas(opcionProyecto-1);
            if (consultaCapsulas.equals("")){
        
                System.out.println("No hay capsulas registradas");

            }else{
            
            System.out.println(consultaCapsulas);

            String identificador= controladora.getCapsulas(opcionProyecto-1);

            System.out.println("Digite que capsula quiere publicar");
            int opcionCapsula= lector.nextInt();
            
            if (controladora.publicarCapsula(opcionProyecto-1, opcionCapsula-1)){
                System.out.println("Se ha publicado la capsula, esta es su URL: https://Integradora.2.APO.com/");
                }
            }
        }
     }
/**Method title: ListadoLeccionesCadaCapsulaEtapa
*Description: The method allows you to see all the lessons for each capsule in one step
*Return: Lesson for each capsule in one step
*/
    public void listadoLeccionesCadaCapsulaEtapa(){

        System.out.println("Ingrese la etapa para informar las lecciones de las capsulas");
        System.out.println("1.Inicio, 2.Analisis, 3.Diseño, 4.Ejecuccion, 5.Cierre y Seguimiento, 6.Control de proyecto");
        int opcionEtapa= lector.nextInt();

        if (controladora.listadoLeccionesCadaCapsulaEtapa(opcionEtapa) != null){
            System.out.println(controladora.listadoLeccionesCadaCapsulaEtapa(opcionEtapa));
        } else {
            System.out.println("No hay lecciones aprendidas en ninguna capsula en esa etapa particular para ningún proyecto");
        }
        
     }
/**Method title: CapsulasRegistradasCapaTipoCapsula
*Description: The method allows you to see all the lessons for each capsule in one step
*Return: Registering a new object of the Capsula class
*/
    public void capsulasRegistradasCadaTipoCapsula(){

        System.out.println("Estas son la cantidad de capsulas por cada tipo");
        
        System.out.println(controladora.capsulasRegistradasCadaTipoCapsula());
    }
/**Method title: RegistrarCapsula
*Description: The method allows to record a capsule of a project at the stage in which it is located.
*Return: The number of each capsules types
*/
    public void nombreProyectoMasCapsulas(){

        System.out.println("Este es el nombre dle proyecto el cual tiene mas capsulas registradas");
        System.out.println(controladora.nombreProyectoMasCapsulas());

        
    }
/**Method title: NombreProyectoMasCapsulas
*Description: The method allows you to see which project name within the project has more capsules
*Return: The name of the Proyect
*/
    public void buscarColaborador(){

        lector.nextLine();
        
        System.out.println("Porfavor registre el nombre del colaborador");
        String nombre= lector.nextLine();

        if (controladora.buscarColaborador(nombre)==true){
            System.out.println("Si, el colaborador ha registrado cápsulas en algún proyecto");
        }else{
            System.out.println("No, este colaborador no ha registrado ninguna capsula");
        }
    }
/**Method title: BuscarColaborador
*Description:The method allows you to see if a contributor has registered capsules
*Return: Yes or no, depend on the search
*/
    public void buscarCadenaHastag(){
        
        lector.nextLine();

        System.out.println("Ingrese la cadena de busqueda");
        String palabrasABuscar= lector.nextLine();

        System.out.println(controladora.buscarCadenaHastag(palabrasABuscar));
    }
/**Method title: buscarCadenaHastag
*Description: The method allows to see if by a search that string is in a lesson
*Return: Yes or no, depend on the search
*/
}