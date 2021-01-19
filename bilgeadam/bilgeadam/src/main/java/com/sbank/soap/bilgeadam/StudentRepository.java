package com.sbank.soap.bilgeadam;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.bilgeadam.xml.school.Student;

@Component
public class StudentRepository {

	private static final Map<String, Student> students = new HashMap<>();

	@PostConstruct
	public void initData() {

		Student student = new Student();
		student.setName("mustafa");
		student.setStandard(1);
		student.setAddress("uskudar");
		students.put(student.getName(), student);

		student = new Student();
		student.setName("levent");
		student.setStandard(2);
		student.setAddress("kadikoy");
		students.put(student.getName(), student);

		student = new Student();
		student.setName("caglar");
		student.setStandard(3);
		student.setAddress("beykoz");
		students.put(student.getName(), student);

		student = new Student();
		student.setName("hakan");
		student.setStandard(4);
		student.setAddress("goztepe");
		students.put(student.getName(), student);

	}

	public Student findStudent(String name) {
		return students.get(name);
	}

}
