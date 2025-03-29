package mx.unam.dgtic.alumnos_rest.servicios.v1.interfaces;

import mx.unam.dgtic.alumnos_rest.models.Calificacion;

import java.util.List;

public interface CalificacionService {
    public abstract List<Calificacion> findAllCalificaciones();
    public abstract Calificacion findById(Long id);
    public abstract Calificacion saveCalificacion(Calificacion calificacion);
    public abstract Calificacion updateCalificacion(Long id, Calificacion calificacion);
    public abstract Calificacion deleteCalificacion(Long id);
}
