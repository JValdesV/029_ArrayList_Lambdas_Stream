package cl.empresa.principal;

public class Trabajador {

	private Integer id;
	private String nombre;
	private Double sueldo;
	
	public Trabajador(Integer id, String nombre, Double sueldo) {
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	
	
	
	
}
