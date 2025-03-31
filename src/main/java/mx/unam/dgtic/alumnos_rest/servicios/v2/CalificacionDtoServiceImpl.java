package mx.unam.dgtic.alumnos_rest.servicios.v2;

import mx.unam.dgtic.alumnos_rest.dtos.CalificacionDto;
import mx.unam.dgtic.alumnos_rest.models.Alumno;
import mx.unam.dgtic.alumnos_rest.models.Calificacion;
import mx.unam.dgtic.alumnos_rest.repositorios.AlumnoRepository;
import mx.unam.dgtic.alumnos_rest.repositorios.CalificacionRepository;
import mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces.CalificacionDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalificacionDtoServiceImpl implements CalificacionDtoService {

    @Autowired
    private CalificacionRepository calificacionRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CalificacionDto> findAllCalificaciones() {
        return calificacionRepository.findAll().stream().map(this::converToDto).collect(Collectors.toList());
    }

    @Override
    public CalificacionDto findById(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("no se encuentre la calificacion en get DTO"));
        return converToDto(calificacion);
    }

    @Override
    public CalificacionDto saveCalificacion(CalificacionDto calificacionDto) {
        Calificacion calificacion = convertToEntity(calificacionDto);
        Calificacion calificacionSaved = calificacionRepository.save(calificacion);
        return converToDto(calificacionSaved);
    }

    @Override
    public CalificacionDto updateCalificacion(Long id, CalificacionDto calificacionDto) {
        Calificacion calificacionExist = calificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontrpo la calificación DTO"));
        updateCalificacionFromDto(calificacionDto, calificacionExist);
        return converToDto(calificacionRepository.save(calificacionExist));
    }

    @Override
    public CalificacionDto deleteCalificacion(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe la calificación con id " + id));
        calificacionRepository.deleteById(id);
        return converToDto(calificacion);
    }

    @Override
    public List<CalificacionDto> getPaginaCalificacionDto(int page, int size, String direction, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), sort);

        Page<Calificacion> pagina = calificacionRepository.findAll(pageRequest);
        return pagina.getContent().stream().map(this::converToDto).collect(Collectors.toList());
    }

    private CalificacionDto converToDto(Calificacion calificacion) {
//        return modelMapper.map(calificacion, CalificacionDto.class);
        CalificacionDto calificacionDto = new CalificacionDto();
        calificacionDto.setId(calificacion.getId());
        calificacionDto.setCurso(calificacion.getCurso());
        calificacionDto.setNota(calificacion.getNota());
        calificacionDto.setAlumno(calificacion.getAlumno().getId());
        return calificacionDto;
    }

    private Calificacion convertToEntity(CalificacionDto calificacionDto) {
//        return modelMapper.map(calificacionDto, Calificacion.class);
        Calificacion calificacion = new Calificacion();
        calificacion.setCurso(calificacionDto.getCurso());
        calificacion.setNota(calificacionDto.getNota());
        calificacion.setAlumno(
                alumnoRepository.findById(calificacionDto.getAlumno())
                        .orElseThrow(
                                ()-> new RuntimeException("Alumno no encontrado con id " + calificacionDto.getId())
                        )
        );
        return calificacion;
    }

    private void updateCalificacionFromDto(CalificacionDto calificacionDto, Calificacion calificacion) {
        calificacion.setCurso(calificacionDto.getCurso());
        calificacion.setNota(calificacionDto.getNota());
    }
}
