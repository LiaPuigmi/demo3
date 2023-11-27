package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "CUSTOMERS")
@Data
@Slf4j
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;

	@Column(name = "NAME")
	String name;

	@Column(name = "SURNAME")
	String surname;

	@Column(name = "BIRTDATE")
	String birtdate;

	@Column(name = "PHONE")
	String phone;

	@Column(name = "COUNTRY")
	String country;

	@Column(name = "CITY")
	String city;

	@Column(name = "DIRECTION")
	String direction;

	@Column(name = "POSTCODE")
	String postcode;
	
	public static void info(String message) {
		log.info(message);
	}
}
