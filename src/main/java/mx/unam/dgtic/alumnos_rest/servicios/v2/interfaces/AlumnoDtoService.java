package mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;

import java.util.List;

public interface AlumnoDtoService {
    public abstract List<AlumnoDto> findAllAlumnos();

    public abstract AlumnoDto findById(Long id);

    public abstract AlumnoDto saveAlumno(AlumnoDto alumnoDto);

    public abstract AlumnoDto updateAlumno(Long id, AlumnoDto alumnoDto);

    public abstract AlumnoDto deleteAlumno(Long id);

    public abstract List<AlumnoDto> getPaginaAlumnosDto(int page, int size, String direction, String sort);
}
