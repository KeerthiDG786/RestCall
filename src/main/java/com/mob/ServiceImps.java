package com.mob;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImps implements StdentService{

	@Autowired
	RestTemplate restTemplate;
	StudentResponse student=null;
	@Override
	public ResponseEntity<String> getAll() 
	{
		String urlForGetAll = "http://localhost:8080/sts";
		ResponseEntity<String> student=null;
		HttpHeaders headers=new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<>("parameters",headers);

		try {

			student=restTemplate.exchange(urlForGetAll,HttpMethod.GET,entity,String.class); 

		} catch (HttpClientErrorException.NotFound ex) 
		{
			System.out.println("404 Not Found - The requested resource was not found.");
		} 
		catch (Exception ex) {
			System.out.println("An error occurred: " + ex.getMessage());
		}
		return student;
	}

	@Override
	public StudentResponse getById(Long id) {
		String urlForGetById="http://localhost:8080/sts/{id}";
		Map<String,Long> map=new HashMap<>();
		map.put("id", id);

		try
		{
			student=restTemplate.getForObject(urlForGetById, StudentResponse.class,map);
		}
		catch(HttpClientErrorException e)
		{
			throw new DetailsNotFound("Message:detailsNotFound",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			System.out.println("An error occurred due to: " + e.getMessage());
		}

		return student;
	}

	@Override
	public void delete(Long id) {
		System.out.println("from service");
		String urlFordelete="http://localhost:8080/sts/{id}";
		Map<String,Long> map=new HashMap<>();
		map.put("id", id);
		try {
			restTemplate.delete(urlFordelete, map);
		}
		catch(Exception e)
		{
			System.out.println("error for SAve"+e.getMessage());

			throw new DetailsNotFound("data saved successFull",HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public void save(Student student1) {
		String urlForSave="http://localhost:8080/sts";
		StudentResponse studentR= null;
		try
		{
			HttpHeaders headers=new HttpHeaders();
			
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Student> entity= new HttpEntity<>(student1, headers);

			 ResponseEntity<String> re =restTemplate.postForEntity(urlForSave, entity,String.class);
			 
			 System.out.println(re.getStatusCode());

		}
		catch (HttpClientErrorException.NotFound ex) 
		{
			System.out.println("404 Not Found - The requested resource was not found.");
		} 

		catch(Exception e)
		{
			System.out.println("error for SAve"+e.getMessage());

			e.printStackTrace();
			throw new DetailsNotFound("data Not saved",HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public void update(StudentResponse student) 
	{
		String urlForUpdate="http://localhost:8080/sts/{id}";
		Map<String,Long> map=new HashMap<>();
		map.put("id", student.getId());
		try 
		{
			restTemplate.put(urlForUpdate, student, map);
		}
		catch (HttpClientErrorException.NotFound ex) 
		{
			System.out.println("404 Not Found - The requested resource was not found.");
		} 

		catch(Exception e)
		{
			throw new DetailsNotFound("details not present",HttpStatus.BAD_REQUEST);
		}
	}


}
