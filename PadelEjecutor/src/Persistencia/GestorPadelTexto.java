/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import modelo.PartidoPadel;
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorPadelTexto {
    private String rutaArchivo;

    public GestorPadelTexto(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

  
    public void guardarPartidos(ArrayList<PartidoPadel> partidos) {
        
        try (FileWriter fw = new FileWriter(rutaArchivo)) { 
            for (PartidoPadel p : partidos) {
            
                fw.write(p.getPareja1() + ";" + p.getPareja2() + ";" + p.getMarcador() + "\n");
            }
            System.out.println("Datos guardados exitosamente en texto plano (.txt) usando FileWriter.");
        } catch (IOException e) {
            System.err.println("Error al guardar en texto: " + e.getMessage());
        }
    }

   
    public ArrayList<PartidoPadel> cargarPartidos() {
        ArrayList<PartidoPadel> partidos = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return partidos;
        }

       
        try (Scanner lector = new Scanner(new FileReader(archivo))) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    PartidoPadel p = new PartidoPadel(datos[0], datos[1], datos[2]);
                    partidos.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar desde texto: " + e.getMessage());
        }
        return partidos;
    }
}