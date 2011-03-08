import java.io.*;
import java.util.TreeMap;
import java.util.Map;

public class Frecuencias{
    public static void plotChars(String origin) throws Exception{
        TreeMap<Character, Integer> tabla = new TreeMap<Character, Integer>();
           
        //abrir el archivo, podría no encontrarlo
        FileReader in = new FileReader(origin);
        int c = 0;
        
        //leer hasta consumir el flujo
        while( (c = in.read() ) != -1){
            if((c >= 'A' && c <= 'Z' ) || (c >= 'a' && c <= 'z')){
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
        printHistogram(tabla);

    }
    
    private static void printHistogram(TreeMap<?, Integer> histogram){
        System.out.println("Histograma de frecuencias:\n-------------------------");
        for(Map.Entry<?, Integer> entry : histogram.entrySet()){
            System.out.print(entry.getKey()+": ");
            for(int i=0; i< (Integer)entry.getValue(); i++)
                System.out.print("*");
            System.out.println("");
        }
    }

    public static void plotWords(String origin) throws Exception{
        TreeMap<String, Integer> tabla = new TreeMap<String, Integer>();
        
        BufferedReader in = new BufferedReader(new FileReader(origin));
        String line = "";
        //leer hasta consumir el flujo
        while( (line = in.readLine() ) != null){
            for(String word : line.split("\\W+")){
                if(tabla.get(word) != null){
                    tabla.put(word, tabla.get(word)+1);
                }else{
                    tabla.put(word, 1);
                }
            }
        }
        //siempre cerrar ! Si no, el flujo se corrompe
        in.close();
        printHistogram(tabla);
    }

    public static void main (String [] args) throws Exception
    {
        switch(args.length){
            case 1:
                plotChars(args[0]);
                break;
            case 2:
                plotWords(args[1]);
                break;
            default:
                System.out.println("Uso: java Frecuencias [--palabras] archivo");
                break;
        }
    }
}
