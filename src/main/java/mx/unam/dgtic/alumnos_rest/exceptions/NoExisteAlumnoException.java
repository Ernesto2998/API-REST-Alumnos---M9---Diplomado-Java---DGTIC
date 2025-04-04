package mx.unam.dgtic.alumnos_rest.exceptions;

public class NoExisteAlumnoException extends RuntimeException{

    private Long idNoEncontrado;

    public NoExisteAlumnoException(String message) {
        super(message);
    }

    public NoExisteAlumnoException(String message, Long idNoEncontrado) {
        super(message);
        this.idNoEncontrado = idNoEncontrado;
    }

    public Long getIdNoEncontrado() {
        return idNoEncontrado;
    }

    public void setIdNoEncontrado(Long idNoEncontrado) {
        this.idNoEncontrado = idNoEncontrado;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + " ID:" + idNoEncontrado;
    }
}
