package ar.edu.unrn.Restaurante;

public enum Propina {
    BAJO(0.02F), //2%
    MEDIO(0.03F), //3%
    ALTO(0.05F); //4%

    private final float porcentajeDelTotal;

    Propina(float porcentajeDelTotal) {
        this.porcentajeDelTotal = porcentajeDelTotal;
    }

    public float porcentaje() {
        return porcentajeDelTotal;
    }
}