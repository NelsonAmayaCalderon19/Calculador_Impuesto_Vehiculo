
public class CalculadorImpuestos
{
    private Double impuesto;
        public CalculadorImpuestos(Vehiculo carro){
        impuesto = calcularImpuestos(carro);
    }

    public Double calcularImpuestos(Vehiculo carro){
        if(carro.precio >= 0.0 && carro.precio <= 30000000.0){
                return (carro.precio * 1.5) / 100;
        }
        if(carro.precio > 30000000.0 && carro.precio <= 70000000.0){
                return (carro.precio * 2.0) / 100;
        }
        if(carro.precio > 70000000.0 && carro.precio <= 200000000.0){
                return (carro.precio * 2.5) / 100;
        }
        if(carro.precio > 200000000.0){
                return (carro.precio * 4.0) / 100;
        }
        return 0.0;
    }
    public Double descuentos(ImpuestoVehiculo v){
        if(v.cbPPago.isSelected()){
            impuesto = impuesto - ((impuesto * 10.0) / 100);
        }
        if(v.cbSPublico.isSelected()){
            impuesto = impuesto - 50000.0;
        }
        if(v.cbTCuenta.isSelected()){
            impuesto = impuesto - ((impuesto * 5.0) / 100);
        }
        return impuesto;
    }
}