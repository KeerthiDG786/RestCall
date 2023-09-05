package com.mob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	StdentService stdentService;

	@GetMapping(value="/st")
	public ResponseEntity<?> getAllStudent()
	{

		ResponseEntity<String> student=stdentService.getAll();
		StudentDetailsNotFound studentDetailsNotFound=null;
		if(student==null)
		{
			studentDetailsNotFound=new StudentDetailsNotFound("Deatails are Not present",404);
			return new ResponseEntity<>(studentDetailsNotFound,HttpStatus.NOT_FOUND);
		}
		return student;
	}


	@GetMapping(value="/st/{id}") 
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) 
	{ 
		StudentResponse student=stdentService.getById(id);

		if(student!=null)
		{
			return new ResponseEntity<>(student,HttpStatus.OK);	
		}
		return new ResponseEntity<>(new StudentDetailsNotFound("Deatails are Not present",404),HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value="/st/{id}")
	public  ResponseEntity<?> delete(@PathVariable("id") Long id)
	{
		StudentResponse student=stdentService.getById(id);

		if(student!=null)
		{
			try
			{
				stdentService.delete(id);
				return new ResponseEntity<>("data deleted SuccessFully",HttpStatus.OK);	 

			}
			catch(Exception e)
			{
				return new ResponseEntity<> (new StudentDetailsNotFound("error while deleting the data",404),HttpStatus.NOT_FOUND);
			}

		}

		return new ResponseEntity<> (new StudentDetailsNotFound("Deatails are Not present",404),HttpStatus.NOT_FOUND);


	}

	@PostMapping(value="/st")
	public ResponseEntity<?> save(@Valid @RequestBody Student student)
	{
		if(student!=null)
		{
			try
			{
			stdentService.save(student);
			return new ResponseEntity<>("data saved SuccessFully",HttpStatus.OK);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return new ResponseEntity<> (new StudentDetailsNotFound("Deatails are Not present",404),HttpStatus.NOT_FOUND);
			}
		}
		else
		{
			return new ResponseEntity<> (new StudentDetailsNotFound("Deatails are Not present",404),HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping(value="/st/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody StudentResponse student)
	{
		StudentResponse studentDetails=stdentService.getById(id);


		if(student!=null && studentDetails!=null)
		{
			student.setId(id);
			stdentService.update(student);
			return new ResponseEntity<>("data Updated SuccessFully",HttpStatus.OK);	 

		}
		return new ResponseEntity<> (new StudentDetailsNotFound("Deatails are Not present",404),HttpStatus.NOT_FOUND);

	}


}
