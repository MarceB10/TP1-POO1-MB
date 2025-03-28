package ar.edu.unrn.Concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;
    private List<Participante> participantes;

    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion){
        this.nombre = nombre;
        this.fechaInicioInscripcion= fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.participantes = new ArrayList<>();
    }

    public void incribirParticipante(Participante participante){
        //comparar si esta dentro del rango de incripcion para ver si se puede inscribir
        //si puede, comparar si es el primer dia para darle 10 puntos
        if(!estaEnRangoDeInscripcion()){
            throw new RuntimeException("Fuera del rango de inscripción");
        }
        participantes.add(participante);

        if(LocalDate.now().isEqual(fechaInicioInscripcion)){
            otorgarPuntos(participante);
        }

    }

    public boolean estaEnRangoDeInscripcion(){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicioInscripcion) && !hoy.isAfter(fechaFinInscripcion);
    }

    public void otorgarPuntos(Participante participante){
        participante.sumarPuntos(10);
    }

}
