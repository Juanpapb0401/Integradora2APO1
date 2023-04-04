package ui;

import model.Controladora;
import model.Proyecto;


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

            System.out.println("1.Crear un proyecto"); /* ya lo hice */
            System.out.println("2.Culminar etapa de un proyecto");
            System.out.println("3.Registrar capsula"); /* ya lo hice */
            System.out.println("4.Aprobar capsula");
            System.out.println("5.Publicar capsula");
            System.out.println("6.Salir");
            System.out.println("7.Ver proyectos");
            System.out.println("8.Ver etapas");
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
                /* Metodo para aprobar capsula */
                break;
                case 5:
                /* Metodo para publir */
                break;
                case 6:
                flag=true;
                break;
                case 7:
                consultarProyectos();
                break;
                case 8:
                
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
        int dia= lector.nextInt();
        System.out.println("Digite el mes");
        int mes= lector.nextInt();
        System.out.println("Digite el año");
        int año= lector.nextInt();

        System.out.println("Digite la fecha planeada para la finalizacion del proyecto");
        int fechaFinal= lector.nextInt();

        lector.nextLine();

        System.out.println("Digite los nombres de los gerentes");
        String nombreGerente= lector.nextLine();

        System.out.println("Digite los numeros de los gerentes");
        String celularGerente= lector.nextLine();
        

        System.out.println("Digite el presupuesto del proyecto");
        double presupuestoProyecto= lector.nextDouble();

        String[] nombresEtapas = {"Inicio", "Analisis"}; 
        int[] mesesEtapas = new int[6];

        for(int i = 0; i<mesesEtapas.length;i++){
            System.out.println("Ingrese porfavor la cantidad de meses que la etapa "+(i+1)+ nombresEtapas[i]);
            mesesEtapas[i]= lector.nextInt();
        }

        if (controladora.registrarProyecto(nombreProyecto, nombreCliente, dia, mes, año, fechaFinal, fechaFinal, fechaFinal, presupuestoProyecto, celularGerente, nombreGerente, mesesEtapas)){
            
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

            System.out.println("Ingrese la fecha de finalizacion");
            int fechaCulminar= lector.nextInt();

            





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

        /* Aca va que se meta dentro del proyecto y luego diga esta en esta etapa, registrar capsula */

        

        lector.nextLine();

        System.out.println("Digite a contunuacion la informacion de una capsula");

        System.out.println("Digite el identificador");
        String identificador= lector.nextLine();

        System.out.println("Digite la descripcion");
        String descripcion= lector.nextLine();

        System.out.println("Digite el tipo de capsula. Técnico, gestión, dominio o experiencias");
        String tipo= lector.nextLine();

        System.out.println("Digite tu nombre");
        String nombre= lector.nextLine();

        System.out.println("Digite el carpo que tienes");
        String cargo= lector.nextLine();

        System.out.println("Digite la leccion aprendida con dicha situacion");
        String leccion= lector.nextLine();

        if (controladora.registrarCapsula(identificador, descripcion, tipo, nombre, cargo, leccion)){
            
            System.out.println("La capsula ha sido registra exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar la capsula");
            
        }







    }

    
}
