import java.io.*;

public class IOExample{
    public static String read(String origin) throws Exception{
        StringBuilder letras = new StringBuilder();
           
        //abrir el archivo, podría no encontrarlo
        FileInputStream in = new FileInputStream(origin);
        int c = 0;
        
        //leer hasta consumir el flujo
        while( (c = in.read() ) != -1){
                System.out.printf("Leído: %d\n", c);
                letras.append((char)c);
        }
        //siempre cerrar ! Si no, el flujo se corrompe
        in.close();
        
        return letras.toString();
    }

    public static void write(String txt, String destination) throws Exception{
        FileOutputStream out = null;
        out = new FileOutputStream(destination);
        for(char c : txt.toCharArray()){
                out.write(c);
        }
        out.close();
    }

    public static void main (String [] args) throws Exception
    {
        switch(args.length){
            case 1:
                System.out.printf("El contenido es: %s \n", read(args[0]));
                break;
            case 2:
                write(args[0], args[1]);
                System.out.printf("Escribiendo %s en %s \n", args[0], args[1]);
                break;
            default:
                System.out.println("Uso: java IOExample [contenido] archivo");
                break;
        }
    }
}
