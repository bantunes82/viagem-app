package com.bantunes82.cliente;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cliente-cli")
public class ClienteResource {

	@Inject
	@RestClient
	ClienteService clienteService;

	@GET
	@Path("newCliente")
	public Response newCliente(){
		Cliente cliente = Cliente.of(99, "Remoto");
		Response response = clienteService.newCliente(cliente);

		return Response.status(Response.Status.CREATED).entity(response).build();
	}
}
