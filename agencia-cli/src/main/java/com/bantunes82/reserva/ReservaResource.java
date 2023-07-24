package com.bantunes82.reserva;

import com.bantunes82.cliente.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/reserva-cli")
public class ReservaResource {

	@Inject
	@RestClient
	ReservaService reservaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("newReserva")
	public String newReserva(){
		Cliente cliente = Cliente.of(2, "");

		return  reservaService.newReserva(cliente);
	}

}
