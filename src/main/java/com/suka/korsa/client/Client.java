package com.suka.korsa.client;

import com.suka.korsa.common.AbstractEntity;
import com.suka.korsa.common.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

record ClientDto(
		String name
) {}

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractEntity<ClientDto> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
	@GenericGenerator(
			name = "client_seq",
			strategy = "com.suka.korsa.common.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CL-"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			})
	private String id;
	private String name;

	@Override
	public ClientDto toDto() {
		return new ClientDto(name);
	}

	public static Client fromDto(ClientDto dto) {
		return Client.builder()
				.name(dto.name())
				.build();
	}
}
