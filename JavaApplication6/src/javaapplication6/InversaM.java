/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author Gabriela
 */
public class InversaM {
     public double Determinante (int i, double [][]matriz){
        if (matriz.length ==2){
            double deter=matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0];
            return deter;
        }
        else {
            double deter=0;
            for (int j=0;j<matriz.length;j++){
               double[][]temp = this.subMatriz(i,j,matriz);
               deter=deter+Math.pow(-1, i+j)*matriz[i][j]*this.Determinante(0,temp);
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
                    if(l!=0){
                        temp[count1][count2]=matriz[k][l];
                        count2++;
                    }
                }
                count1++;
            }
        }
        return temp;
    }
    public double [][]AdjuntaMatriz(double [][]matriz){
        double[][]tempAdjunta=new double[matriz.length][matriz.length];
        for(int i=0;i<tempAdjunta.length;i++){
            for(int j=0;j<tempAdjunta.length;j++){
                double[][]temp=this.subMatriz(i, j, matriz) ;
                double elementoAdjunto=Math.pow(-1, i+j)*this.Determinante(0, temp);
                tempAdjunta[i][j]=elementoAdjunto;                
            }
        }
        return tempAdjunta;
    }
    public double[][]TransouestaMatriz(double [][]matriz){
        double[][]tempTranspuesta = new double [matriz.length][matriz.length];
        for (int i = 0;i < tempTranspuesta.length; i++){
            for(int j=0;j<tempTranspuesta.length;j++){
                tempTranspuesta[i][j]=matriz[j][i];
            }
        }
        return tempTranspuesta;
    }
}
