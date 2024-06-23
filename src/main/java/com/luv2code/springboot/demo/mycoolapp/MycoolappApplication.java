package com.luv2code.springboot.demo.mycoolapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) throws JsonProcessingException {

		// SpringApplication.run(MycoolappApplication.class, args);

		// Create ObjectMapper object.
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		Employee employeeWithFirstNameAndLastName = new Employee(10, "Hello", "World");
		Employee employeeWithFirstNameNull = new Employee(10, null, "World");
		Employee employeeWithLatNameEmpty = new Employee(10, "Hello", "");

		System.out.println("Demo jsonInclude : employeeWithFirstNameAndLastName : " + mapper.writeValueAsString(employeeWithFirstNameAndLastName));
		System.out.println("Demo jsonInclude : employeeWithFirstNameNull : " + mapper.writeValueAsString(employeeWithFirstNameNull));
		System.out.println("Demo jsonInclude : employeeWithFirstNameAndLastName : " + mapper.writeValueAsString(employeeWithLatNameEmpty));
		employeeWithFirstNameAndLastName.setFirstName(null);
		System.out.println("employeeWithFirstNameAndLastName.setFirstName(null) : " + mapper.writeValueAsString(employeeWithFirstNameAndLastName));

	}

}
