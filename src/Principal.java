import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Principal {
    private static int idoc=0, iadm=0;
    private static Map<String,Empleado> Empleados = new TreeMap<String,Empleado>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0, salida = 9;

        //Empleados para probar funcionalidad
        Empleados.put("Doce0", new Docente(33069335, "Nico", "Bau", "Esp 1960", "Poli", "Arq", "Dib", 8, 650));
        Empleados.put("Doce1", new Docente(33562331, "Gime", "Can", "Esp 1916", "Lat", "Arq", "Const", 16, 800));
        Empleados.put("Adm0", new Administrativo(12621880, "Cata", "Soto", "Rio 333", "Lat", "Cobr", 70000));
        //Empleados para probar funcionalidad

        DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime login = LocalDateTime.now();
        System.out.println("\nBienvenido al Sistema de Padron de Empleados!\nHoy es " + dia.format(login) + " y son las " + hora.format(login) + '\n');

        while (opcion != salida) {
            try {
                System.out.println("<Se encuentra(n) registrados <" + Empleados.size() + "> empleado(s) en el padron>");
                System.out.println("Que desea hacer?\nIngrese una opción y luego presione enter:");
                System.out.println(
                        "1. Registrar empleado\n" +
                        "2. Eliminar empleado\n" +
                        "3. Modificar datos\n" +
                        "4. Visualizar información\n" +
                        "5. Listar empleados administrativos\n" +
                        "6. Listar empleados docentes\n" +
                        "7. Visualizar empleado administrativo con mayor remuneración\n" +
                        "8. Listar docentes por materia\n" +
                        "9. Salir\n" +
                        ">");

                opcion = in.nextInt();
                in.nextLine(); //Consume el fin de linea que no consume el nextInt.

                System.out.println("\n<Seleccionaste la opción " + opcion+">");

                switch (opcion) {
                    case 1:
                        Agregar();
                        break;
                    case 2:
                        Eliminar();
                        break;
                    case 3:
                        Modificar();
                        break;
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
                        AdmMayorSueldo();
                        break;
                    case 8:
                        ListDocMateria();
                        break;
                    case 9:
                        System.out.println("Saliendo, hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion invalida, intente nuevamente" + '\n');
                        break;
                }
            } catch (Exception e) {
                System.out.println("La opcion debe ser un numero entero. Intente nuevamente" + '\n');
                in.nextLine();
            }
        }
    }

    public static void Agregar() {
        boolean banderacre;
        int tipor, dni;
        String nombre_ins, nom, ape, dir, ins, tit, mat, are;
        double hor, cos, sal;

        banderacre = true;

        while (banderacre){
            try {
                banderacre = false;
                System.out.println("\n----------\nIngrese 1 para Docente o 2 para Administrativo y presione enter:\n>");
                tipor = in.nextInt();
                in.nextLine(); //Consume el fin de linea que no consume el nextInt.

                switch (tipor) {
                    case 1:
                        nombre_ins = "Doc" + idoc;
                        System.out.println("\n----------\n- Ingrese el DNI...");
                        dni = in.nextInt();
                        in.nextLine(); //Consume el salto de linea que no consume el nextInt
                        System.out.println("- Ingrese el nombre...");
                        nom = in.nextLine();
                        System.out.println("- Ingrese el apellido...");
                        ape = in.nextLine();
                        System.out.println("- Ingrese la dirección...");
                        dir = in.nextLine();
                        System.out.println("- Ingrese la institución...");
                        ins = in.nextLine();
                        System.out.println("- Ingrese el título...");
                        tit = in.nextLine();
                        System.out.println("- Ingrese la materia...");
                        mat = in.nextLine();
                        System.out.println("- Ingrese la cantidad de horas semanales...");
                        hor = in.nextDouble();
                        System.out.println("- Ingrese el valor por hora...");
                        cos = in.nextDouble();
                        in.nextLine(); //Consume el salto de linea que no consume el nextDouble
                        Empleados.put(nombre_ins, new Docente(dni, nom, ape, dir, ins, tit, mat, hor, cos));
                        System.out.println("\n----------\nUsted ha creado la siguiente entrada:\nCodigo unico: " + nombre_ins + '\n' + Empleados.get(nombre_ins).toString());
                        Pausa();
                        idoc++;
                        break;
                    case 2:
                        nombre_ins = "Adm" + iadm;
                        System.out.println("- Ingrese el DNI...");
                        dni = in.nextInt();
                        in.nextLine(); //Consume el salto de linea que no consume el nextInt
                        System.out.println("- Ingrese el nombre...");
                        nom = in.nextLine();
                        System.out.println("- Ingrese el apellido...");
                        ape = in.nextLine();
                        System.out.println("- Ingrese la dirección...");
                        dir = in.nextLine();
                        System.out.println("- Ingrese la institución...");
                        ins = in.nextLine();
                        System.out.println("- Ingrese el area...");
                        are = in.nextLine();
                        System.out.println("- Ingrese el salario...");
                        sal = in.nextDouble();
                        in.nextLine(); //Consume el salto de linea que no consume el nextDouble
                        Empleados.put(nombre_ins, new Administrativo(dni, nom, ape, dir, ins, are, sal));
                        System.out.println("\n----------\nUsted ha creado la siguiente entrada:\nCodigo unico: " + nombre_ins + '\n' + Empleados.get(nombre_ins).toString());
                        Pausa();
                        iadm++;
                        break;
                    default:
                        System.out.println("Opcion invalida, vuelva a intentarlo.");
                        banderacre = true;
                }
            } catch (Exception e) {
                System.out.println("El ingreso del campo debe ser numerico. Intente nuevamente" + '\n');
                in.nextLine();
                banderacre = true;
            }
        }
    }

    public static void Eliminar() {
        String parambusq, cubusq;
        int dnibusq;

        System.out.println("\n---------\nIngrese Codigo Unico o DNI para eliminar un registro:\n>");
        parambusq = in.nextLine();

        if (esDNI(parambusq)) {
            dnibusq = Integer.parseInt(parambusq);
            cubusq = DNIaCU(dnibusq);

            if (cubusq != null) {
                EliminarCU(cubusq);
            }
        }
        else {
            EliminarCU(parambusq);
        }
    }

    //Evalua si el ingreso para la busqueda de eliminacion es CU o DNI
    public static boolean esDNI(String ingreso) {
        if (ingreso == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(ingreso);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //Busca cual es el CU segun el DNI
    public static String DNIaCU (int param) {
        for(String key : Empleados.keySet()) {
            if (param == Empleados.get(key).getDni()) {
                return key;
            }
        }
        System.out.println("<<No se encontraron registros con ese DNI>>");
        Pausa();
        return null;
    }

    //Busca Eliminiar al registro segun el CU
    public static void EliminarCU (String cu) {
        String confirm;

        if (Empleados.containsKey(cu)) {
            System.out.println("Esta seguro que desea eliminar a " + Empleados.get(cu).getNombre() + " " + Empleados.get(cu).getApellido() + "?");
            System.out.println("S / N");
            confirm = in.nextLine();

            if (confirm.equals("S")) {
                Empleados.remove(cu);
                System.out.println("<<Empleado eliminado con exito>>");
            }
            else {
                System.out.println("<<Operacion cancelada>>");
            }
        }
        else {
            System.out.println("<<No se encontraron registros con ese Codigo Unico>>");
        }
        Pausa();
    }

    //Modifica datos segun CU o DNI
    public static void Modificar() {
        String parambusq;

        System.out.println("\n---------\nIngrese Codigo Unico para editar un registro:\n>");
        parambusq = in.nextLine();

        if (Empleados.containsKey(parambusq)) {
            System.out.println("\nRegistro encontrado, se muestran los datos correspondientes a <" + parambusq + ">:\n" + Empleados.get(parambusq).toString());
            System.out.println("Presione una tecla para comenzar la edicion....");
            in.nextLine();
            ModificarCU(parambusq);
        } else {
            System.out.println("\n<<No se encontro ningun registro asociado a ese Codigo Unico>>\n");
            Pausa();
        }
    }

    public static void ModificarCU (String param) {
        int c=1, salida=0;
        while (c != salida) {
            try {
                System.out.println("\nIngrese el numero de campo a editar:\n" + Empleados.get(param).campos() + "0- Finalizar edicion\n>");
                c = in.nextInt();
                in.nextLine(); //Consume el salto de linea que no consume el nextInt

                switch (c) {
                    case 1: {
                        System.out.println("\nEl DNI actual es <" + Empleados.get(param).getDni() + ">, ingrese el nuevo DNI:\n>");
                        Empleados.get(param).setDni(in.nextInt());
                        in.nextLine();
                        break;
                    }
                    case 2: {
                        System.out.println("\nEl Nombre actual es <" + Empleados.get(param).getNombre() + ">, ingrese el nuevo Nombre:\n>");
                        Empleados.get(param).setNombre(in.nextLine());
                        break;
                    }
                    case 3: {
                        System.out.println("\nEl Apellido actual es <" + Empleados.get(param).getApellido() + ">, ingrese el nuevo Apellido:\n>");
                        Empleados.get(param).setApellido(in.nextLine());
                        break;
                    }
                    case 4: {
                        System.out.println("\nLa Direccion actual es <" + Empleados.get(param).getDireccion() + ">, ingrese la nueva Direccion:\n>");
                        Empleados.get(param).setDireccion(in.nextLine());
                        break;
                    }
                    case 5: {
                        System.out.println("\nLa Institucion actual es <" + Empleados.get(param).getInstitucion() + ">, ingrese la nueva Institucion:\n>");
                        Empleados.get(param).setInstitucion(in.nextLine());
                        break;
                    }
                    case 0: {
                        System.out.println("\n<<Edicion finalizada>>\n");
                        Pausa();
                        break;
                    }
                    default:
                }

                if (c != 0) {
                    if (Empleados.get(param) instanceof Docente) {
                        switch (c) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                break;
                            case 6: {
                                System.out.println("\nEl Titulo actual es <" + ((Docente) Empleados.get(param)).getTitulo() + ">, ingrese el nuevo Titulo:\n>");
                                ((Docente) Empleados.get(param)).setTitulo(in.nextLine());
                                break;
                            }
                            case 7: {
                                System.out.println("\nLa Materia actual es <" + ((Docente) Empleados.get(param)).getMateria() + ">, ingrese la nueva Materia:\n>");
                                ((Docente) Empleados.get(param)).setMateria(in.nextLine());
                                break;
                            }
                            case 8: {
                                try {
                                    System.out.println("\nLa Cantidad de Horas Semanales actual es <" + ((Docente) Empleados.get(param)).getHoras() + ">, ingrese la nueva cantidad:\n>");
                                    ((Docente) Empleados.get(param)).setHoras(in.nextDouble());
                                } catch (Exception e) {
                                    System.out.println("Incorrecto, el ingreso deber ser numerico, vuelva a intentarlo");
                                    in.nextLine(); //Consume el salto de linea que no consume el nextDouble
                                    Pausa();
                                }
                                break;
                            }
                            case 9: {
                                try {
                                    System.out.println("\nEl Monto por Hora actual es <" + ((Docente) Empleados.get(param)).getCostoH() + ">, ingrese el nuevo monto:\n>");
                                    ((Docente) Empleados.get(param)).setCostoh(in.nextDouble());
                                } catch (Exception e) {
                                    System.out.println("Incorrecto, el ingreso debe ser numerico, vuelva a intentarlo");
                                    in.nextLine(); //Consume el salto de linea que no consume el nextDouble
                                    Pausa();
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("\n<<Edicion finalizada>>\n");
                                Pausa();
                                break;
                            }
                            default: {
                                System.out.println("\nOpcion incorrecta, vuelva a intentarlo");
                                Pausa();
                            }
                        }
                    } else if (Empleados.get(param) instanceof Administrativo) {
                        switch (c) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                break;
                            case 6: {
                                System.out.println("\nEl Area actual es <" + ((Administrativo) Empleados.get(param)).getArea() + ">, ingrese el nuevo Area:\n>");
                                ((Administrativo) Empleados.get(param)).setArea(in.nextLine());
                                break;
                            }
                            case 7: {
                                System.out.println("\nEl Salario actual es <" + ((Administrativo) Empleados.get(param)).getSalario() + ">, ingrese el nuevo Salario:\n>");
                                ((Administrativo) Empleados.get(param)).setSalario(in.nextDouble());
                                break;
                            }
                            case 0: {
                                System.out.println("\n<<Edicion finalizada>>\n");
                                Pausa();
                                break;
                            }
                            default: {
                                System.out.println("\nOpcion incorrecta, vuelva a intentarlo");
                                Pausa();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("La opcion debe ser un numero entero, intente nuevamente.");
                in.nextLine(); //Consume el salto de linea que no consume el nextInt y que no llega a consumir el nextLine anterior por la exception
                Pausa();
            }
        }
    }

    //Muestra datos desde codigo unico
    public static void Mostrar() {
        String cu;

        System.out.println("\n----------\nIngrese Codigo Unico para visualizar informacion:\n>");
        cu = in.nextLine();
        if (Empleados.containsKey(cu)) {
            System.out.println("\nEmpleado encontrado:\n" + Empleados.get(cu).toString());
        }
        else {
            System.out.println("\n<<No se encontro ningun empleado con ese codigo>>\n");
        }
        Pausa();
    }

    //Muestra Administrativos
    public static void ListAdm() {
        System.out.println("\n----------\nLos empleados administrativos son:\n");
        for(Object key : Empleados.keySet()) {
            if (Empleados.get(key) instanceof Administrativo) {
                System.out.println(Empleados.get(key).toString() + "\n----------\n");
            }
        }
        Pausa();
    }

    //Muestra Docentes
    public static void ListDoc() {
        System.out.println("\n----------\nLos empleados docentes son:\n");
        for(Object key : Empleados.keySet()) {
            if (Empleados.get(key) instanceof Docente) {
                System.out.println(Empleados.get(key).toString() + "\n----------\n");
            }
        }
        Pausa();
    }

    //Muestra el Administrativo de mayor sueldo
    public static void AdmMayorSueldo() {
        double max = 0;
        String key_max = "";

        for(String key : Empleados.keySet()) {
            if (Empleados.get(key) instanceof Administrativo) {
                if (max < ((Administrativo) Empleados.get(key)).getSalario()) {
                    max = ((Administrativo) Empleados.get(key)).getSalario();
                    key_max = key;
                }
            }
        }
        System.out.println("\nEl Administrativo de mayor sueldo es: \n" + Empleados.get(key_max).toString()+"\n");
        Pausa();
    }

    //Muestra Docentes segun materia
    public static void ListDocMateria() {
        String mat;
        boolean control = false;

        System.out.println("Ingrese la Materia por la que quiere consultar:\n>");
        mat = in.nextLine();

        System.out.println("\n----------\nLos Docentes en la materia " + mat + " son:\n");

        for(String key : Empleados.keySet()) {
            if (Empleados.get(key) instanceof Docente) {
                if (Objects.equals(mat, ((Docente) Empleados.get(key)).getMateria())) {
                    System.out.println(Empleados.get(key).toString() + "\n----------\n");
                    control = true;
                }
            }
        }
        if (!control) {
            System.out.println("<<No se encontraron Docentes asociados a la materia " + mat + ">>\n");
        }
        Pausa();
    }

    public static void Pausa() {
        System.out.println("\nPresione una tecla para continuar....");
        in.nextLine();
        System.out.println("\n----------\n");
    }
}