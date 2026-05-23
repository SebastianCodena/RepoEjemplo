/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package padelejecutor;

import Persistencia.GestorBinario;
import Persistencia.GestorPadelTexto;
import java.util.ArrayList;
import modelo.PartidoPadel;

/**
 *
 * @author SebastianCodena
 */
public class PadelEjecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String archivoBinario = "partidos.dat";
        String archivoTexto = "partidos.txt";

        
        ArrayList<PartidoPadel> listaOriginal = new ArrayList<>();
        listaOriginal.add(new PartidoPadel("Juan/Pedro", "Carlos/Luis", "6-3 / 7-5"));
        listaOriginal.add(new PartidoPadel("Maria/Ana", "Sofia/Elena", "6-2 / 4-6 / 6-1"));

        System.out.println("=== GUARDANDO DATOS ===");
        
        
        GestorBinario gestorBinario = new GestorBinario(archivoBinario);
        gestorBinario.guardarPartidos(listaOriginal);

        
        GestorPadelTexto gestorTexto = new GestorPadelTexto(archivoTexto);
        gestorTexto.guardarPartidos(listaOriginal);

        System.out.println("\n=== CARGANDO DATOS DESDE LOS ARCHIVOS ===");

        
        System.out.println("\n-> Recuperando del archivo .dat:");
        ArrayList<PartidoPadel> listaDesdeBinario = gestorBinario.cargarPartidos();
        for (PartidoPadel p : listaDesdeBinario) {
            System.out.println(p);
        }

        
        System.out.println("\n-> Recuperando del archivo .txt:");
        ArrayList<PartidoPadel> listaDesdeTexto = gestorTexto.cargarPartidos();
        for (PartidoPadel p : listaDesdeTexto) {
            System.out.println(p);
        }
    }
}