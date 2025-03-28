package ar.edu.unrn.Concurso;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {
    //1. Un participante se inscribe en un concurso
    @Test
    void testInscripcionDentroDelRango(){
        //se crea un concurso con la fecha de inicio un dia anterior a la del sistema porque si no se sumarian puntos
        // y fecha de fin en 7 dias mas
        Concurso concurso = new Concurso( "Concurso de programaión", LocalDate.now().minusDays(1), LocalDate.now().plusDays(7));
        Participante participante = new Participante("Messi");

        participante.incribirseEnConcurso(concurso);

        assertEquals(0, participante.getPuntos());
    }

//2. Un participante se inscribe en un concurso el primer día de abierta la inscripción

    @Test
    void testInscripcionPrimerDia(){
        //se crea un concurso con la fecha del sistema y fecha de fin en 7 dias más
        Concurso concurso = new Concurso( "Concurso de programaión", LocalDate.now(), LocalDate.now().plusDays(7));
        Participante participante = new Participante("Messi");

        participante.incribirseEnConcurso(concurso);

        assertEquals(10, participante.getPuntos());
    }

    //3. Un participante intenta inscribirse fuera del rango de inscripción
    @Test
    void testInscripcionFueraDelRango(){
        //se crea un concurso con la fecha de inicio del sistema +1 para que este fuera del rango y fecha de fin en 8 dias mas
        Concurso concurso = new Concurso( "Concurso de programaión", LocalDate.now().plusDays(1), LocalDate.now().plusDays(8));
        Participante participante = new Participante("Messi");

        Exception exception = assertThrows(RuntimeException.class, () -> participante.incribirseEnConcurso(concurso));

        assertEquals("Fuera del rango de inscripción", exception.getMessage());

        assertEquals(0, participante.getPuntos());

    }
}