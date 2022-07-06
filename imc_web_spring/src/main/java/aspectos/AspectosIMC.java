package aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import dto.ImcResultado;
import dto.Persona;

@Aspect
public class AspectosIMC {
	
	
	@Pointcut("execution(* controller.IMCController.imc(..))")  
    public void controllerIMC(){
		
	}
	

    @Before("controllerIMC()")  
    public void antesDeImc (JoinPoint jp)
    {  
        System.out.println("Recibida petición de cálculo");
        Persona p = (Persona) jp.getArgs()[0];
        System.out.println(p);
    }
    
    
    @Pointcut("execution(* service.interfaces.IMCService.calcula(..))")  
    public void servicioIMC(){
		
		
	}
    
    
    @Around("execution( * service.interfaces.IMCService.obtenerListaIMCs())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Antes de invocar a listarimc method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Después de invocar al meodo, devolvemos ="+value);
		return value;
	}
	
    @AfterReturning(pointcut="servicioIMC()", returning="resultado")
    public void postServicioIMC(Object resultado) 
    {
    	System.out.println("IMC calculado");
    	ImcResultado imc_res = (ImcResultado) resultado;
    	System.out.println(imc_res);
           
    }
    
    @Before("@annotation(aspectos.Chequeable)")
	public void myAdvice(){
		System.out.println("Ey...q se va a ejecutar algo chekeable :)!!");
	}


}
