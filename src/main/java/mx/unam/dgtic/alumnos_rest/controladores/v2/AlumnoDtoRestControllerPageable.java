package mx.unam.dgtic.alumnos_rest.controladores.v2;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces.AlumnoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/paginable/alumnos")
public class AlumnoDtoRestControllerPageable {
    @Autowired
    private AlumnoDtoService alumnoDtoService;

    @GetMapping("")
    public ResponseEntity<List<AlumnoDto>> getPagina(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return ResponseEntity.ok(
                alumnoDtoService.getPaginaAlumnosDto(page, size, direction, sort)
        );
    }
}
