package mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces;

import mx.unam.dgtic.alumnos_rest.dtos.CalificacionDto;

import java.util.List;

public interface CalificacionDtoService {
    public abstract List<CalificacionDto> findAllCalificaciones();
    public abstract CalificacionDto findById(Long id);
    public abstract CalificacionDto saveCalificacion(CalificacionDto calificacionDto);
    public abstract CalificacionDto updateCalificacion(Long id, CalificacionDto calificacionDto);
    public abstract CalificacionDto deleteCalificacion(Long id);
}
