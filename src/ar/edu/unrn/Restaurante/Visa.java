package ar.edu.unrn.Restaurante;

import java.time.LocalDate;

public class Visa extends TarjetaDeCredito{
    private final float descuento;

    public Visa(String numero, String titular, LocalDate expiracion){
        super(numero, titular,expiracion);
        this.descuento = 0.03F;//3% descuento en bebidas
    }

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return totalPlatos + (totalBebidas - (totalBebidas * descuento));
    }
}
