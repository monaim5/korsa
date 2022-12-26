package com.suka.korsa.station;

import com.suka.korsa.common.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService implements CrudService<Station, StationDto> {
	private final StationRepository stationRepository;

	@Override
	public Station create(StationDto dto) {
		return this.stationRepository.save(Station.fromDto(dto));
	}

	@Override
	public Station retrieve(String id) {
		return this.stationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Station with id: " + id + " not found"));
	}

	@Override
	public Station update(String id, StationDto dto) {
		Station station = this.retrieve(id);
		station.setName(dto.name());
		station.setX(dto.x());
		station.setY(dto.y());
		return station;
	}

	@Override
	public void delete(String id) {
		Station station = this.retrieve(id);
		this.stationRepository.deleteById(id);
	}

	@Override
	public List<Station> list() {
		return null;
	}

	public List<Station> retrieveByCity(String cityIso) {
		return this.stationRepository.findByCityIso(cityIso);
	}
}
