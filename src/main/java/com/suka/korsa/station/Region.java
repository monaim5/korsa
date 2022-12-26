package com.suka.korsa.station;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Region {
	@Id
	private String iso;
	private String name;

	@OneToMany(mappedBy = "region")
	private List<City> cities;
}
