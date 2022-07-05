package edu.val.course.jee.springbasics1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorldService obj = (HelloWorldService) context.getBean("helloWorldService");
		obj.setName("Spring 3.2.3");
		String message = obj.sayHello();
		System.out.println(message);
		}
}
