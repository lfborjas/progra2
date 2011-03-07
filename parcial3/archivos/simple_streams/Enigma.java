import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Enigma{
    public static String readEnigma(String path) throws Exception{
        StringBuilder letras = new StringBuilder();
           
        //abrir el archivo, podría no encontrarlo
        FileInputStream in = new FileInputStream(path);
        int c = 0;
        
        //leer hasta consumir el flujo
        while( (c = in.read() ) != -1){
            if(c > 65)
                letras.append((char)(c-13));
            else
                letras.append((char)c);
        }
        //siempre cerrar ! Si no, el flujo se corrompe
        in.close();
        
        return letras.toString();
    }

    public static void writeEnigma(String enigma, String destination) throws Exception{
        FileOutputStream out = null;
        out = new FileOutputStream(destination);
        for(char c : enigma.toCharArray()){
            if(((int)c) < 65)
                out.write(c);
            else
                out.write(c+13);
        }
        out.close();
    }

    public static void main (String [] args) throws Exception
    {
        switch(args.length){
            case 1:
                System.out.printf("La solución al enigma es: %s \n", readEnigma(args[0]) );
                break;
            case 2:
                writeEnigma(args[0], args[1]);
                System.out.printf("Escribiendo el enigma %s en %s \n", args[0], args[1]);
                break;
            default:
                System.out.println("Uso: java Enigma [acertijo] archivo");
                break;
        }
    }
}
