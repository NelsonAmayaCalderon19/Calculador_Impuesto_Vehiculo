import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vehiculo
{
     private String marca;
     private String linea;
     private String modelo;
     protected Double precio;
     

    public Vehiculo() {
        
    }

    public Vehiculo(String marca, String linea, String modelo, Double precio) {
    this.marca = marca;
    this.linea = linea;
    this.modelo = modelo;
    this.precio = precio;

    }
  
   public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}

