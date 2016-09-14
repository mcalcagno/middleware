package middleware.grupo01.dispatcher;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dispatcher 
{
	public static void main( String[] args )
    {
    	System.out.println("*************************");
		System.out.println("****DISPATCHER INICIO****");
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/context.xml", Dispatcher.class);
    }
    
}
