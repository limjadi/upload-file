package com.lim.spring3_client.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
@Entity
@Table(name = "m_user")
public class User implements Serializable {

	private static final long serialVersionUID = -7805622905888009231L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "country", length = 50)
	private String country;

	@Column(name = "age")
	private int age;

	User() {

	}

	public User(String name, String email, String country, int age) {
		this.name = name;
		this.email = email;
		this.country = country;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, name='%s']", id, name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
