package mx.unam.dgtic.alumnos_rest.servicios.v1.interfaces;

import mx.unam.dgtic.alumnos_rest.models.Alumno;

import java.util.List;

public interface AlumnoService {
    public abstract List<Alumno> findAllAlumnos();
    public abstract Alumno findById(Long id);
    public abstract Alumno saveAlumno(Alumno alumno);
    public abstract Alumno updateAlumno(Long id, Alumno alumno);
    public abstract Alumno deleteAlumno(Long id);
}
