package ar.edu.unrn.Restaurante;

import java.time.LocalDate;

public abstract class TarjetaDeCredito {
    public static final String SALDO_INSUFICIENTE = "El Saldo es Insuficiente";
    public static final String NUMERO_TARJETA_INVALIDO = "El numero de tarjeta NO  es valido";
    public static final String TITULAR_NULO = "El titular no Puede ser Nulo";
    public static final String TARJETA_VENCIDA = "La tarjeta Ya Expiró";

    private String titular;
    private String numeroTarjeta;
    private LocalDate fechaExpiracion;
    private float saldo;

    public TarjetaDeCredito(String numeroTarjeta, String titular, LocalDate fechaExpiracion ){
        checkTitularValido(titular);
        checkNumeroValido(numeroTarjeta);
        checkExpiracion(fechaExpiracion);
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;

    }

    private void checkTitularValido(String titular){
        if(titular.isBlank()){
            throw new RuntimeException("El titular no puede estar vacio.");
        }
    }
    private void checkNumeroValido(String numeroTarjeta){
        if(numeroTarjeta.isBlank()){
            throw new RuntimeException("El numero no puede estar vacio.");
        }
    }

    private void checkExpiracion(LocalDate fechaExpiracion){
        if(fechaExpiracion.isBefore(LocalDate.now())){
            throw new RuntimeException("Tarjeta vencida.");
        }
    }

    public abstract float aplicarDescuento(float precioBebidas, float precioComidas);

}
