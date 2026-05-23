/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

public class PartidoPadel implements Serializable {
   
    private static final long serialVersionUID = 1L;

    private String pareja1;
    private String pareja2;
    private String marcador; 

    
    public PartidoPadel() {
    }

  
    public PartidoPadel(String pareja1, String pareja2, String marcador) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.marcador = marcador;
    }

    
    public String getPareja1() { return pareja1; }
    public void setPareja1(String pareja1) { this.pareja1 = pareja1; }

    public String getPareja2() { return pareja2; }
    public void setPareja2(String pareja2) { this.pareja2 = pareja2; }

    public String getMarcador() { return marcador; }
    public void setMarcador(String marcador) { this.marcador = marcador; }

    
    @Override
    public String toString() {
        return "Partido: " + pareja1 + " VS " + pareja2 + " | Marcador: " + marcador;
    }
}