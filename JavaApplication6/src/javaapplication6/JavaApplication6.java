
package javaapplication6;
import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication6 {
    /*
    Hacer el encriptamiento la llave tiene que ser llamada po un archivo .txt
    */
    public static  Archivos n = new Archivos(); //aqui llamo a mi proceso de escritura
    public static String ubicacion;
    public static String ubicacion1;
    public static String ubicacion2;
    public static String ubicacion3;
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
                System.out.println("Ingrese Texto a Cifrar:");
                palabra = teclado.nextLine();
                System.out.println("Ingrese ruta del archivo de la matriz:");
                ubicacion=teclado.nextLine();
                cifrar(palabra);
                break;
            case 2:
                System.out.println("Ingrese ruta de la primera matriz: ");
                ubicacion1=teclado.nextLine();
                System.out.println("Ingrese ruta de la segunda matriz: ");
                ubicacion2=teclado.nextLine();
                desifrar();
                break;
            case 3:
                System.out.println("Ingrese ruta de la matriz: ");
                ubicacion3=teclado.nextLine();
                Gauus_Jordan();
                break;
            case 4:
                System.exit(0);
                break;
            default:
            throw new AssertionError();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
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
       System.out.println(e +" -- "+b);
       if (e==b){
        System.out.println(Arrays.deepToString(n.multiMa1(valoi, codig)));
        }else {
           System.out.println("Matris errones.. ");
       }
    }
    
    public static void desifrar(){//--------------------------------------------------------------------------------------------------------------
        String matri1,matri2;
        matri1 = n.leerTxt(ubicacion1);
        matri2 = n.leerTxt(ubicacion2);
        String  valores,totalText;
        double mat2[][],ee[][],aa[][],inver [][];
        int t , p,mat1[][], multiM[][],multiM2[][];
        t=0;
        p=0;
        matri1.split(",");
        matri2.split(",");
        String[] textElements = matri1.split(",");
        String[] text2 =  matri2.split(",");
        for (int i =0; i<textElements.length-1; i++){  
            t++;
        }
        for (int i =0; i<text2.length-1; i++){
            p++;
        }
        //System.out.println("La primera matris es: " + (textElements.length-1));
        //System.out.println("La segunda matris es: " + (text2.length-1));
        int w = textElements.length-1;
        int s = Integer.valueOf(textElements[w]);
        int e = w/s;
        int u=0;
        int w1 = text2.length-1;
        int s1 = Integer.valueOf(text2[w1]);
        int e1 = w1/s1;
        int u1=0;
        mat1 = new int [s][e];  //Primera MATRIZ-----------------------------------------
        for(int i=0;i<s;i++){
            for(int j=0;j<e;j++){
                mat1[i][j]=Integer.valueOf(textElements[u]);
                //System.out.println(" " + valoi[i][j]);
                u++;
            }
        }
         mat2 = new double [s1][e1];  //SEGUNDA MATRIZ-----------------------------------
        for(int i=0;i<s1;i++){
            for(int j=0;j<e1;j++){
                mat2[i][j]=Integer.valueOf(text2[u1]);
                //System.out.println(" " + valoi[i][j]);
                u1++;
            }
        }
        System.out.println(Arrays.deepToString(mat1));
        System.out.println("La matris dada es de: " + s + " * "+ e);
        System.out.println(Arrays.deepToString(mat2));
        System.out.println("La matris dada es de: " + s1 + " * "+ e1);
        //Funcion inversa prueva 1 
        //logica de la invera: determinante, multiplicarlo por el A 
        double a =n.Determinante(0, mat2);
        ee = new double [s1][e1];
        aa = new double [s1][e1];
        inver = new double [s1][e1];
        System.out.println("El determinante de la matriz es: "+a);
        ee = n.adjunta(mat2);
        aa = n.Transpuesta(ee);
        //System.out.println(Arrays.deepToString(ee));
        //System.out.println(Arrays.deepToString(aa));
        if (a!=0){
        inver = (n.inv(a, aa));   
        System.out.println("La inversa de la matriz 2 es: "+Arrays.deepToString(inver));
        }else {
        System.out.println("No se puede encontrar la inversa de la matriz con determinante 0");
        }
        multiM=new int [mat1.length][inver.length];
        multiM2=new int [mat1.length][inver.length];
        int uuu;
        uuu= multiM.length*multiM[0].length;
        System.out.println(e1+" -- "+s);
        

        if(e1==s){
            //multiM = n.multiMa(inver, mat1);
            System.out.println(inver.length);
            System.out.println(mat1.length);
            multiM2 = n.multiMa(inver, mat1);
            System.out.println("La Multiplicacion es:" + Arrays.deepToString(multiM2));
        }else{
            System.out.println("Error de matriz");
        }
        int asta = multiM2.length*multiM2[0].length;
        byte ascii[]= new byte [asta];
        int ww;
        ww=0;
         for(int i=0;i<multiM2.length;i++){
            for(int j=0;j<multiM2[0].length;j++){
               ascii[ww]=(byte)multiM2[i][j];
                ww++;
            }
        }
        String ssl = new String(ascii);
        System.out.println("             La frase desencriptada es : "+ssl);
            
    }
    //--------------------------------------------------------------------------------------------GAUUS-JORDAN--------------------------------
    public static void Gauus_Jordan(){
        String matri1,valores,totalText;
        matri1 = n.leerTxt(ubicacion3);
        double mat2[][];
        int t=0,p=0,mat1[][], ent[];
        matri1.split(",");
        String[] textElements = matri1.split(",");
        int w = textElements.length-1;
        int s = Integer.valueOf(textElements[w]);
        int e = w/s;
        int u=0;
        mat1 = new int [s][e];  //Primera MATRIZ
        mat2 = new double [s][e];
        ent= new int [s*e];
        for(int i=0;i<s;i++){
            for(int j=0;j<e;j++){
                mat1[i][j]=Integer.valueOf(textElements[u]);
                ent[u]=mat1[i][j];
                mat2[i][j]=mat1[i][j];
                u++;
            }
        }
        System.out.println(Arrays.deepToString(mat1));
        System.out.println("La matris dada es de: " + s + " * "+ e);
        //n.Gaus(ent,s);
        //n.gauuss2(mat2,3);
        n.Guass21(mat1); 
    }
}
