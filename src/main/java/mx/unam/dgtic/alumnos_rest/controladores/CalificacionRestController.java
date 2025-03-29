package mx.unam.dgtic.alumnos_rest.controladores;

import mx.unam.dgtic.alumnos_rest.models.Calificacion;
import mx.unam.dgtic.alumnos_rest.servicios.v1.interfaces.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cals")
public class CalificacionRestController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/")
    public ResponseEntity<List<Calificacion>> getAll() {
        return ResponseEntity.ok(calificacionService.findAllCalificaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> getCalificacion(@PathVariable Long id) {
        return ResponseEntity.ok(calificacionService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Calificacion> nuevaCalificacion(@RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.saveCalificacion(calificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> updateCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.updateCalificacion(id, calificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calificacion> deleteCalificacion(@PathVariable Long id){
        return ResponseEntity.ok(calificacionService.deleteCalificacion(id));
    }
}