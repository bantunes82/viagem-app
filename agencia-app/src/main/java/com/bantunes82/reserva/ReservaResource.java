package com.bantunes82.reserva;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reserva")
public class ReservaResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> get(){
		return Reserva.listAll();
	}

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newReserva(Reserva reserva){
		reserva.id = null;
		reserva.persist();

		return Response.status(Response.Status.CREATED).entity(reserva).build();
	}
}
