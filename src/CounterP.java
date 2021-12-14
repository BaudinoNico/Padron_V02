//Esta clase gestiona la persistencia de los contadores que se utilizan para la nomenclatura de cada registro.
//La primera vez que se ejecuta genera un fichero "counters" que contiene el índice de Docentes y Administrativos
//Si el fichero existe lo lee y asigna las variables al último valor conocido
//Al ingresar un registro nuevo de cualquier tipo actualiza el fichero con los nuevos índices

import java.io.*;

public class CounterP {
    public static int[] Leer() throws IOException {
        File arch= new File ( "counters");
        int[] result = new int[2];
        if (arch.exists()) {
            FileReader lector = new FileReader(arch);
            BufferedReader bLector = new BufferedReader(lector);
            result[0] = Integer.parseInt(bLector.readLine());
            result[1] = Integer.parseInt(bLector.readLine());
            return result;
        } else {
            FileWriter fwescribir= new FileWriter(arch);
            BufferedWriter bwescribir= new BufferedWriter (fwescribir);
            bwescribir.write("0");
            bwescribir.newLine();
            bwescribir.write("0");
            bwescribir.flush();
            bwescribir.close();
            result[0] = 0;
            result[1] = 0;
            return result;
        }

    }

    public static void Guardar(int iadm, int idoc) throws IOException {
        File arch= new File ( "counters");
        FileWriter fwescribir = new FileWriter(arch);
        BufferedWriter bwescribir = new BufferedWriter(fwescribir);
        bwescribir.write(String.valueOf(iadm));
        bwescribir.newLine();
        bwescribir.write(String.valueOf(idoc));
        bwescribir.flush();
        bwescribir.close();
    }
}

