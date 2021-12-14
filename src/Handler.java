//Esta clase guarda y recupera los registro mediante el uso de serialization.
//Los registros se almacenan en un fichero de nombre "Empleados.ser"
//Lee los registros cuando se inicia el programa y guarda el estado final cuando se sale del mismo


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Handler {
    //private static Map<String, Empleado> Empleados = new TreeMap<String, Empleado>();

    public Handler() {
    }

    public static void Guardar(Map<String,Empleado> Emp) {
        //Map<String, Empleado> Empleados2 = new TreeMap<String, Empleado>();;
        try {
            FileOutputStream guardado = new FileOutputStream("Empleados.ser");
            ObjectOutputStream out = new ObjectOutputStream(guardado);
            out.writeObject(Emp);
            out.close();
            guardado.close();
            System.out.println("Se ha guardado el padrón de forma exitosa");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static Map<String, Empleado> Leer() {
        Map<String, Empleado> Emp = new TreeMap<String, Empleado>();
        try {
            FileInputStream fileIn = new FileInputStream("Empleados.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Emp = (Map<String, Empleado>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            System.out.println("falla1");
            //return;
        } catch (ClassNotFoundException c) {
            System.out.println("Clase Empleado no encontrada");
            c.printStackTrace();
            System.out.println("falla2");
            //return;
        }
        return Emp;
    }
}