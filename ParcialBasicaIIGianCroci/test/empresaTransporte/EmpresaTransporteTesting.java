package empresaTransporte;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EmpresaTransporteTesting {

	@Test
	public void queSeCreeUnaEmpresaDeTransporte() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Assert.assertNotNull(empresa);
	}
	
	@Test
	public void queLosVEhiculosTenganPatente() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		autobus.setPatente("AA 302 FG");
		String patenteEsperada = "AA 302 FG";
		String patenteObtenida = autobus.getPatente();
		Assert.assertEquals(patenteEsperada, patenteObtenida);
	}
	
	@Test
	public void queSeGuardeLaInformacionDeLosVehiculosEnLaEmpresa() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		empresa.guardarVehiculo(autobus);
		Transporte vehiculoEsperado = autobus;
		Transporte vehiculoObtenido = empresa.getVehiculo(autobus);
		Assert.assertEquals(vehiculoEsperado, vehiculoObtenido);
	}
	
	@Test
	public void queNoSePuedaGuardarDosVecesElMismoVehiuclo() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		empresa.guardarVehiculo(autobus);
		Transporte autobusDos = new Autobus("Fenando", 20);
		empresa.guardarVehiculo(autobusDos);
		Integer cantidadDeVehiculosEsperada = 1;
		Integer cantidadDeVehiculosObtenida = empresa.getCantidadDeVehiculos();
		Assert.assertEquals(cantidadDeVehiculosEsperada, cantidadDeVehiculosObtenida);
		
	}
	
	@Test
	public void queSeCreeUnAutobusConChoferYCapacidadDeVeintePasajeros() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		Integer espaciosDisponiblesEsperados = 20;
		Integer espaciosDisponibles = autobus.getCapacidadDisponible();
		Assert.assertEquals(espaciosDisponiblesEsperados, espaciosDisponibles);
			
	}
	
	@Test
	public void queSeCreeUnaMotoConChoferYcapacidadDeUnAcompañante() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte moto = new Motocicleta("Fenando", 1);
		Integer espaciosDisponiblesEsperados = 1;
		Integer espaciosDisponibles = moto.getCapacidadDisponible();
		Assert.assertEquals(espaciosDisponiblesEsperados, espaciosDisponibles);
	}
	
	@Test
	public void queSeCreeUnAutoSinChoferYCapacidadDeTresAcompañantes() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte auto = new Auto(3);
		Integer espaciosDisponiblesEsperados = 3;
		Integer espaciosDisponibles = auto.getCapacidadDisponible();
		Assert.assertEquals(espaciosDisponiblesEsperados, espaciosDisponibles);
	}
	
	@Test
	public void queSeLePuedaAsignarUnConductorAlAuto() {
		Transporte auto = new Auto(3);
		auto.asignarConductor("Fernando");
		String conductorEsperado = "Fernando";
		String conductorObtenido = auto.getConductor();
		Assert.assertEquals(conductorEsperado, conductorObtenido);
	}
	
	@Test
	public void queElVehiculoRecorraKilometros() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte moto = new Motocicleta("Fenando", 1);
		Double kilometrosEsperados = 45.0;
		moto.recorrerKilometros(45.0);
		Double kilometrosObtenidos = moto.getKilometrosRealizados();
		Assert.assertEquals(kilometrosEsperados, kilometrosObtenidos, 0.01);
	}
	
	@Test
	public void queIngresenPasajeros() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);
		Integer cantidadDePasajerosEsperada = 2;
		Integer cantidadDePasajerosObtenida = autobus.getCantidadDePasajeros();
		Assert.assertEquals(cantidadDePasajerosEsperada, cantidadDePasajerosObtenida);
		
	}
	
	
	@Test
	public void queBajenPasajeros() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fenando", 20);
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);
		autobus.descenderPasajero(pasajero);
		autobus.descenderPasajero(pasajeroDos);
		Integer cantidadDePasajerosEsperada = 0;
		Integer cantidadDePasajerosObtenida = autobus.getCantidadDePasajeros();
		Assert.assertEquals(cantidadDePasajerosEsperada, cantidadDePasajerosObtenida);
	}
	
	@Test
	public void queNoSePuedaSuperarLaCapacidadMaximaDePasajeros() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte moto = new Motocicleta("Fenando", 1);
		Pasajero pasajero = new Pasajero("Joaquin");
		moto.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		moto.ingresarPasajero(pasajeroDos);
		moto.cambiarConductor("Marcelo");
		Integer cantidadDePasajerosEsperada = 1;
		Integer cantidadDePasajerosObtenida = moto.getCantidadDePasajeros();
		Assert.assertEquals(cantidadDePasajerosEsperada, cantidadDePasajerosObtenida);
	}
	
	@Test
	public void queSiHayPasajerosNoSePuedaCambiarElConductor() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fernando", 20);
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);
		autobus.cambiarConductor("Marcelo");
		String conductorEsperado = "Fernando";
		String conductorObtenido = autobus.getConductor();
		Assert.assertEquals(conductorEsperado, conductorObtenido);
		
	}
	
	@Test
	public void queSiNoHayPasajerosSePuedaCambiarElConductor() {
		EmpresaDeTransporte empresa = new EmpresaDeTransporte();
		Transporte autobus = new Autobus("Fernando", 20);
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);
		autobus.descenderPasajero(pasajero);
		autobus.descenderPasajero(pasajeroDos);
		autobus.cambiarConductor("Marcelo");
		String conductorEsperado = "Marcelo";
		String conductorObtenido = autobus.getConductor();
		Assert.assertEquals(conductorEsperado, conductorObtenido);
	}
	

	private void queTenga3PasajerosElconductorSeaJulianYHayaRecorrido100kms(Transporte autobus) {
		Integer pasajerosEsperados = 3;
		Integer pasajerosObtenidos = autobus.getCantidadDePasajeros();
		Assert.assertEquals(pasajerosEsperados, pasajerosObtenidos);
		
		String conductorEsperado = "Julian";
		String conductorObtenido = autobus.getConductor();
		Assert.assertEquals(conductorEsperado, conductorObtenido);
		
		Double kilometrosEsperados = 100.0;
		Double kilometrosObtenidos = autobus.getKilometrosRealizados();
		Assert.assertEquals(kilometrosEsperados, kilometrosObtenidos, 0.01);
		
	}

	private void dadoQueSuben3Pasajeros(Transporte autobus) {
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);	
		Pasajero pasajeroTres = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajeroTres);		
	}

	private void dadoQueCambiaElConductor(Transporte autobus) {
        autobus.cambiarConductor("Julian");		
	}

	private void dadoQueBajanLosPasajeros(Transporte autobus) {

		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.descenderPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.descenderPasajero(pasajeroDos);	
		Pasajero pasajeroTres = new Pasajero("Joaquin");
		autobus.descenderPasajero(pasajeroTres);
		Pasajero pasajeroCuatro = new Pasajero("Rocio");
		autobus.descenderPasajero(pasajeroCuatro);
	}

	private void dadoQueSeRecorrenKilometros(Transporte autobus, Double kilometros) {

		autobus.recorrerKilometros(kilometros);
	}

	private void dadoQueSuben4Pasajeros(Transporte autobus) {
		Pasajero pasajero = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajero);
		Pasajero pasajeroDos = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroDos);	
		Pasajero pasajeroTres = new Pasajero("Joaquin");
		autobus.ingresarPasajero(pasajeroTres);
		Pasajero pasajeroCuatro = new Pasajero("Rocio");
		autobus.ingresarPasajero(pasajeroCuatro);	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
