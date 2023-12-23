package com.office.laderatechnology.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeModel {
	

		public enum Gender {
			MALE, FEMALE
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(unique = true)
		private String employeeId;

		private String designation;

		private String department;

		//@DateTimeFormat(pattern="dd/MM/yyyy")
		@JsonFormat(pattern="dd-MM-yyyy")
		private Date joining;

		private String workLocation;

		@Column(unique = true)
		@NotBlank
		private String pfAccountNo;

		@Column(unique = true)
		@NotBlank
		private String uanNumber;

		@Column(unique = true)
		@NotBlank
		private String panNumber;

		private String fatherName;

		@NotBlank(message = "FirstName should not be empty")
		@Size(min = 3, message = "Name should be minimum 3 characters")
		private String firstName;

		@NotBlank(message = "LastName should not be empty")
		private String lastName;

		@Column(unique = true)
		@NotBlank
		private String email;

		private String address;

		//@DateTimeFormat(pattern="dd/MM/yyyy")
		@JsonFormat(pattern="dd-MM-yyyy")
		private Date dateOfBirth;

		//@Size(min = 2, message = "Age should be minimum 2 characters")
		@Min(value = 2, message = "Age must be at least 2 characters")
		private int age;

		@Column(unique = true)
		@Size(min = 10, message = "Mobile Number should have 10 numbers")
		@NotNull
		private String mobileNumber;

		private long annualSalary;

		private long monthlySalary;

		private int leaveBalance;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "gender")
		private Gender gender;
}
