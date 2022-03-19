package com.simplilearn.app;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.simplilearn.app.bean.Employee;

/**
 * Hello world!
 *
 */
public class Company {
	
	public static void main(String[] args) {
		
		// Tightly coupled object
		// create object of employee
		// Employee employee = new Employee();
		// employee.setId(1000001);
		// employee.setName("Prama Munaan");
		// employee.setDept("Engineering");
		// employee.setSalary(4565465.6567);
		
		// System.out.println(employee);
		
		// Spring IOC : Inversion of control => DI  dependency Injection.
		// 1. Application Context container
		ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean-context.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		System.out.println(emp1);
		
		Employee emp2 = context.getBean("emp2", Employee.class);
		System.out.println(emp2);
		
		System.out.println("------------------------");
		
		// 2. Bean Factory Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("employee-bean-context.xml"));
		
		Employee empOne = (Employee) factory.getBean("emp1");
		System.out.println(empOne);
		
		Employee empTwo = factory.getBean("emp2", Employee.class);
		System.out.println(empTwo);
	}
}
