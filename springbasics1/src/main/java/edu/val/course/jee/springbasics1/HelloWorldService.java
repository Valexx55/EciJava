package edu.val.course.jee.springbasics1;

public class HelloWorldService {
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String sayHello() {
		return "Hello from HelloWorld Service! " + name;
	}

}