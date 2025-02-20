package io.getarrays.server.resource;

import java.time.LocalDateTime;
import java.util.Map;import javax.xml.transform.OutputKeys;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.server.model.Response;
import io.getarrays.server.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
	private final ServerServiceImpl serverService;
	
	@GetMapping("/list")
	public ResponseEntity<Response> getServers() {
		return ResponseEntity.ok(
				Response.builder()
						.timeStamp(LocalDateTime.now())
						.data(Map.of("servers", serverService.list(30)))
						.message("Servers rettieved")
						.status(HttpStatus.OK)
						.statusCode(HttpStatus.OK.value())
						.build()
				)
	}

}
