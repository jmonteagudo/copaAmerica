package ar.edu.unlam.pb2;

public class Figurita implements Comparable<Figurita> {

	private String codigo;
	private Integer numero;
	private Character grupo;
	private String seleccion;
	private String nombreJugador;
	private Double valorJugador;

	public Figurita(Integer numero, Character grupo, String seleccion, String nombreJugador, Double valorJugador) {
		this.numero = numero;
		this.grupo = grupo;
		this.seleccion = seleccion;
		this.nombreJugador = nombreJugador;
		this.valorJugador = valorJugador;
		this.codigo = generarCodigo(seleccion, numero);
	}
	
	private String generarCodigo(String seleccion, Integer numero) {
		String codigo = "";
		
		if(numero<10) {
			codigo = seleccion.toUpperCase().substring(0, 3) + ("0" + numero);	
		}
		else {
			codigo = seleccion.toUpperCase().substring(0, 3) + numero;	
		}
		
		return codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figurita [codigo=" + codigo + ", grupo=" + grupo + ", seleccion=" + seleccion + ", nombreJugador="
				+ nombreJugador + ", valorJugador=" + valorJugador + "]";
	}

	public Character getGrupo() {
		return grupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public Double getValorJugador() {
		return valorJugador;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public int compareTo(Figurita o) {
		return this.codigo.compareTo(o.getCodigo());
	}
}
