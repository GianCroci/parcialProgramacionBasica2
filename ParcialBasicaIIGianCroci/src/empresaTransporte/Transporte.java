package empresaTransporte;

import java.util.ArrayList;
import java.util.Objects;


   public abstract class Transporte {
	
	protected String patente;
	protected String conductor;
	protected Integer capacidad;
	protected Double kilometrosRecorridos = 0.0;
	protected ArrayList <Pasajero> pasajeros;
	
	
	
	
	public Integer getCapacidadDisponible() {
		
		return capacidad;
	}



	public void recorrerKilometros(Double kilometros) {
		
	    this.kilometrosRecorridos += kilometros;
		
	}



	public Double getKilometrosRealizados() {
		
		return this.kilometrosRecorridos;
	}



	public abstract void ingresarPasajero(Pasajero pasajero);



	public Integer getCantidadDePasajeros() {
		
		return pasajeros.size();
	}



	public void cambiarConductor(String nuevoConductor) {
		
		if(pasajeros.size()==0) {
			this.conductor = nuevoConductor;
		}
		
	}



	public String getConductor() {
		
		return this.conductor;
	}



	public void descenderPasajero(Pasajero pasajero) {
		
		pasajeros.remove(pasajero);
		this.capacidad++;
		
	}



	public void asignarConductor(String conductor) {
		
		if(this.conductor==null) {
			this.conductor = conductor;
		}
		
	}



	public void setPatente(String patente) {
		
		this.patente = patente;
	}



	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		return Objects.equals(patente, other.patente);
	}



	public String getPatente() {
		
		return this.patente;
	}
	
	
	
	

}
