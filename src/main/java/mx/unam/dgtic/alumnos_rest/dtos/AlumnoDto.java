package mx.unam.dgtic.alumnos_rest.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlumnoDto {

    private Long id;

    @NotNull(message = "El nombre debe de proporcionarse")
    @Size(min = 5, max = 30)
    @NotBlank(message = "El nombre no debe quedar en blanco")
    private String nombre;

    @NotNull(message = "El apellido debe de proporcionarse")
    @Size(min = 5, max = 50)
    @NotBlank(message = "El apellido no debe quedar en blanco")
    private String apellido;

    @NotNull(message = "El email debe de proporcionarse")
    @Size(min = 7, max = 100)
    @NotBlank(message = "El email no debe quedar en blanco")
    @Email
    private String email;
}
