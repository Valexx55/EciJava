package edu.eci.cli;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.eci.repository.entity.Curso;


@FeignClient (name = "mscursosprofe")
public interface CursoFeignClient {
	
	@GetMapping("/curso/obtenercursonativa/{idalumno}")
	public Optional<Curso> obtenerCursoNativa (@PathVariable Long idalumno);

}
