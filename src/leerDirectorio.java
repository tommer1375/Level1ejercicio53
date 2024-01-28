
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.*;
public class leerDirectorio {

    public static void leerCarpetas(File root) {


        File[] archivos = root.listFiles();

        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");

        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                if (archivos[i].isDirectory()) {
                    leerCarpetas(archivos[i]);
                }
            }
        }
    }

    public static void generarArchivoTxt(File root, String outputPath) {
        try {
            FileWriter writer = new FileWriter(outputPath);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            escribirEnArchivo(root, writer, sdf);

            writer.close();
            System.out.println("Se ha generado el archivo " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escribirEnArchivo(File root, FileWriter writer, SimpleDateFormat sdf) throws IOException {
        File[] archivos = root.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                writer.write(String.format("%s (%s) - %s%n",
                        archivo.getAbsolutePath(),
                        archivo.isDirectory() ? "D" : "F",
                        sdf.format(archivo.lastModified())));

                if (archivo.isDirectory()) {
                    escribirEnArchivo(archivo, writer, sdf);
                }
            }
        }
    }
}



