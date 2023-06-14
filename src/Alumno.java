

public class Alumno {
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String poblacion;
	
	public Alumno(String nombre, String apellido1, String apellido2, String poblacion) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}


	public String getpoblacion() {
		return poblacion;
	}

	
}
