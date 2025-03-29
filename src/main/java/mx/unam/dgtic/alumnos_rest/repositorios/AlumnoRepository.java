package mx.unam.dgtic.alumnos_rest.repositorios;

import mx.unam.dgtic.alumnos_rest.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
