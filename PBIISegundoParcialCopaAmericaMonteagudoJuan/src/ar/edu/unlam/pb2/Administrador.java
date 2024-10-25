package ar.edu.unlam.pb2;

import java.util.Set;
import java.util.TreeSet;

public class Administrador extends Usuario {
	
	private Set<Figurita> album;

	public Administrador(String nombre, String password) {
		super(nombre, password);
		album = new TreeSet<Figurita>();
	}

	@Override
	public void agregarFigurita(Figurita nueva) {
		album.add(nueva);
	}
	
	public Set<Figurita> getAlbum() {
		return album;
	}

	@Override
	public void limpiarStock() {
		this.album.clear();
	}
	


}
