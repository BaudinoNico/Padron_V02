import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Principal {
    private static int idoc=0, iadm=0, opcion;
    private static Map<String,Empleado> empleados = new TreeMap<String,Empleado>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //int opcion, tipor;

        opcion = 0;

        //Empleados para probar funcionalidad
        empleados.put("Doce0", new Docente(33069335, "Nico", "Bau", "Esp 1960", "Poli", "Arq", "Dib", 8, 650));
        empleados.put("Doce1", new Docente(33562331, "Gime", "Can", "Esp 1916", "Lat", "Arq", "Const", 16, 800));
        empleados.put("Adm0", new Administrativo(12621880, "Cata", "Soto", "Rio 333", "Lat", "Cobr", 70000));
        //Empleados para probar funcionalidad

        DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Hola, hoy es " + dia.format(ahora) + " y son las " + hora.format(ahora) + '\n');

      //  try {
            while (opcion != 9) {
                try {
                    System.out.println("Ingrese una opción y presione enter");
                    System.out.println(
                            "1. Registrar empleado\n" +
                                    "2. Eliminar empleado\n" +
                                    "3. Modificar datos\n" +
                                    "4. Visualizar información\n" +
                                    "5. Listar empleados administrativos\n" +
                                    "6. Listar empleados docentes\n" +
                                    "7. Visualizar empleado administrativo con mayor remuneración\n" +
                                    "8. Listar docentes por materia\n" +
                                    "9. Salir");

                    opcion = in.nextInt();
                    System.out.println("Seleccionaste la opción " + opcion);
                } catch (Exception e) {
                    System.out.println("La opcion debe ser un numero entero. Intente nuevamente" + '\n');
                    in.nextLine();
                }

                    switch (opcion) {
                        case 1:
                            Agregar();
                            break;
                        case 2:
                            Eliminar();
                            break;
                        case 3:
                            /*Modificar();
                            break;*/
                        case 4:
                            Mostrar();
                            break;
                        case 5:
                            ListAdm();
                            break;
                        case 6:
                            ListDoc();
                            break;
                        case 7:
                        case 8:
                        case 9:
                            System.out.println("Saliendo, hasta luego!");
                            break;
                        default:
                            System.out.println("Opcion invalida, intente nuevamente" + '\n');
                            break;
                    }

            }
    }

    public static void Agregar() {
        boolean banderacre;
        int tipor, dni;
        String nombre_ins, nom, ape, dir, ins, tit, mat, are;
        double hor, cos, sal;

        tipor=0;
        banderacre = true;

        while (banderacre){
            try {
                banderacre = false;
                System.out.println("Ingrese 1 para Docente, 2 para Administrativo, 3 para volver al menu principal y presione enter");
                tipor = in.nextInt();
                switch (tipor) {
                    case 1:
                        nombre_ins = "Doc" + idoc;
                        System.out.println("Ingrese DNI");
                        dni = in.nextInt();
                        in.nextLine();
                        System.out.println("Ingrese nombre");
                        nom = in.nextLine();
                        System.out.println("Ingrese apellido");
                        ape = in.nextLine();
                        System.out.println("Ingrese dirección");
                        dir = in.nextLine();
                        System.out.println("Ingrese institución");
                        ins = in.nextLine();
                        System.out.println("Ingrese título");
                        tit = in.nextLine();
                        System.out.println("Ingrese materia");
                        mat = in.nextLine();
                        System.out.println("Ingrese cant de horas semanales");
                        hor = in.nextDouble();
                        System.out.println("Ingrese valor por hora");
                        cos = in.nextDouble();
                        empleados.put(nombre_ins, new Docente(dni, nom, ape, dir, ins, tit, mat, hor, cos));
                        System.out.println("Usted ha creado la siguiente entrada " + '\n' + "Codigo unico:" + nombre_ins + '\n' + empleados.get(nombre_ins).toString());
                        idoc++;
                        break;
                    case 2:
                        nombre_ins = "Adm" + iadm;
                        System.out.println("Ingrese DNI");
                        dni = in.nextInt();
                        in.nextLine();
                        System.out.println("Ingrese nombre");
                        nom = in.nextLine();
                        System.out.println("Ingrese apellido");
                        ape = in.nextLine();
                        System.out.println("Ingrese dirección");
                        dir = in.nextLine();
                        System.out.println("Ingrese institución");
                        ins = in.nextLine();
                        System.out.println("Ingrese area");
                        are = in.nextLine();
                        System.out.println("Ingrese salario");
                        sal = in.nextDouble();
                        empleados.put(nombre_ins, new Administrativo(dni, nom, ape, dir, ins, are, sal));
                        System.out.println("Usted ha creado la siguiente entrada " + '\n' + "Codigo unico:" + nombre_ins + '\n' + empleados.get(nombre_ins).toString());
                        iadm++;
                        break;
                    case 3:
                        System.out.println("Volviendo al menu principal" + '\n');
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente nuevamente");
                        banderacre = true;
                }
            } catch (Exception e) {
                    System.out.println("Debe ingresar un valor numerico. Intente nuevamente" + '\n');
                    in.nextLine();
                    banderacre = true;
            }
        }
    }


    public static void Eliminar() {
        String parambusq, confirm, dnitxt;
        int dni;
        boolean bandera;

        bandera = true;

        System.out.println("Ingrese Codigo Unico o DNI para eliminar un registro");
        in.nextLine();
        parambusq = in.nextLine();
        for(Object key : empleados.keySet()) {
            if (key.equals(parambusq)) {
                System.out.println("Esta seguro que desea eliminar a " + empleados.get(parambusq).getNombre() + " " + empleados.get(parambusq).getApellido() + "?");
                System.out.println("y / N");
                confirm = in.nextLine();
                if (confirm.equals("y")) {
                    empleados.remove(parambusq);
                    System.out.println("El registro ha sido eliminado");
                    bandera =false;
                    break;
                }
                else {
                    System.out.println("Operacion cancelada");
                    bandera =false;
                    break;
                }
            }
        }
        for (Object key : empleados.keySet()) {
            dnitxt = String.valueOf(empleados.get(key).getDni());
            if (parambusq.equals(dnitxt)) {
                System.out.println("Esta seguro que desea eliminar a " + empleados.get(key).getNombre() + empleados.get(key).getApellido() + "?");
                System.out.println("y / N");
                confirm = in.nextLine();
                if (confirm.equals("y")) {
                    empleados.remove(key);
                    System.out.println("El registro ha sido eliminado");
                    bandera =false;
                    break;
                }
                else {
                    System.out.println("Operacion cancelada");
                    bandera =false;
                    break;
                }
            }
        }
        if (bandera) {
            System.out.println('\n' + "No se ha encontrado el registro -" + parambusq + "-");
            System.out.println("Volviendo al menu principal" + '\n');
        }
    }

    //Muestra Administrativos
    public static void ListAdm() {
        String clase;
        System.out.println("Los empleados administrativos son:" + '\n');
        for(Object key : empleados.keySet()) {
            clase = empleados.get(key).getClass().getName();
            if (clase.equals("Administrativo")) {
                System.out.println("- " + key + " " + empleados.get(key).getNombre() + " " + empleados.get(key).getApellido() + '\n');
            }
        }
    }

    //Muestra Docentes
    public static void ListDoc() {
        String clase;
        System.out.println("Los empleados docentes son:" + '\n');
        for(Object key : empleados.keySet()) {
            clase = empleados.get(key).getClass().getName();
            if (clase.equals("Docente")) {
                System.out.println("- " + key + " " + empleados.get(key).getNombre() + " " + empleados.get(key).getApellido() + '\n');
            }
        }
    }

    //Muestra datos
    public static void Mostrar() {
        String coduni;

        System.out.println("Ingrese Codigo Unico para visualizar informacion");
        in.nextLine();
        coduni = in.nextLine();
        System.out.println(empleados.get(coduni).toString());
    }

    /*public static  void Modificar() {
        int dninuevo;
        System.out.println("Inserte nuevo dato");
        dninuevo = in.nextInt();
        empleados.get("Adm0").setDni(dninuevo);
        System.out.println("El nuevo dni es" + empleados.get("Adm0").getDni());

    }*/
}
