package middleware.grupo01.mobilesys;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("*************************");
		System.out.println("****DISPATCHER INICIO****");
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/context.xml", App.class);
    }
}
