package com.my.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarDTO {
	private String number;
	private String model;
	private int engine;
	
	public CarDTO(String number, String model, int engine) {
		this.number = number;
		this.model = model;
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "CarDTO [number=" + number + ", model=" + model + ", engine=" + engine + "]";
	}
	
}
