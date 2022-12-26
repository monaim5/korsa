package com.suka.korsa.station;

import com.suka.korsa.common.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

record StationDto(
		String name,
		float x,
		float y
) {
}

@RestController
@RequestMapping("/api/v1/stations")
@RequiredArgsConstructor
public class StationController {

	private final StationService stationService;

	@GetMapping
	public ResponsePayload<List<StationDto>> getStations(@RequestParam String city) {
		return ResponsePayload.<List<StationDto>>builder()
				.data(this.stationService.retrieveByCity(city)
						.stream().map(Station::toDto).collect(Collectors.toList()))
				.build();
	}

	@GetMapping("/{id}")
	public void getStation(@PathVariable String id) {
		this.stationService.retrieve(id);
	}

	@PostMapping
	public void createStation(@RequestBody StationDto stationsDto) {
		this.stationService.create(stationsDto);
	}

	@PutMapping("/{id}")
	public void updateStation(@PathVariable String id, @RequestBody StationDto stationDto) {
		this.stationService.update(id, stationDto);
	}

	@DeleteMapping("/{id}")
	public void deleteStation(@PathVariable String id) {
		this.stationService.delete(id);
	}
}
