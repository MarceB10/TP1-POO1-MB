package ar.edu.unrn.Restaurante;

public class ItemMenu {
    public enum Tipo { BEBIDA, PLATO }

    private float precio;
    private Tipo tipo;
    private String Descripcion;

    public ItemMenu(float precio, Tipo tipo, String descripcion) {
        checkDescripcionIsValid(descripcion);
        checkPrecioIsValid(precio);
        this.Descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;

    }

    //validaciones
    public void checkDescripcionIsValid(String descripcion){
        if(descripcion == null || descripcion.isBlank()){
          throw new RuntimeException("Descripcion no puede estar vacia");
        }
        if(descripcion.length()> 150){
            throw new RuntimeException("Descripcion demasiado larga");
        }
    }

    public void checkPrecioIsValid(float precio){
        if(precio < 0 ){
            throw new RuntimeException("Precio no puede ser negativo");
        }
    }
    public float precio(){ return precio;}

    public String getDescripcion(){
        return Descripcion;
    }

    public boolean esBebida(){
        return tipo == Tipo.BEBIDA;
    }

    public boolean esPlato(){
        return tipo == Tipo.PLATO;
    }
}
