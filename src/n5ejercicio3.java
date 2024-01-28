
import java.io.*;
import java.util.Arrays;

public class n5ejercicio3 {
    public static void main(String[] args) {

        File directorio = new File("C:\\Temp\\");

        leerDirectorio.leerCarpetas(directorio);
        leerDirectorio.generarArchivoTxt(directorio, "informacionDirectorio.txt");


    }
}

