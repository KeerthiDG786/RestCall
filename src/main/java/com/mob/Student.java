package com.mob;

public class Student {
  
	

	private String name;
	
	private int age;
	
	private String email;
	/*
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd") private Date created;
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd")
	 * 
	 * private Date updated;
	 * 
	 */	
	
	



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", email=" + email + "]";
	}

	/*
	 * 
	 * public Date getCreated() { return created; }
	 * 
	 * 
	 * public void setCreated(Date created) { this.created = created; }
	 * 
	 * 
	 * public Date getUpdated() { return updated; }
	 * 
	 * 
	 * public void setUpdated(Date updated) { this.updated = updated; }
	 * 
	 */
	


}
