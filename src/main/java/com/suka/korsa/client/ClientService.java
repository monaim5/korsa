package com.suka.korsa.client;

import com.suka.korsa.common.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements CrudService<Client, ClientDto> {

	private final ClientRepository clientRepository;

	@Override
	public Client create(ClientDto clientDto) {
		return this.clientRepository.save(Client.fromDto(clientDto));
	}

	@Override
	public Client retrieve(String id) {
		return null;
	}

	@Override
	public Client update(String id, ClientDto Dto) {
		return null;
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public List<Client> list() {
		return null;
	}
}
