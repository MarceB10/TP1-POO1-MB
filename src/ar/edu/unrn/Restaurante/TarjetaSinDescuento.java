package ar.edu.unrn.Restaurante;

import java.time.LocalDate;

public class TarjetaSinDescuento extends TarjetaDeCredito {
    public TarjetaSinDescuento(String numero, String titular, LocalDate expiracion) {
        super(numero, titular, expiracion);
    }

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return totalBebidas + totalPlatos;
    }

}
