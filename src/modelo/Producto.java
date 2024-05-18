/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Producto {
    
     int nserie;
    String nombre;
    String fabricante;
    int precio;

    public Producto(int nserie, String nombre, String fabricante, int precio) {
        this.nserie = nserie;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.precio = precio;
    }

    public Producto() {
    }

    
    
    public int getNserie() {
        return nserie;
    }

    public void setNserie(int nserie) {
        this.nserie = nserie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoDAO{" + "nserie=" + nserie + ", nombre=" + nombre + ", fabricante=" + fabricante + ", precio=" + precio + '}';
    }
    
}
