import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Principal {
    private static int idoc=0, iadm=0;
    private static Map<String,Docente> Docentes = new TreeMap<String,Docente>();
    private static Map<String,Administrativo> Administrativos = new TreeMap<String, Administrativo>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        //Empleados para probar funcionalidad
        Docentes.put("Doce0", new Docente(33069335, "Nico", "Bau", "Esp 1960", "Poli", "Arq", "Dib", 8, 650));
        Docentes.put("Doce1", new Docente(33562331, "Gime", "Can", "Esp 1916", "Lat", "Arq", "Const", 16, 800));
        Administrativos.put("Adm0", new Administrativo(12621880, "Cata", "Soto", "Rio 333", "Lat", "Cobr", 70000));
        //Empleados para probar funcionalidad

        DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("\nBienvenido al Sistema de Padron de Empleados!\nHoy es " + dia.format(ahora) + " y son las " + hora.format(ahora) + '\n');

        while (opcion != 9) {
            try {
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
            banderacre = false;
            System.out.println("\n----------\nIngrese 1 para Docente o 2 para Administrativo y presione enter:\n>");
            tipor = in.nextInt();
            switch (tipor) {
                case 1:
                    nombre_ins = "Doc" + idoc;
                    System.out.println("\n----------\n- Ingrese el DNI...");
                    dni = in.nextInt();
                    in.nextLine();
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
                    Docentes.put(nombre_ins, new Docente(dni, nom, ape, dir, ins, tit, mat, hor, cos));
                    System.out.println("\n----------\nUsted ha creado la siguiente entrada:\nCodigo unico: " + nombre_ins + '\n' + Docentes.get(nombre_ins).toString());
                    System.out.println("\nPresione una tecla para continuar....");
                    in.nextLine();
                    idoc++;
                    break;
                case 2:
                    nombre_ins = "Adm" + iadm;
                    System.out.println("- Ingrese el DNI...");
                    dni = in.nextInt();
                    in.nextLine();
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
                    Administrativos.put(nombre_ins, new Administrativo(dni, nom, ape, dir, ins, are, sal));
                    System.out.println("\n----------\nUsted ha creado la siguiente entrada:\nCodigo unico: " + nombre_ins + '\n' + Administrativos.get(nombre_ins).toString());
                    iadm++;
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo.");
                    banderacre = true;
            }
        }
    }

    public static void Eliminar() {
        String parambusq;
        int dnibusq;

        System.out.println("\n---------\nIngrese Codigo Unico o DNI para eliminar un registro:\n>");
        in.nextLine();
        parambusq = in.nextLine();

        if (esDNI(parambusq)){
            dnibusq = Integer.parseInt(parambusq);
            if(Elim_Busq_DocDNI(Docentes,dnibusq)){
                System.out.println("\n<<El registro ha sido eliminado>>");
            }
            else if (Elim_Busq_AdmDNI(Administrativos,dnibusq)){
                System.out.println("\n<<El registro ha sido eliminado>>");
            }
            else {
                System.out.println("\n<<No se encontro ningun registro>>");
            }
        }
        else if (Elim_Busq_DocCU(Docentes,parambusq)){
            System.out.println("\n<<El registro ha sido eliminado>>");
        }
        else if (Elim_Busq_AdmCU(Administrativos,parambusq)) {
            System.out.println("\n<<El registro ha sido eliminado>>\n---------\n");
        }
        else {
            System.out.println("\n<<No se encontro ningun registro>>");
        }
    }

        /* ESTE ES EL METODO DE BUSQUEDA LOOPEANDO PARA CU y DNI, SOLO EN DOCENTES
        for(Object key : Docentes.keySet()) {
            if (key.equals(parambusq)) {
                System.out.println("Esta seguro que desea eliminar a " + Docentes.get(parambusq).getNombre() + " " + Docentes.get(parambusq).getApellido() + "?");
                System.out.println("S / N");
                confirm = in.nextLine();
                if (confirm.equals("S")) {
                    Docentes.remove(parambusq);
                    System.out.println("\n<<El registro ha sido eliminado>>");
                    break;
                }
                else {
                    System.out.println("<<Operacion cancelada>>");
                    break;
                }
            }
        }
        for (Object key : Docentes.keySet()) {
            dni2 = String.valueOf(Docentes.get(key).getDni());
            if (parambusq.equals(dni2)) {
                    System.out.println("Esta seguro que desea eliminar a " + Docentes.get(key).getNombre() + Docentes.get(key).getApellido() + "?");
                    System.out.println("y / N");
                    confirm = in.nextLine();
                    if (confirm.equals("y")) {
                        Docentes.remove(key);
                        System.out.println("El registro ha sido eliminado");
                        break;
                    }
                    else {
                        System.out.println("Operacion cancelada");
                        break;
                    }
                }
         */

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

    //Busca a quien eliminar en Docente segun el DNI
    public static boolean Elim_Busq_DocDNI (Map<String,Docente> mapa, int param) {
        String confirm;
        for(Object key : mapa.keySet()) {
            if (param == mapa.get(key).getDni()) {
                System.out.println("Esta seguro que desea eliminar a " + mapa.get(key).getNombre() + " " + mapa.get(key).getApellido() + "?");
                System.out.println("S / N");
                confirm = in.nextLine();
                if (confirm.equals("S")) {
                    Docentes.remove(key);
                    return true;
                }
                else {
                    System.out.println("<<Operacion cancelada>>");
                    return false;
                }
            }
        }
        return false;
    }

    //Busca a quien eliminar en Administrativos segun el DNI
    public static boolean Elim_Busq_AdmDNI (Map<String,Administrativo> mapa, int param) {
        String confirm;
        for(Object key : mapa.keySet()) {
            if (param == mapa.get(key).getDni()) {
                System.out.println("Esta seguro que desea eliminar a " + mapa.get(key).getNombre() + " " + mapa.get(key).getApellido() + "?");
                System.out.println("S / N");
                confirm = in.nextLine();
                if (confirm.equals("S")) {
                    Administrativos.remove(key);
                    return true;
                }
                else {
                    System.out.println("<<Operacion cancelada>>");
                    return false;
                }
            }
        }
        return false;
    }

    // Busca a quien eliminar en Docentes segun el Codigo Unico
    public static boolean Elim_Busq_DocCU (Map<String,Docente> mapa, String param) {
        String confirm;
        if (mapa.containsKey(param)) {
            System.out.println("Esta seguro que desea eliminar a " + mapa.get(param).getNombre() + " " + mapa.get(param).getApellido() + "?");
            System.out.println("S / N");
            confirm = in.nextLine();
            if (confirm.equals("S")) {
                Docentes.remove(param);
                return true;
            }
            else {
                System.out.println("<<Operacion cancelada>>");
                return false;
            }
        }
        return false;
    }

    // Busca a quien eliminar en Administrativos segun el Codigo Unico
    public static boolean Elim_Busq_AdmCU (Map<String,Administrativo> mapa, String param) {
        String confirm;
        if (mapa.containsKey(param)) {
            System.out.println("Esta seguro que desea eliminar a " + mapa.get(param).getNombre() + " " + mapa.get(param).getApellido() + "?");
            System.out.println("S / N");
            confirm = in.nextLine();
            if (confirm.equals("S")) {
                Administrativos.remove(param);
                return true;
            }
            else {
                System.out.println("<<Operacion cancelada>>");
                return false;
            }
        }
        return false;
    }

    //Modifica datos segun CU o DNI
    public static void Modificar() {
        String parambusq;
        int campo;

        System.out.println("\n---------\nIngrese Codigo Unico para editar un registro:\n>");
        in.nextLine();
        parambusq = in.nextLine();

        if (Docentes.containsKey(parambusq)) {
            System.out.println("\nRegistro encontrado, se muestran los datos correspondientes:" + Docentes.get(parambusq).toString());
            System.out.println("\nPresione una tecla para continuar....");
            in.nextLine();
            EditarDocentes(parambusq);
        } else if (Administrativos.containsKey(parambusq)) {
            System.out.println("\nRegistro encontrado, se muestran los datos correspondientes:" + Administrativos.get(parambusq).toString());
            EditarAdministrativos(parambusq);
        } else {
            System.out.println("\n<<No se encontro ningun registro asociado a ese Codigo Unico>>\n");
        }
    }

    public static void EditarDocentes(String param) {
        int c=0;
        while (c!=10) {
            System.out.println("\nIngrese el numero de campo a editar:\n" + Docentes.get(param).campos() + "10- Finalizar edicion\n");
            c = in.nextInt();
            in.nextLine();
            switch (c) {
                case 1: {
                    System.out.println("\nEl DNI actual es <" + Docentes.get(param).getDni() + ">, ingrese el nuevo DNI:\n>");
                    Docentes.get(param).setDni(in.nextInt());
                    in.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("\nEl Nombre actual es <" + Docentes.get(param).getNombre() + ">, ingrese el nuevo Nombre:\n>");
                    Docentes.get(param).setNombre(in.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("\nEl Apellido actual es <" + Docentes.get(param).getApellido() + ">, ingrese el nuevo Apellido:\n>");
                    Docentes.get(param).setApellido(in.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("\nLa Direccion actual es <" + Docentes.get(param).getDireccion() + ">, ingrese la nueva Direccion:\n>");
                    Docentes.get(param).setDireccion(in.nextLine());
                    break;
                }
                case 5: {
                    System.out.println("\nLa Institucion actual es <" + Docentes.get(param).getInstitucion() + ">, ingrese la nueva Institucion:\n>");
                    Docentes.get(param).setInstitucion(in.nextLine());
                    break;
                }
                case 6: {
                    System.out.println("\nEl Titulo actual es <" + Docentes.get(param).getTitulo() + ">, ingrese el nuevo Titulo:\n>");
                    Docentes.get(param).setTitulo(in.nextLine());
                    break;
                }
                case 7: {
                    System.out.println("\nLa Materia actual es <" + Docentes.get(param).getMateria() + ">, ingrese la nueva Materia:\n>");
                    Docentes.get(param).setMateria(in.nextLine());
                    break;
                }
                case 8: {
                    System.out.println("\nLa Cantidad de Horas Semanales actual es <" + Docentes.get(param).getHoras() + ">, ingrese la nueva cantidad:\n>");
                    Docentes.get(param).setHoras(in.nextDouble());
                    break;
                }
                case 9: {
                    System.out.println("\nEl Monto por Hora actual es <" + Docentes.get(param).getCostoH() + ">, ingrese el nuevo monto:\n>");
                    Docentes.get(param).setCostoh(in.nextDouble());
                    break;
                }
                case 10: {
                    System.out.println("\n<<Edicion finalizada>>\n");
                    break;
                }
                default: {
                    System.out.println("\nOpcion incorrecta, vuelva a intentarlo");
                }
            }
        }
    }

    public static void EditarAdministrativos(String param) {
        int c=0;
        while (c!=8) {
            System.out.println("\nIngrese el numero de campo a editar:\n" + Administrativos.get(param).campos() + "8- Finalizar edicion\n");
            c = in.nextInt();
            in.nextLine();
            switch (c) {
                case 1: {
                    System.out.println("\nEl DNI actual es <" + Administrativos.get(param).getDni() + ">, ingrese el nuevo DNI:\n>");
                    Administrativos.get(param).setDni(in.nextInt());
                    in.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("\nEl Nombre actual es <" + Administrativos.get(param).getNombre() + ">, ingrese el nuevo Nombre:\n>");
                    Administrativos.get(param).setNombre(in.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("\nEl Apellido actual es <" + Administrativos.get(param).getApellido() + ">, ingrese el nuevo Apellido:\n>");
                    Administrativos.get(param).setApellido(in.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("\nLa Direccion actual es <" + Administrativos.get(param).getDireccion() + ">, ingrese la nueva Direccion:\n>");
                    Administrativos.get(param).setDireccion(in.nextLine());
                    break;
                }
                case 5: {
                    System.out.println("\nLa Institucion actual es <" + Administrativos.get(param).getInstitucion() + ">, ingrese la nueva Institucion:\n>");
                    Administrativos.get(param).setInstitucion(in.nextLine());
                    break;
                }
                case 6: {
                    System.out.println("\nEl Area actual es <" + Administrativos.get(param).getArea() + ">, ingrese el nuevo Area:\n>");
                    Administrativos.get(param).setArea(in.nextLine());
                    break;
                }
                case 7: {
                    System.out.println("\nEl Salario actual es <" + Administrativos.get(param).getSalario() + ">, ingrese el nuevo Salario:\n>");
                    Administrativos.get(param).setSalario(in.nextDouble());
                    break;
                }
                case 8: {
                    System.out.println("\n<<Edicion finalizada>>\n");
                    break;
                }
                default: {
                    System.out.println("\nOpcion incorrecta, vuelva a intentarlo");
                }
            }
        }
    }

    //Muestra datos desde codigo unico
    public static void Mostrar() {
        String coduni;

        System.out.println("\n----------\nIngrese Codigo Unico para visualizar informacion:\n>");
        in.nextLine();
        coduni = in.nextLine();
        if (Docentes.containsKey(coduni)) {
            System.out.println("\nEmpleado encontrado:\n> " + Docentes.get(coduni).toString());
        }
        else if (Administrativos.containsKey(coduni)) {
            System.out.println("\nEmpleado encontrado:\n> " + Administrativos.get(coduni).toString());
        }
        else {
            System.out.println("\n<<No se encontro ningun empleado con ese codigo>>\n");
            System.out.println("Presione una tecla para continuar....");
            in.nextLine();
        }
    }

    //Muestra Administrativos
    public static void ListAdm() {
        System.out.println("\n----------\nLos empleados administrativos son:\n");
        for(Object key : Administrativos.keySet()) {
            System.out.println(Administrativos.get(key).toString() + "\n----------\n");
        }
        System.out.println("Presione una tecla para continuar....");
        in.nextLine();
    }

    //Muestra Docentes
    public static void ListDoc() {
        System.out.println("\n----------\nLos empleados docentes son:\n");
        for(Object key : Docentes.keySet()) {
            System.out.println(Docentes.get(key).toString() + "\n----------\n");
        }
        System.out.println("Presione una tecla para continuar....");
        in.nextLine();
    }

    //Muestra el Administrativo de mayor sueldo
    public static void AdmMayorSueldo() {
        double max = 0;
        String key_max = "";

        for (String key : Administrativos.keySet()) {
            if (max < Administrativos.get(key).getSalario()) {
                max = Administrativos.get(key).getSalario();
                key_max = key;
            }
        }
        System.out.println("\nEl Administrativo de mayor sueldo es: \n" + Administrativos.get(key_max).toString()+"\n");
        System.out.println("Presione una tecla para continuar....");
        in.nextLine();
    }

    //Muestra Docentes segun materia
    public static void ListDocMateria() {
        String mat;
        Boolean control = false;

        System.out.println("Ingrese la Materia por la que quiere consultar:\n>");
        in.nextLine();
        mat = in.nextLine();

        System.out.println("\n----------\nLos Docentes en la materia " + mat + " son:\n");

        for(Object key : Docentes.keySet()) {
            if (mat == Docentes.get(key).getMateria()) {
                System.out.println(Docentes.get(key).toString() + "\n----------\n");
                control = true;
            }
        }
        if (control == false) {
            System.out.println("<<No se encontraron Docentes asociados a la materia " + mat + ">>");
            System.out.println("Presione una tecla para continuar....");
            in.nextLine();
        }
    }
}