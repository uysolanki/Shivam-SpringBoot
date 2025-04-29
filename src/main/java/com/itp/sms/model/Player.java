package com.itp.sms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
