package com.suka.korsa.station;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City {
	@Id
	private String iso;
	private String name;

	@ManyToOne
	@JoinColumn(name = "region_iso")
	private Region region;
}
