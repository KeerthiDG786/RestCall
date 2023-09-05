package com.mob;

import org.springframework.http.ResponseEntity;

public interface StdentService {
	
	ResponseEntity<String> getAll();
	StudentResponse getById(Long id);
	void save(Student student);
	void delete(Long id);
	void update(StudentResponse student);
	
	

}
