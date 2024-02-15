package empresaTransporte;

import java.util.ArrayList;


public class Autobus extends Transporte {

	public Autobus(String conductor, Integer capacidad) {
		
		this.conductor = conductor;
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();
		
	
	}

	public Autobus(Integer capacidad) {
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();
	}

	@Override
	public void ingresarPasajero(Pasajero pasajero) {
		
		if(this.capacidad<=20) {
			pasajeros.add(pasajero);
			this.capacidad--;
		}
		
	}
	
	

}
