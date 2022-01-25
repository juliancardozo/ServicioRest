package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping(path="/student")
	public Student getStudent() {
		return new Student("Julian","Cardozo");
	}
	
	@GetMapping(path="/students")
	public List<Student> getStudents() {
		
		List<Student> lista = new ArrayList<>();
		
		lista.add(new Student("Julian","Cardozo"));
		lista.add(new Student("Angel","Cardozo"));
		lista.add(new Student("Emiliano","Cardozo"));
		lista.add(new Student("Manuel","Cardozo"));
		lista.add(new Student("Lisandro","Cardozo"));
		
		return lista;
		
		
	}
	
	@GetMapping("/student/{nombre}/{apellido}")
	public Student studentPathVariable(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido) {
		return new Student(nombre, apellido);
	}
	
	@GetMapping("/studentRequestParam")
	public Student StudentRequestParam(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido)	 {
		return new Student(nombre, apellido);
	}

}
