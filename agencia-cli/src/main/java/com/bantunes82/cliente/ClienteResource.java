package com.bantunes82.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {

	@Inject
	@RestClient
	ClienteService clienteService;

	@GET
	@Path("findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente findById(@QueryParam("id") long id){
		return clienteService.findById(id);
	}

	@GET
	@Path("newCliente")
	public String newCliente(){
		Cliente cliente = Cliente.of(99, "Remoto");

		return clienteService.newCliente(cliente);
	}
}
