package mx.unam.dgtic.alumnos_rest.controladores.v2;

import jakarta.validation.Valid;
import mx.unam.dgtic.alumnos_rest.dtos.CalificacionDto;
import mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces.CalificacionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/cals")
public class CalificacionDtoRestController {
    @Autowired
    private CalificacionDtoService calificacionDtoService;

    @GetMapping("/")
    public ResponseEntity<List<CalificacionDto>> getAllCalificacionesDto() {
        return ResponseEntity.ok(calificacionDtoService.findAllCalificaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDto> getCalificacionDto(@PathVariable Long id) {
        return ResponseEntity.ok(calificacionDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CalificacionDto> newCalificacionDto(@Valid @RequestBody CalificacionDto calificacionDto) {
        return ResponseEntity.ok(calificacionDtoService.saveCalificacion(calificacionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalificacionDto> updateCalificacionDto(@Valid @PathVariable Long id, @RequestBody CalificacionDto calificacionDto) {
        return ResponseEntity.ok(calificacionDtoService.updateCalificacion(id, calificacionDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CalificacionDto> deleteCalificacionDto(@PathVariable Long id) {
        return ResponseEntity.ok(calificacionDtoService.deleteCalificacion(id));
    }
}
