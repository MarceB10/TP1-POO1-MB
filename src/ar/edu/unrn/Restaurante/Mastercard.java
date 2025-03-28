package ar.edu.unrn.Restaurante;

import java.time.LocalDate;

public class Mastercard extends TarjetaDeCredito{
    private final float descuento;

    public Mastercard(String numero, String titular, LocalDate expiracion) {
        super(numero, titular, expiracion);
        this.descuento = 0.02F; // 2% descuento en platos
    }

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return totalBebidas + (totalPlatos - (totalPlatos * descuento));
    }
}
