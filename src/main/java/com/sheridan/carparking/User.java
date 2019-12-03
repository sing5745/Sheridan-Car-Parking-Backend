package com.sheridan.carparking;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class User {

	@Id
	private int id;
	
	private String userName;
	private String password;
	
	
}
