package mx.unam.dgtic.alumnos_rest.dtos;

import lombok.Data;

@Data
public class AlumnoDto {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;
}
