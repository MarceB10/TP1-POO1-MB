package ar.edu.unrn.Concurso;

public class Participante {
    private String nombreParticipante;
    private int puntos;

    public Participante(String nombre){
        this.nombreParticipante = nombre;
        this.puntos = 0;
    }

    public void incribirseEnConcurso(Concurso concurso){
        concurso.incribirParticipante(this);
    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }

    public int getPuntos(){
        return puntos;
    }

}