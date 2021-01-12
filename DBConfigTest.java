package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DBConfigTest {
	
	public void main(String []args) {
	
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	context.close();
	}
}