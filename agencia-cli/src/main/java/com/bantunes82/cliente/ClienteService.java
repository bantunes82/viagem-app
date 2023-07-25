package com.bantunes82.cliente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {

	@GET
	@Path("findById")
	@Produces(MediaType.APPLICATION_JSON)
	@Timeout(unit = ChronoUnit.SECONDS, value = 3)
	@Fallback(fallbackMethod = "fallback")
	@CircuitBreaker(
			requestVolumeThreshold = 4,
			failureRatio = 0.5,
			delay = 6,
			delayUnit = ChronoUnit.SECONDS,
			successThreshold = 1
	)
	Cliente findById(@QueryParam("id") long id);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	String newCliente(Cliente cliente);

	private Cliente fallback(long id){
		return Cliente.of(0, "");
	}

}
