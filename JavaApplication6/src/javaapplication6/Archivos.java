
package javaapplication6;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    /*public static double Mensa(double [][]matriz){
        double inversa [][];
        
        for (int i =0;i<matriz.length;i++){
            for (int j=0;j<matriz.length;j++){
                String Mensa = matriz[i][j]+"\t";
            }
        }
        return inversa;
    } */
    public int [][]inv(double dete,double [][]matrizTran){
        int a, inveInt [][] = new int [matrizTran.length][matrizTran.length];
        double inversa [][]= new double [matrizTran.length][matrizTran.length];
        if (dete ==0){
            
        }else {
            for (int i =0;i<matrizTran.length;i++){
                for (int j=0;j<matrizTran.length;j++){
                    inversa [i][j]=matrizTran[i][j]/dete;
                }
            }
            for (int i =0;i<matrizTran.length;i++){
                for (int j=0;j<matrizTran.length;j++){
                    a = (int)(inversa[i][j]);
                    inveInt[i][j]=a;
                }
            }
        }
        return inveInt;
    }
    public int [][]multiMa(int [][] codig,int [][]valoi){
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
}

