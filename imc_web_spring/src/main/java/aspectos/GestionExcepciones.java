package aspectos;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = { "controller." })
public class GestionExcepciones 
{
	@ExceptionHandler(Throwable.class)
	public String errores(Exception e) {
		e.printStackTrace();
		return "error";
	}
}