package com.suka.korsa.station;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends CrudRepository<Station, String> {

	@Query("select s from Station s where s.city.iso = :cityIso")
	List<Station> findByCityIso(String cityIso);
}
