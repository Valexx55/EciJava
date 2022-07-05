package edu.tech.val.courses.jee;

public class Servicio {
	
	private Proceso proceso;
	private String resultado;
	
	public Servicio ()
    {
    }

    public Servicio(Proceso proceso)
    {
        this.proceso = proceso;
    }

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
    

}
