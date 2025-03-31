package mx.unam.dgtic.alumnos_rest.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.unam.dgtic.alumnos_rest.models.Alumno;

@Data
public class CalificacionDto {

    private Long id;

    @NotNull(message = "El nombre del curso de proporcionarse")
    @Size(min = 5, max = 50)
    @NotBlank(message = "El nombre del curso no debe quedar en blanco")
    private String curso;

    @NotNull(message = "La nota debe de proporcionarse")
    @DecimalMin(value = "0.0", inclusive = true, message = "La nota no puede ser menor a 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "La nota no puede ser mayor a 10.0")
    private Double nota;

    @NotNull(message = "El Id del alumno debe de proporcionarse")
    private Long alumno;
}
