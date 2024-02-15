package empresaTransporte;

import java.util.ArrayList;

public class Motocicleta extends Transporte {

    public Motocicleta(String conductor, Integer capacidad) {
		
		this.conductor = conductor;
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();
		
		
	
	}
    
    public Motocicleta(Integer capacidad) {
		this.capacidad = capacidad;
		this.pasajeros = new ArrayList<Pasajero>();
	}	
	

	@Override
	public void ingresarPasajero(Pasajero pasajero) {
		
		if(this.capacidad>=1) {
			pasajeros.add(pasajero);
			this.capacidad--;
		}
	}
}
