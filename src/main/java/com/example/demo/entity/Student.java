package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Student {

	@Id
	private Integer studentId;
	private String studentName;
	private Integer studentAge;
	private Double studentMarks;
	private String studentAddr;
	
}
