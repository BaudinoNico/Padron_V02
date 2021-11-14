import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Principal {
    static int idoc=0, iadm=0;
    static Map<String,Empleado> empleados = new TreeMap<String,Empleado>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion, tipor;

        opcion = 0;

        //Empleados para probar funcionalidad
        empleados.put("Doce0", new Docente(33069335, "Nico", "Bau", "Esp 1960", "Poli", "Arq", "Dib", 8, 650));
        empleados.put("Doce1", new Docente(33562331, "Gime", "Can", "Esp 1916", "Lat", "Arq", "Const", 16, 800));
        empleados.put("Adm0", new Administrativo(12621880, "Cata", "Soto", "Rio 333", "Lat", "Cobr", 70000));
        //Empleados para probar funcionalidad

        DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Hola, hoy es " + dia.format(ahora) + "y son las " + hora.format(ahora));

        while (opcion !=9){
            System.out.println("Ingrese una opción y presione enter");
            System.out.println(
                    "1. Registrar empleado\n"+
                    "2. Eliminar empleado\n"+
                    "3. Modificar datos\n"+
                    "4. Visualizar información\n"+
                    "5. Listar empleados administrativos\n"+
                    "6. Listar empleados docentes\n"+
                    "7. Visualizar empleado administrativo con mayor remuneración\n"+
                    "8. Listar docentes por materia\n"+
                    "9. Salir");

            opcion = in.nextInt();
            System.out.println("Seleccionaste la opción "+ opcion);
            switch (opcion) {
                case 1:
                    Agregar();
                    break;
                case 2:
                    Eliminar();
                    break;
                case 3:
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


                default:
                    System.out.println("Opcion invalida, intente nuevamente");

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
            banderacre = false;
            System.out.println("Ingrese 1 para Docente o 2 para Administrativo y presione enter");
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
                default:
                    System.out.println("Opcion invalida");
                    banderacre = true;
            }
        }
    }

    public static void Eliminar() {
        String parambusq, confirm, dni2;
        int dni;

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
                                break;
                            }
                            else {
                                System.out.println("Operacion cancelada");
                                break;
                            }
                        }
                    }
                    //dni = Integer.parseInt(parambusq);
                    for (Object key : empleados.keySet()) {
                        dni2 = String.valueOf(empleados.get(key).getDni());
                        if (parambusq.equals(dni2)) {
                                System.out.println("Esta seguro que desea eliminar a " + empleados.get(key).getNombre() + empleados.get(key).getApellido() + "?");
                                System.out.println("y / N");
                                confirm = in.nextLine();
                                if (confirm.equals("y")) {
                                    empleados.remove(key);
                                    System.out.println("El registro ha sido eliminado");
                                    break;
                                }
                                else {
                                    System.out.println("Operacion cancelada");
                                    break;
                                }
                            }

                    }

    }

    //Muestra Administrativos
    public static void ListAdm() {
        String clase;
        for(Object key : empleados.keySet()) {
            clase = empleados.get(key).getClass().getName();
            if (clase.equals("Administrativo")) {
                System.out.println("-" + empleados.get(key).getNombre() + " " + empleados.get(key).getApellido());
            }
        }
    }

    //Muestra Docentes
    public static void ListDoc() {
        String clase;
        for(Object key : empleados.keySet()) {
            clase = empleados.get(key).getClass().getName();
            if (clase.equals("Docente")) {
                System.out.println("-" + empleados.get(key).getNombre() + " " + empleados.get(key).getApellido());
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

}
