package empresaTransporte;

import java.util.ArrayList;

public class Auto extends Transporte {

	
	
public Auto(String conductor, Integer capacidad) {
		
		this.conductor = conductor;
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();
		
	
	}
	
	public Auto(Integer capacidad) {
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();	
		
	}

	
	@Override
	public void ingresarPasajero(Pasajero pasajero) {
		
		if(this.capacidad>=3) {
			pasajeros.add(pasajero);
			this.capacidad--;
		}

	}

}
