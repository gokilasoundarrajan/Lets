package com.lets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 100)
	private String email;
	
	@Column
	private String name;

}
