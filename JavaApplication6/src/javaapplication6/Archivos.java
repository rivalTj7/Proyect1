
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
                temp = temp + bfRead;
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
    public int [][]multiMa1(int [][] codig,int [][]valoi){
        int MatriR [][]= new int [codig.length][valoi.length];     
        for(int i = 0; i < codig.length;i++){
            for(int j = 0; j<valoi[0].length;j++){
                int suma =0;
                for(int k=0;k<codig[0].length;k++){
                    suma+= codig[i][k]*valoi[k][j];
                    if(k == valoi[0].length-1){
                        // System.out.print(suma);
                    }
                    MatriR[i][j]=suma;
                }//System.out.println();
            }
        }
        return MatriR; 
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
                    s = (float)MatriR[i][j];
                    MatriInt[i][j]=Math.round(s);
                }//System.out.println();
            }
        }
        /*for (int i =0;i<MatriR.length;i++){
            for (int j=0;j<MatriR[0].length;j++){
                MatriR2[i][j] = (int)(MatriR[i][j]);
            }
        }*/
        return MatriInt; 
    }
    //---------------------------------------------------------------------------------------------------------------------GAUUS--
    public static void Gaus(int []matri, int aa){
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
                        b[index[j]][k]
                        	    -= a[index[j]][i]*b[index[i]][k];

     
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
            return x;
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
        
    }
    
    
}

