package com.bantunes82.reserva;

import com.bantunes82.cliente.Cliente;
import com.bantunes82.cliente.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/reserva-cli")
public class ReservaResource {

	@Inject
	@RestClient
	ReservaService reservaService;

	@Inject
	@RestClient
	ClienteService clienteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("newReserva")
	public String newReserva(){
		Cliente cliente = clienteService.findById(2);
		Reserva reserva = Reserva.of(cliente);

		return  reservaService.newReserva(reserva);
	}

}
