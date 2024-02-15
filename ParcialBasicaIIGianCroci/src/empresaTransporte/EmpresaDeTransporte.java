package empresaTransporte;

import java.util.HashSet;

public class EmpresaDeTransporte {

	private HashSet<Transporte> vehiculos = new HashSet<Transporte>();
	
	
	public void guardarVehiculo(Transporte vehiculo) {
		
		vehiculos.add(vehiculo);
	
		
	}


	public Transporte getVehiculo(Transporte autobus) {
	
		if(vehiculos.contains(autobus)) {
			return autobus;
		}
		
		else {
			return null;
		}
	}


	public Integer getCantidadDeVehiculos() {
		
		return vehiculos.size();
	}

}
