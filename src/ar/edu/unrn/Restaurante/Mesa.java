package ar.edu.unrn.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<ItemMenu> bebidas;
    private List<ItemMenu> platos;
    private String descripcion;

    public Mesa(String descripcion){
        //validacion
        if(descripcion == null || descripcion.isBlank()){
            throw new RuntimeException("Descripcion no puede estar vacia");
        }
        this.descripcion = descripcion;
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();
    }

    public void agregarItem(ItemMenu item){
        if(item.esBebida()){
            bebidas.add(item);
        }else{
            platos.add(item);
        }
    }

    //calculo de totales
    //para esto calculo platos y bebidas por separado en metodos privados

    public float calcularTotal(TarjetaDeCredito tarjeta, Propina propina){
        float totalBebidas = calcularTotalBebidas();
        float totalPlatos = calcularTotalPlatos();

        float totalConDescuento = tarjeta.aplicarDescuento(calcularTotalBebidas(),calcularTotalPlatos());
        return totalConDescuento * (1 + propina.porcentaje());

    }

    private float calcularTotalBebidas(){
        return bebidas.stream().map(ItemMenu::precio).reduce(0f, Float::sum);
    }

    private float calcularTotalPlatos(){
        return platos.stream().map(ItemMenu::precio).reduce(0f, Float::sum);
    }
}
