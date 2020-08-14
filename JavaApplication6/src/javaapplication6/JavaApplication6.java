
package javaapplication6;
import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication6 {
    /*
    Hacer el encriptamiento la llave tiene que ser llamada po un archivo .txt
    */
    public static  Archivos n = new Archivos(); //aqui llamo a mi proceso de escritura
    public static String ubicacion;
    public static void main(String[] args) { 
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println("Matrix");
            System.out.println("1.. Cifrar");
            System.out.println("2.. Decifrar");
            System.out.println("3.. Gauss-Jordan");
            System.out.println("4.. Exit");
            System.out.println("Seleccione una opcion");
            int opcion = Integer.parseInt(teclado.nextLine());  
            menu(opcion); //aqui llamo me metodo 
        }
    }
    public static void menu(int opcion){
        
        Scanner teclado = new Scanner(System.in);
        String palabra ;
        switch(opcion){
            case 1:
                System.out.print("Ingrese Texto a Cifrar:");
                palabra = teclado.nextLine();
                System.out.println("Ingrese ruta del archivo de la matriz:");
                ubicacion=teclado.nextLine();
                cifrar(palabra);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.exit(0);
                break;
            default:
            throw new AssertionError();
        }
    }
    public static void cifrar(String palabra){
        int codig[][];
        int contador=0;
        char[] aCaracteres = palabra.toCharArray();
        int as [] = new int [aCaracteres.length];
        for (int x=0;x<aCaracteres.length;x++){
            as[x] = palabra.charAt(x); //Aqui se convierte a Codigo ACSII
            //System.out.println("[" + x + "] " + aCaracteres[x]);
            //System.out.println(" " + as[i]);
            contador++;
        }
        System.out.println("El numero de caracteres es: " + contador);
        int a=0, b=0;
        if(contador % 3 == 0 ){
            //si es multiplo de 2 la matris sera una de 2*2 
            a =contador /3;
            b= 3;
        }else if(contador % 4 ==0){
             a = contador /4;
             b=4;
        }else if (contador%5 == 0){
             a =contador /5;
             b=5;
        }else if (contador %7 ==0 ){
             a =contador /7;
             b=7;
        }else if (contador %11 ==0){
             a =contador /11;
             b=11;
        }else if (contador % 13 == 0){
            a= contador / 13;
            b = 13;
        }else if (contador % 17 ==0){
            a=contador/17;
            b=17;
        }else {
            System.out.println("No. de Caracteres no valido");
        }
        codig = new int[b][a];  //Primera Matriz ------------------------------------------------------------------- 
        int u= 0,p=0,t=0;
        for (int i =0; i<b; i++){
            for(int j = 0; j <a; j++){
                codig[i][j]= as[u];
                //System.out.println(codig[i][j]);
                u ++;
                //n.Metodo2(ubicacion, String.valueOf(codig[i][j]));
                p++;
            }
        t++;
        }
        System.out.println(Arrays.deepToString(codig));
        System.out.println("La matriz creada fue de " + b + " * "+ (a) );
        String  valores,totalText;
        int valoi[][];
        valores = n.leerTxt(ubicacion);
        valores.split(",");
        String[] textElements = valores.split(",");
        for (int i =0; i<textElements.length-1; i++){
            /*for(int j = 0; j <b; j++){
                System.out.println(textElements[i]);
                p++;
            }*/
          //  System.out.println(textElements[i]);
        t++;
        }
        //System.out.println("la matris que se optuvo es de: " + (t-1) );
        System.out.println(textElements.length-1);
        int w = textElements.length-1;
        int s = Integer.valueOf(textElements[w]);
        int e = w/s;
        u=0;
        //System.out.println(textElements[w]);
        //System.out.println(e);
        valoi = new int [s][e];  //SEGUNDA MATRIZ------------------------------------------------------------
        for(int i=0;i<s;i++){
            for(int j=0;j<e;j++){
                valoi[i][j]=Integer.valueOf(textElements[u]);
                //System.out.println(" " + valoi[i][j]);
                u++;
            }
        }
        System.out.println(Arrays.deepToString(valoi));
        System.out.println("La matris dada es de: " + s + " * "+ e );
        //Multiplicacion de Matriz
        System.out.println(a +" -- "+s);
       int MatriR [][]= new int [b][e];
        
        for(int i = 0; i < codig.length;i++){
            for(int j = 0; j<valoi[0].length;j++){
                int suma =0;
                    for(int k=0;k<codig[0].length;k++){
                        suma+= codig[i][k]*valoi[k][j];
                        if(k == valoi[0].length-1){
                            System.out.print("\t"+suma);
                        }
                        MatriR[i][j]=suma;
                    }System.out.println();
            }System.out.println();
        } 
    }
    /*
    por el momento pendiete ----
    */
    /* public static void desifrar(String palabra){
        int contador=0;
        char[] aCaracteres = palabra.toCharArray();

        for (int x=0;x<aCaracteres.length;x++){
        //System.out.println("[" + x + "] " + aCaracteres[x]);
        contador++;
        }
        System.out.println("El numero de caracteres es: " + contador);
    }
      public static void Gauss(String palabra){
        int contador=0;
        char[] aCaracteres = palabra.toCharArray();
        for (int x=0;x<aCaracteres.length;x++){
        System.out.println("[" + x + "] " + aCaracteres[x]);
        contador++;
        }
        System.out.println("El numero de caracteres es: " + contador);

    }*/
    
}
