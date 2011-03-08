import java.io.*;
import java.util.TreeMap;
import java.util.Map;

class CountMap<K, V> extends TreeMap{
    public void putOrIncrement(K key){
        if(get(key) == null)
            put(key, 1);
        else
            put(key, (Integer)get(key)+1);
    }
}

public class Frecuencias{
    public static void plotChars(String origin) throws Exception{
        CountMap<Character, Integer> tabla = new CountMap<Character, Integer>();
           
        //abrir el archivo, podría no encontrarlo
        FileReader in = new FileReader(origin);
        int c = 0;
        
        //leer hasta consumir el flujo
        while( (c = in.read() ) != -1){
            if((c >= 'A' && c <= 'Z' ) || (c >= 'a' && c <= 'z')){
                char leChar = Character.toLowerCase((char)c);
                tabla.putOrIncrement(leChar);
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
        CountMap<String, Integer> tabla = new CountMap<String, Integer>();
        
        BufferedReader in = new BufferedReader(new FileReader(origin));
        String line = "";
        //leer hasta consumir el flujo
        while( (line = in.readLine() ) != null){
            for(String word : line.split("\\W+")){
                tabla.putOrIncrement(word.toLowerCase());
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
