package ar.edu.unrn.Restaurante;

import java.time.LocalDate;

public class ComarcaPlus extends TarjetaDeCredito{
    private final float descuento;

    public ComarcaPlus(String numero, String titular, LocalDate expiracion){
        super(numero, titular,expiracion);
        this.descuento = 0.02F;//2% descuento en el total
    }

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos){
        float total = totalBebidas + totalPlatos;
        return total - (total * descuento);
    }


}
