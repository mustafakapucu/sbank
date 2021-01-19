package com.sbank.soap.bilgeadam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bilgeadam.xml.school.StudentDetailsRequest;
import com.bilgeadam.xml.school.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint {

	private static final String NAMESPACE_URI = "http://www.bilgeadam.com/xml/school";

	private StudentRepository studentRepository;

	@Autowired
	public StudentEndpoint(StudentRepository repository) {
		this.studentRepository = repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(studentRepository.findStudent(request.getName()));

		return response;
	}

}
