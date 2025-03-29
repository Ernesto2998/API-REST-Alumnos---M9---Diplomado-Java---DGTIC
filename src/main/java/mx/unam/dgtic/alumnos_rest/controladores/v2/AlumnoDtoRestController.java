package mx.unam.dgtic.alumnos_rest.controladores.v2;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces.AlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/alumnos")
public class AlumnoDtoRestController {
    @Autowired
    private AlumnoDtoService alumnoDtoService;

    @GetMapping("/")
    public ResponseEntity<List<AlumnoDto>> getAllAlumnosDto(){
        return ResponseEntity.ok(alumnoDtoService.findAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> getAlumnoDto(@PathVariable Long id){
        return ResponseEntity.ok(alumnoDtoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<AlumnoDto> newAlumnoDto(@RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.ok(alumnoDtoService.saveAlumno(alumnoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDto> updateAlumnoDto(@PathVariable Long id, @RequestBody AlumnoDto alumnoDto){
        return ResponseEntity.ok(alumnoDtoService.updateAlumno(id, alumnoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDto> deleteAlumnoDto(@PathVariable Long id){
        return ResponseEntity.ok(alumnoDtoService.deleteAlumno(id));
    }
}
