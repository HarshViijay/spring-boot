package com.spring.ormnew;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ormnew.dao.StudentDao;
import com.spring.ormnew.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student(555, "Harsh Vijay", "Lucknow");
        int r = studentDao.insert(student);
        System.out.println("Done" + r);
    }
}
