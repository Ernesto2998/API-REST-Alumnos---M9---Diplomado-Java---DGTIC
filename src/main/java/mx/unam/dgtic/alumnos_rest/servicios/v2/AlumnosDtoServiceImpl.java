package mx.unam.dgtic.alumnos_rest.servicios.v2;

import mx.unam.dgtic.alumnos_rest.dtos.AlumnoDto;
import mx.unam.dgtic.alumnos_rest.models.Alumno;
import mx.unam.dgtic.alumnos_rest.repositorios.AlumnoRepository;
import mx.unam.dgtic.alumnos_rest.servicios.v2.interfaces.AlumnoDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnosDtoServiceImpl implements AlumnoDtoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AlumnoDto> findAllAlumnos() {
        return alumnoRepository.findAll().stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDto findById(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("No se encuentra el alumno en getuno DTO")
                );
        return converToDto(alumno);
    }

    @Override
    public AlumnoDto saveAlumno(AlumnoDto alumnoDto) {
        Alumno alumno = convertToEntity(alumnoDto);
        Alumno alumnoSaved = alumnoRepository.save(alumno);
        return converToDto(alumnoSaved);
    }

    @Override
    public AlumnoDto updateAlumno(Long id, AlumnoDto alumnoDto) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("No se encontró el alumno DTO a modificar")
                );
        updateAlumnoFromDto(alumnoDto, alumnoExistente);
        return converToDto(alumnoRepository.save(alumnoExistente));
    }

    @Override
    public AlumnoDto deleteAlumno(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("No existe el alumno con id " + id)
                );
        alumnoRepository.deleteById(id);
        return converToDto(alumno);
    }

    @Override
    public List<AlumnoDto> getPaginaAlumnosDto(int page, int size, String direction, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), sort);

        Page<Alumno> pagina = alumnoRepository.findAll(pageRequest);
        return pagina.getContent().stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    private AlumnoDto converToDto(Alumno alumno){
        return modelMapper.map(alumno, AlumnoDto.class);
    }

    private Alumno convertToEntity(AlumnoDto alumnoDto){
        return modelMapper.map(alumnoDto, Alumno.class);
    }

    private void updateAlumnoFromDto(AlumnoDto alumnoDto, Alumno alumno){
        alumno.setNombre(alumno.getNombre());
        alumno.setApellido(alumno.getApellido());
        alumno.setEmail(alumno.getEmail());
    }
}
