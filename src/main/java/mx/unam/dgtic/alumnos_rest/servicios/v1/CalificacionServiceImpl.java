package mx.unam.dgtic.alumnos_rest.servicios.v1;

import mx.unam.dgtic.alumnos_rest.models.Calificacion;
import mx.unam.dgtic.alumnos_rest.repositorios.CalificacionRepository;
import mx.unam.dgtic.alumnos_rest.servicios.v1.interfaces.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public List<Calificacion> findAllCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion findById(Long id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la calificación " + id));
    }

    @Override
    public Calificacion saveCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion updateCalificacion(Long id, Calificacion calificacion) {
        return calificacionRepository.findById(id)
                .map(
                        calActual -> {
                            calActual.setCurso(calificacion.getCurso());
                            calActual.setNota(calificacion.getNota());
                            return calificacionRepository.save(calActual);
                        }
                ).orElseThrow(
                        () -> new RuntimeException("No existe la calificación")
                );
    }

    @Override
    public Calificacion deleteCalificacion(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No existe la calificación a eliminar")
                );
        calificacionRepository.deleteById(id);

        return calificacion;
    }
}
