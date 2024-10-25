package ar.edu.unlam.pb2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Final extends Usuario {

	private List<Figurita> stock;
	private Set<Figurita> album;

	public Final(String nombre, String password) {
		super(nombre, password);
		stock = new LinkedList<Figurita>();
		album = new TreeSet<Figurita>();
	}

	@Override
	public void agregarFigurita(Figurita nueva) {
		stock.add(nueva);
	}

	public List<Figurita> getStock() {
		return stock;
	}
	
	@Override
	public void limpiarStock() {
		this.stock.clear();
	}

	public void pegarFigurita(Figurita aPegar) throws FiguritaNoDisponible, FiguritaRepetida {
		if(!this.stock.contains(aPegar)) {
			throw new FiguritaNoDisponible();
		}
		
		if(!album.add(aPegar)) {
			throw new FiguritaRepetida();
		}
		
		Iterator<Figurita> i = stock.iterator();
		Boolean encontrado = false;
		
		while(i.hasNext() && !encontrado) {
			Figurita actual = i.next();
			if(actual.equals(aPegar)) {
				i.remove();
				encontrado = true;
			}
		}
	}

	public Set<Figurita> getAlbum() {
		return album;
	}
}
