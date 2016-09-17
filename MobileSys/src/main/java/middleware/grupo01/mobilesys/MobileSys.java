package middleware.grupo01.mobilesys;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileSys 

{
    public static void main( String[] args )
    {
    	System.out.println("*************************");
		System.out.println("****MOBILESYS INICIO****");
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/context.xml", MobileSys.class);
    }
}
