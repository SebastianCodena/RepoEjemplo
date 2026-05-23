/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import modelo.PartidoPadel;
import java.io.*;
import java.util.ArrayList;

public class GestorBinario {
    private String rutaArchivo;

    public GestorBinario(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

   
    public void guardarPartidos(ArrayList<PartidoPadel> partidos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(partidos);
            System.out.println("Datos guardados exitosamente en binario (.dat).");
        } catch (IOException e) {
            System.err.println("Error al guardar en binario: " + e.getMessage());
        }
    }

   
    @SuppressWarnings("unchecked")
    public ArrayList<PartidoPadel> cargarPartidos() {
        ArrayList<PartidoPadel> partidos = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) {
            return partidos;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            partidos = (ArrayList<PartidoPadel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar desde binario: " + e.getMessage());
        }
        return partidos;
    }
}