
package javaapplication6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Archivos {
    /*
    Clase para mandar texto al archivo plano y construir el cifrado...
    */ 
    public void Metodo2(String ubicacion,String contenido){
        try {
            PrintWriter writer = new PrintWriter(ubicacion, "UTF-8");
            writer.println("Primera línea");
            writer.println("Segunda línea");
            writer.println(contenido);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String leerTxt(String direccion){
        String texto = "";
        int a = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader (direccion));
            String temp ="";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead+",";
                a ++;
            }
            texto=temp;
        }catch(Exception e){
            System.err.println("No se encontro archivo");
        }
        return (texto + ","+ a);
    }
    public double Determinante (int i, double [][]matriz){
        if (matriz.length ==2){
            double deter=matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0];
            return deter;
        }
        else {
            double deter=0;
            for (int j=0;j<matriz.length;j++){
               double[][]temp = this.subMatriz(i,j,matriz);
               deter+=(Math.pow(-1, i+j)*matriz[i][j]*this.Determinante(0,temp));
            }
            return deter;
        }
    }
    private double[][] subMatriz(int i, int j, double [][]matriz){
        double[][]temp=new double[matriz.length-1][matriz.length-1];
        int count1=0;
        int count2=0;
        for(int k = 0;k<matriz.length;k++){
            if(k!=i){
                count2=0;
                for(int l = 0; l < matriz.length; l++){
                    if(l!=j){
                        temp[count1][count2]=matriz[k][l];
                        count2++;
                    }
                }
                count1++;
            }
        }
        return temp;
    }
    public double [][]adjunta(double [][]matriz){
        double[][]tempAdjunta=new double[matriz.length][matriz.length];
         for(int i=0;i<tempAdjunta.length;i++){
            for(int j=0;j<tempAdjunta.length;j++){
                double[][]temp = this.subMatriz(i, j, matriz);
                double elementoAdjunto=Math.pow(-1, i+j)*this.Determinante(0,temp);
                tempAdjunta[i][j]=elementoAdjunto;
            }
        }
        return tempAdjunta;
    }
    public double[][]Transpuesta(double [][]matrizAdj){
        double [][]Transpuesta = new double[matrizAdj.length][matrizAdj.length];
        for (int i =0;i<Transpuesta.length;i++){
            for (int j =0;j<Transpuesta.length;j++){
                Transpuesta[i][j]=matrizAdj[j][i];  
            }
        }return Transpuesta;
    }
    public double [][]inv(double dete,double [][]matrizTran){
        int a, inveInt [][] = new int [matrizTran.length][matrizTran.length];
        double inversa [][]= new double [matrizTran.length][matrizTran.length];
        if (dete ==0){  
        }else {
            for (int i =0;i<matrizTran.length;i++){
                for (int j=0;j<matrizTran.length;j++){
                    inversa [i][j]=matrizTran[i][j]/dete;
                }
            }
            /*for (int i =0;i<matrizTran.length;i++){
                for (int j=0;j<matrizTran.length;j++){
                    a = (int)(inversa[i][j]);
                    inveInt[i][j]=a;
                }
            }*/
        }
        return inversa;
    }
    public static int[][] multiMa1(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        // se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
    return c;
    }   
    public int [][]multiMa(double [][] inve,int [][]matri){
        double MatriR [][]= new double [inve.length][matri.length+1];
        int MatriInt [][]= new int [inve.length][matri.length+1];
        float s= 0;
        for(int i = 0; i < inve.length;i++){
            for(int j = 0; j<matri[0].length;j++){
                double suma =0.0;
                for(int k=0;k<inve[0].length;k++){
                    
                    suma+= inve[i][k]*(double)matri[k][j];
                    MatriR[i][j]=suma;
                    s = (float)MatriR[i][j];    //Esta linea 
                    MatriInt[i][j]=Math.round(s);// y esta te asen todo el trabajo jaja :v
                    
                }//System.out.println();
            }
        }
        return MatriInt; 
    }
    //---------------------------------------------------------------------------------------------------------------------GAUUS--
    /*public static void Gaus(int []matri, int aa){
        //-----------------------------------------------------------------------------------------------------------------------
        //System.out.print("Ingrese la dimensión de la matriz cuadrada: ");
            int n = aa, cc=0;
             double a[][]= new double[n][n];
            //System.out.print("Ingrese los elementos de la matriz: ");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = matri[cc];
                    System.out.print(a[i][j]+"  ");
                    cc++;
                } System.out.println();
            }
            double d[][] = multmenos(a);           
            System.out.println("La inversa de la matriz es: ");
            for (int i=0; i<n; ++i) {
                for (int j=0; j<n; ++j){
                    System.out.print(d[i][j]+"  ");
                }
                System.out.println();
            }
        }
        
       //-----------------------------------------------------------------------------------------------------------------------------------

        public static double[][] multmenos(double a[][])         {

            int n = a.length;
            double x[][] = new double[n][n];
            double b[][] = new double[n][n];
            int index[] = new int[n];
            for (int i=0; i<n; ++i)
                b[i][i] = 1;

     //La funcion triangulo convierte la matriz en un triángulo para resolver por gauss

            trianguloGauss(a, index);

     // Ingresamos los cocientes de la matriz
            for (int i=0; i<n-1; ++i)
                for (int j=i+1; j<n; ++j)
                    for (int k=0; k<n; ++k)
                        b[index[j]][k] -= a[index[j]][i]*b[index[i]][k];

     // Aplicamos sustituciones
            for (int i=0; i<n; ++i)             {
                x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)                 {
                    x[j][i] = b[index[j]][i];
                    for (int k=j+1; k<n; ++k)
                    {
                        x[j][i] -= a[index[j]][k]*x[k][i];
                    }

                    x[j][i] /= a[index[j]][j];
                }
            }
            return b;
        }
    // Utilizamos un pivote para el método de gauss
        public static void trianguloGauss(double a[][], int index[])  {

            int n = index.length;
            double c[] = new double[n];
            for (int i=0; i<n; ++i)
                index[i] = i;

     // Acá encontramos los factores reescalando fila por fila
            for (int i=0; i<n; ++i) {
                double c1 = 0;
                for (int j=0; j<n; ++j) {
                    double c0 = Math.abs(a[i][j]);
                    if (c0 > c1) c1 = c0;
                }
                c[i] = c1;
            }

     // Buscamos los pivotes por cada columna
            int k = 0;
            for (int j=0; j<n-1; ++j) {
                double pi1 = 0;
                for (int i=j; i<n; ++i)  {
                    double pi0 = Math.abs(a[index[i]][j]);
                    pi0 /= c[index[i]];
                    if (pi0 > pi1) {
                        pi1 = pi0;
                        k = i;
                    }
                }

       // Intercambiamos filas por el orden del pivote 
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i) {
                    double pj = a[index[i]][j]/a[index[j]][j];

     // Registrar los cocientes de los pivotes por debajo de la diagonal
                    a[index[i]][j] = pj;
                    
                    for (int l=j+1; l<n; ++l)
                        a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        
    }*/
    /*public static void gauuss2(double [][]matriz,int n){
        
        int k,i,j,f=0;
        double q,diag,aux,max=0,retNo=-1.0,mat[][] = new double[0][0];
        for(i=1;i<n;i++){
            for(j=n+2;j<(2*n+1);j++){
                if (i==j-n-1){
                    matriz[i][j]=1;
                }else {
                    matriz[i][j]=0;
                }
            } 
        }
        //Diagonalización
        for (k=1;k<n;k++){
            max= Math.abs(matriz[k][k]);
            f=k;
            for (i=k+1;k<n;k++){
                if (Math.abs(matriz[i][k])>max){
                    max=Math.abs(matriz[i][k]);
                    f=i;
                }
            }
        
            //Verificación de max encontrado.
            if(max!=0){
                //Intercambio de filas k y f.
                for(j=1;j<2*n+1;k++){
                    aux=matriz[k][j];
                    matriz[k][j]=matriz[f][j];
                    matriz[f][j]=aux;
                }
            }else {
                System.out.println("sistema sin solucion");
            }
            //Pivote
            for(i=1;i<n;i++){
                if(i!=k){
                    q=matriz[i][k]/matriz[k][k];
                    matriz[i][k]=0;
                    for(j=k+1;j<2*n+1;j++){
                        matriz[i][j]=matriz[i][j]-(q*matriz[k][j]);
                        
                    }
                }
            }
        } 
        if(matriz[n][n]==0){
            System.out.println("Sistema sin solucion");
        }
        //División de cada fila por su diagonal.
        for(i=1;i<n;i++){
            diag=matriz[i][i];
            for(j=1;j<2*n+1;j++){
                matriz[i][j]=matriz[i][j]/diag;
            }
        }
        
    }*/
    public  void Guass21(int [][]matriz){
        double m[][] = new double[matriz.length][matriz.length];// almacena los coeficientes de la matriz aumentada 
        double r[] = new double[matriz.length];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3
        int n = matriz.length; 
        for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    m[i][j] = matriz[i][j];
                //Double.parseDouble(String.valueOf(jTable.getValueAt(i, j)));

                }
                r[i] = matriz[i][n];
                        //Double.parseDouble(String.valueOf(jTable.getValueAt(i, n)));
            }
            System.out.println("Matriz sin respuestas" + Arrays.deepToString(m));
            System.out.println("Respuestas" + Arrays.toString(r));
            r = this.resol(m, r,n);
            
            
            //pasamos a mostrar las soluciones del sistema en el area de texto
            for (int i = 0; i < n; i++) {
               System.out.println("x" + (i + 1) + " = " + r[i] + "\n");
            }
            
        
    }
    public  double [] resol(double[][]m,double []r,int n){
         
        for (int i = 0; i <n; i++) {
            double d, c = 0;
            d = m[i][i];// seleccionamos el pivote
           System.out.println(Double.toString(1/d) + "*fila" + (i + 1) + "\n");// muesra en el area de texto el pivote seleccionado
            for (int j = 0; j <n; j++) {// pasamos a convertir en 1 al pivote seleionado
                m[i][j] = ((m[i][j]) / d);
            }
            r[i] = ((r[i]) / d);


            // paso a mostrar las opraciones realizadas en la matriz aumentada
            for (int j = 0; j < n; j++) {
                
                for (int k = 0; k < n; k++) {
                   System.out.println(Double.toString(m[j][k]) + "\t");
                }
                System.out.println("|\t" + Double.toString(r[j]) + "\n");
            }
            System.out.println("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada


            for (int x = 0; x <n; x++) {
                if (i != x) {
                    c = m[x][i];
                    System.out.println("-" + Double.toString(c) + " * fila" + (i + 1) + "+ fila" + (x + 1) + "\n");// mustra en pantalla las opraciones que se realizaran por fila
                    for (int y = 0; y <n; y++) {// se hace cero a todos los elemntos de la colunma que no sean el pivote

                        m[x][y] = m[x][y] - c * m[i][y];

                    }
                    r[x] = r[x] - c * r[i];

                    // paso a mostrar las opraciones realizadas en la matriz aumentada
                    for (int j = 0; j < n; j++) {
                       
                        for (int k = 0; k < n; k++) {
                            System.out.println(Double.toString(m[j][k]) + "\t");
                        }
                        System.out.println("|\t" + Double.toString(r[j]) + "\n");
                    }
                    System.out.println("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada


                }// fin if (i != x)
            }// fin for (int x = 0; x <= r.length - 1; x++)


        }//fin bucle i
        return r;// retorna la solucion l sistema
    }
}

