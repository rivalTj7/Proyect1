
package javaapplication6;

import java.io.PrintWriter;



public class reporteHTM {
    
    public static void ReporteH(){
        int [] nums = new int[10];
        try {
            String ruta = "Archivos/Reporte.html";
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println("<HTML>");
            writer.println("<BODY>");
            writer.println("<h1> REPORTE DE CIFRADO </h1>");
            writer.println("<h3> SE INGRESO LA MATRIZ... </h3>");
            for(int i = 0; i < 3; i++){
            writer.println("<table class=\"egt\">");
            writer.println("<tr>");
            writer.println("<td>Celda 1</td>");
            writer.println("<td>Celda 2</td>");
            writer.println("<td>Celda 3</td>");
            writer.println("</tr>");
            writer.println("<tr>");
            writer.println("<td>Celda 4</td>");
            writer.println("<td>Celda 5</td>");
            writer.println("<td>Celda 6</td>");
            writer.println("</tr>");
            writer.println("</table>");
            }
            writer.println("</BODY>");
            writer.println("</HTML>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
