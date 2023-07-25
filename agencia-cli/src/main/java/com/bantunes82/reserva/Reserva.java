package com.bantunes82.reserva;

import com.bantunes82.cliente.Cliente;

public class Reserva {

	private long id;

	private Cliente cliente;
	public Reserva() {
	}

	private Reserva(long id, Cliente cliente) {
		this.id = id;
		this.cliente = cliente;
	}


	public static Reserva of(long id, Cliente cliente){
		return new Reserva(id, cliente);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
