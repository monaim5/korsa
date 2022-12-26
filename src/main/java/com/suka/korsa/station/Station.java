package com.suka.korsa.station;

import com.suka.korsa.common.AbstractEntity;
import com.suka.korsa.common.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station extends AbstractEntity<StationDto> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_station")
	@GenericGenerator(
			name = "station_seq",
			strategy = "com.suka.korsa.common.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ST-"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			})
	String id;
	String name;
	float x;
	float y;

	@ManyToOne
	@JoinColumn(name = "city_iso")
	private City city;

	@Override
	public StationDto toDto() {
		return new StationDto(name, x, y);
	}

	public static Station fromDto(StationDto dto) {
		return Station.builder()
				.name(dto.name())
				.x(dto.x())
				.y(dto.y())
				.build();
	}
}
