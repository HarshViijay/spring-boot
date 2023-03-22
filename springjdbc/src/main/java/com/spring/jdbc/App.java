package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.enitites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "starting coding!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        StudentDao studentDao = context.getBean("studentDao" , StudentDao.class);
        
        // Insert
        
        Student student = new Student();
        student.setId(888);
        student.setName("Hitler");
        student.setCity("Germany");
        
        int result = studentDao.insert(student);

        System.out.println("number of record inserted.."+result);
        
        // Update
        
//        Student student = new Student();
//        student.setId(123);
//        student.setName("Ramesh");
//        student.setCity("Magadh");
//        int result = studentDao.change(student);
//        System.out.println("number of record updated.."+result);
        
        // Delete
        
//        int result = studentDao.delete(456);
//        System.out.println("number of record deleted.."+result);
        
        
        // Select one query
        
//        Student student = studentDao.getStudent(333);
//        
//        System.out.println(student);
        
        // Select All queries
        
        
        List<Student> students = studentDao.getAllStudents();
        for(Student s : students) {
        	System.out.println(s);
        }
        
        
        
    }
}
