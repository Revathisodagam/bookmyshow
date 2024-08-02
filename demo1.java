this is a java file 
{
}


package com.revathi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.revathi.data.Employee;
import com.revathi.repository.IEmpRepository;

@RestController //Spring REST
public class EmployeeController {
       //http://localhost:8080/
	@GetMapping ("/") 
	public String sayHello() {
		return "Hello,Welcome to Spring REST.....";
	}
	@GetMapping ("/login")	public String login (@RequestParam String UID, @RequestParam String PWD) {
		
		System.out.println("Given Date is  : User ID : "+UID + "password : " + PWD);
		
		if(UID.equalsIgnoreCase("Revathi") && PWD.equalsIgnoreCase("admin"))
			return "You are a valid user";
		else 
			return "IInvalid User. Please check Your credentials";
		}
//	@PostMapping ("/insertData")
//	public String insertData(@RequestBody Employee empObj) {
//		System.out.println("Received data is : " +empObj);
//	
//		return "Given record is inserted in the databasesuccessfully.....";
//	}
//	@PutMapping ("/updateData")
//	public String updateData(@RequestBody Employee emp) {
//		System.out.println("Given data to update is : " +emp);
//	
//		return "Given record is updated in the databasesuccessfully.....";
//	}
//	@DeleteMapping ("/deleteData/{id}")
//	public String deleteData(@PathVariable int id) {
//		System.out.println("Given ID to delete is : " +id);
//	
//		return "Given record with Id : " +id + " is deleted successfully.....";
//	}
	@GetMapping ("/v1/hello")
	public String hello() {
		return "This is version 1 of hello..";
	}
	@GetMapping ("/v2/hello")
	public String hellov2() {
		return "This is version 2 of hello..";
	}
	
	
	@Autowired
	IEmpRepository empRepo;
	
	@GetMapping ("/getAllRecords") 
	public List<Employee> getAllRecords() {
		List<Employee> empLst = empRepo.findAll();
		
		return empLst;
	}
	
	@PostMapping ("/insertData")
	public String insertData(@RequestBody Employee empObj) {
		System.out.println("Received data is : "+empObj);
		
		empRepo.save(empObj);
		
		return "Given record is inserted in the database successfully..";
	}
	
	@PutMapping ("/updateData")
	public String updateData(@RequestBody Employee emp) {
		System.out.println("Given data is updated : "+emp);
		
		empRepo.save(emp);
		
		return "Given record is updated in the database successfully..";
}
	@DeleteMapping ("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		System.out.println("Given ID to delete is : " +id);
	
		empRepo.deleteById(id);
		
		return "Given record with Id : " +id + " is deleted successfully.....";
	}
}
