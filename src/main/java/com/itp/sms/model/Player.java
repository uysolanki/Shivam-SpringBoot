package com.itp.sms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jno;
	private String pname;
	private int mp;
	private int rs;
}
