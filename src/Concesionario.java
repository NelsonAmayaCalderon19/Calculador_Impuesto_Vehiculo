import java.text.*;
import java.util.ArrayList;
public class Concesionario
{
    Vehiculo[] Vehiculos;

    ArrayList <Vehiculo> vehiculos;
    public Concesionario(){
        vehiculos = new ArrayList <Vehiculo>();
    }

    public void guardarCarro(String marca, String linea, String modelo, Double precio){
        vehiculos.add(new Vehiculo(marca,linea,modelo,precio));
    }

    public String verCarros(){
        String list="";
        for(int i=0; i<vehiculos.size();i++){
            list+="Marca → "+vehiculos.get(i).getMarca()+". Linea → "+vehiculos.get(i).getLinea()+". Modelo → "+vehiculos.get(i).getModelo()+". Precio → $ "+vehiculos.get(i).getPrecio().intValue()+"\n";
        }
        return list;
    }

    public Vehiculo buscarCarro(String marca, String linea, String modelo ){
        for(int i=0; i<vehiculos.size();i++){
            if(marca.equals(vehiculos.get(i).getMarca()) && linea.equals(vehiculos.get(i).getLinea()) && modelo.equals(vehiculos.get(i).getModelo())){
                //System.out.println("Marca Registrada");
                return vehiculos.get(i);
            } 

        }
        return null;
    }
}