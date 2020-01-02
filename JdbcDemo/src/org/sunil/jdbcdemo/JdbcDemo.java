package org.sunil.jdbcdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunil.jdbcdemo.dao.JdbcImpl;
import org.sunil.jdbcdemo.dao.SimpleJdbcDaoImpl;
import org.sunil.jdbcdemo.model.Circle;

public class JdbcDemo
{
	public static void main(String []args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//JdbcImpl impl = context.getBean("jdbcImpl",JdbcImpl.class);
		SimpleJdbcDaoImpl impl = context.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		//Circle circle = impl.getCircle(1);
			//System.out.println("Name : " + circle.getName() + "Total Number of records : " + count);
		/*System.out.println("Total Number of records : " + impl.getCircleCount());
		System.out.println("Circle Name is : " + impl.getCircleName(1));
		System.out.println("Circle name other way : " + impl.getCircleForId(1).getName());
		*/
		/*System.out.println("Time to Get all Circles ....");
		for (Circle circle : impl.getAllCircles())
		{
			System.out.println("Id : " + circle.getId());
			System.out.println("Name : " + circle.getName());
		}
		
		impl.insertCircleNamedParameters(new Circle("Third Circle", 4));
		System.out.println("Time to Get all Circles ....");
		for (Circle circle : impl.getAllCircles())
		{
			System.out.println("Id : " + circle.getId());
			System.out.println("Name : " + circle.getName());
		}*/
		System.out.println("Total Number of records : " + impl.getCircleCount());
		
			
	}
}
