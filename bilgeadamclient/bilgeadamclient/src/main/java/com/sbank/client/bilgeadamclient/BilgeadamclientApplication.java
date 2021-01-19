package com.sbank.client.bilgeadamclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bilgeadam.springsoap.client.gen.StudentDetailsRequest;
import com.bilgeadam.springsoap.client.gen.StudentDetailsResponse;

@SpringBootApplication
public class BilgeadamclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BilgeadamclientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SoapConnector soapConnector) {
		return args -> {
			String name = "mustafa";// Default Name

			StudentDetailsRequest request = new StudentDetailsRequest();
			request.setName(name);
			
			StudentDetailsResponse response = (StudentDetailsResponse) soapConnector
					.callWebService("http://localhost:8080/ws/student-details", request);

			System.out.println("Result : ");
			System.out.println("Name : " + response.getStudent().getName());
			System.out.println("Standard : " + response.getStudent().getStandard());
			System.out.println("Address : " + response.getStudent().getAddress());
		};
	}

}
