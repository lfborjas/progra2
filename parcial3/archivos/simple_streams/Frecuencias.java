import java.io.*;
import java.util.TreeMap;
import java.util.Map;

public class Frecuencias{
    public static void plot(String origin) throws Exception{
        TreeMap<Character, Integer> tabla = new TreeMap<Character, Integer>();
           
        //abrir el archivo, podría no encontrarlo
        FileInputStream in = new FileInputStream(origin);
        int c = 0;
        
        //leer hasta consumir el flujo
        while( (c = in.read() ) != -1){
            if((c >= 65 && c <= 90 ) || (c >= 97 && c <= 122)){
                char leChar = Character.toLowerCase((char)c);
                if(tabla.get(leChar) != null){
                    tabla.put(leChar, tabla.get(leChar)+1);
                }else{
                    tabla.put(leChar, 1);
                }
            }
        }
        //siempre cerrar ! Si no, el flujo se corrompe
        in.close();
        System.out.println("Histograma de frecuencias:\n-------------------------");
        for(Map.Entry<Character, Integer> entry : tabla.entrySet()){
            System.out.print(entry.getKey()+": ");
            for(int i=0; i< entry.getValue(); i++)
                System.out.print("*");
            System.out.println("");
        }

    }

    public static void main (String [] args) throws Exception
    {
        switch(args.length){
            case 1:
                plot(args[0]);
                break;
            default:
                System.out.println("Uso: java Frecuencias [contenido] archivo");
                break;
        }
    }
}
