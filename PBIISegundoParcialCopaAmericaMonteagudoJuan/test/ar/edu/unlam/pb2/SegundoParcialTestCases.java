package ar.edu.unlam.pb2;

import static org.junit.Assert.*;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SegundoParcialTestCases {
	
	private Figurita messi;
	private Figurita diMaria;
	private Figurita elToro;
	private Usuario admin;
	private Usuario jugador;
	
	@Before
	public void init() {
		// Preparaci�n
		// Figurita 1
		Integer numero = 10;
		Character grupo = 'A';
		String seleccion = "Argentina";
		String nombreFutbolista = "Lionel Messi";
		Double valorFutbolista = 200000000.0;
		// Figurita 2
		Integer numero2 = 11;
		String nombreFutbolista2 = "Angel DiMaria";
		Double valorFutbolista2 = 200000000.0;
		// Figurita 3
		Integer numero3 = 22;
		String nombreFutbolista3 = "Lautaro Martinez";
		Double valorFutbolista3 = 200000000.0;

		// Administrador
		String nombreAdministrador = "nombreAdmin";
		String passwordAdministrador = "passAdmin";
		// Usuario final
		String nombreJugador = "nombreJugador";
		String passwordJugador = "passJugador";
		
		// Ejecuci�n		
		this.messi = new Figurita(numero, grupo, seleccion, nombreFutbolista, valorFutbolista);
		this.diMaria = new Figurita(numero2, grupo, seleccion, nombreFutbolista2, valorFutbolista2);
		this.elToro = new Figurita(numero3, grupo, seleccion, nombreFutbolista3, valorFutbolista3);		
		this.admin = new Administrador(nombreAdministrador, passwordAdministrador);
		this.jugador = new Final(nombreJugador, passwordJugador);
	}

	@Test
	public void queSePuedaCrearUnaFigurita() {
		
		// Preparaci�n
		Integer numero = 10;
		Character grupo = 'A';
		String seleccion = "Argentina";
		String nombreJugador = "Lionel Messi";
		Double valorJugador = 200000000.0;
		String codigoEsperado = "ARG10";
		Figurita nueva;
		
		// Ejecuci�n
		nueva = new Figurita(numero, grupo, seleccion, nombreJugador, valorJugador);
		
		// Validaci�n
		assertEquals(numero, nueva.getNumero());
		assertEquals(grupo, nueva.getGrupo());
		assertEquals(seleccion, nueva.getSeleccion());
		assertEquals(nombreJugador, nueva.getNombreJugador());
		assertEquals(valorJugador, nueva.getValorJugador(), 0.01);
		assertEquals(codigoEsperado, nueva.getCodigo());
	}

	@Test
	public void queSePuedaCrearUnAdministrador() {
		
		// Preparaci�n
		String nombre = "juan";
		String password = "unlam";
		Usuario nuevo;
		
		// Ejecuci�n
		nuevo = new Administrador(nombre, password);
				
		// Validaci�n
		assertEquals(nombre, nuevo.getNombre());
		assertEquals(password, nuevo.getPassword());
		
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		
		// Preparaci�n
		String nombre = "juan";
		String password = "unlam";
		Usuario nuevo;
		
		// Ejecuci�n
		nuevo = new Final(nombre, password);
				
		// Validaci�n
		assertEquals(nombre, nuevo.getNombre());
		assertEquals(password, nuevo.getPassword());
		
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 1;
		admin.limpiarStock();
		
		// Ejecuci�n
		admin.agregarFigurita(messi);
				
		// Validaci�n
		assertNotNull(((Administrador)admin).getAlbum());
		assertEquals((int)CANTIDAD_DE_FIGURITAS_ESPERADAS, ((Administrador)admin).getAlbum().size());
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 1;
		jugador.limpiarStock();
		
		// Ejecuci�n
		jugador.agregarFigurita(messi);
				
		// Validaci�n
		assertNotNull(((Final)jugador).getStock());
		assertEquals((int)CANTIDAD_DE_FIGURITAS_ESPERADAS, ((Final)jugador).getStock().size());
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 1;
		admin.limpiarStock();
		
		// Ejecuci�n
		admin.agregarFigurita(diMaria);
		admin.agregarFigurita(elToro);
		admin.agregarFigurita(messi);
				
		// Validaci�n
		Set<Figurita> albumOrdenado = ((Administrador)admin).getAlbum();
		Integer indice = 0;
		for(Figurita actual: albumOrdenado) {
			switch(indice) {
			case 0:
				assertEquals(messi, actual);
				break;
			case 1:
				assertEquals(diMaria, actual);
				break;
			case 2: 
				assertEquals(elToro, actual);
				break;
			}
			indice++;
		}
	}
	
	@Test
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 3;
		admin.limpiarStock();
		
		
		// Ejecuci�n
		Figurita duplicada = new Figurita(11,'D', "Argentina", "Fideo", 1000.0);
		
		admin.agregarFigurita(diMaria);
		admin.agregarFigurita(elToro);
		admin.agregarFigurita(messi);
		admin.agregarFigurita(duplicada);
				
		// Validaci�n
		assertEquals((int)CANTIDAD_DE_FIGURITAS_ESPERADAS, ((Administrador)admin).getAlbum().size());
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 4;
		jugador.limpiarStock();
		
		
		// Ejecuci�n
		Figurita duplicada = new Figurita(11,'D', "Argentina", "Fideo", 1000.0);
		
		jugador.agregarFigurita(diMaria);
		jugador.agregarFigurita(elToro);
		jugador.agregarFigurita(messi);
		jugador.agregarFigurita(duplicada);
				
		// Validaci�n
		assertEquals((int)CANTIDAD_DE_FIGURITAS_ESPERADAS, ((Final)jugador).getStock().size());
	}	

	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaNoDisponible, FiguritaRepetida {
		
		// Preparaci�n
		final Integer CANTIDAD_DE_FIGURITAS_ESPERADAS = 1;
		jugador.limpiarStock();
		
		
		// Ejecuci�n
		Figurita duplicada = new Figurita(11,'D', "Argentina", "Fideo", 1000.0);
		
		jugador.agregarFigurita(diMaria);
		jugador.agregarFigurita(elToro);
		jugador.agregarFigurita(messi);
		jugador.agregarFigurita(duplicada);
		
		((Final)jugador).pegarFigurita(messi);
				
		// Validaci�n
		assertEquals((int)CANTIDAD_DE_FIGURITAS_ESPERADAS, ((Final)jugador).getAlbum().size());
	}
	
	@Test (expected = FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaNoDisponible, FiguritaRepetida {
		
		// Preparaci�n
		jugador.limpiarStock();
		
		
		// Ejecuci�n
		Figurita duplicada = new Figurita(11,'D', "Argentina", "Fideo", 1000.0);
		
		jugador.agregarFigurita(diMaria);
		jugador.agregarFigurita(elToro);
		jugador.agregarFigurita(messi);
		jugador.agregarFigurita(duplicada);
		
		((Final)jugador).pegarFigurita(diMaria);
		((Final)jugador).pegarFigurita(elToro);
		((Final)jugador).pegarFigurita(messi);
		((Final)jugador).pegarFigurita(duplicada);
				
		// Validaci�n
		// Se espera una salida por excepci�n.
	}
}

