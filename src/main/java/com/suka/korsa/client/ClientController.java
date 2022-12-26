package com.suka.korsa.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> list() {
		List<Client> clients = clientService.list();
		return ResponseEntity.ok(clients);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDto create(@RequestBody ClientDto clientDto) {
		return this.clientService.create(clientDto).toDto();
	}

	@GetMapping("/{id}")
	public ClientDto getOne(@PathVariable String id) {
		return this.clientService.retrieve(id).toDto();
	}

	@PutMapping("/{id}")
	public ClientDto update(@PathVariable String id, @RequestBody ClientDto clientDto) {
		return this.clientService.update(id, clientDto).toDto();
	}

	@DeleteMapping("/{id}")
	public void retrieve(@PathVariable String id) {
		clientService.delete(id);
	}
}
