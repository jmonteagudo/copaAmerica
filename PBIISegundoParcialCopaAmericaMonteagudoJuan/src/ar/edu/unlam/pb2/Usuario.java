package ar.edu.unlam.pb2;

public abstract class Usuario {

	private String nombre;
	private String password;

	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public abstract void agregarFigurita(Figurita nueva);
	public abstract void limpiarStock();
}
