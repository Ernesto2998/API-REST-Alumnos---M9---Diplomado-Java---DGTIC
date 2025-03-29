package mx.unam.dgtic.alumnos_rest.repositorios;

import mx.unam.dgtic.alumnos_rest.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
}
