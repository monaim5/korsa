package com.suka.korsa.maps;

import com.suka.korsa.common.ResponsePayload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/maps")
public class MapsController {

	/**
	 * Based on the parameters: city, source, destination; This api should return the directions of the desired path
	 * that the user request in a specific format, so the mobile app can interpret the response and display the path
	 * on the map
	 */
	@GetMapping("/preview/directions")
	public ResponsePayload<?> previewDirections(
			@RequestParam String city,
			@RequestParam String source,
			@RequestParam String destination,
			@RequestParam float sx,
			@RequestParam float sy,
			@RequestParam float dx,
			@RequestParam float dy
	) {
		return null;
	}

	@GetMapping("/preview/stations")
	public ResponsePayload<?> previewCityStations(
			@RequestParam String city,
			@RequestParam float x,
			@RequestParam float y
	) {
		return null;
	}

}
