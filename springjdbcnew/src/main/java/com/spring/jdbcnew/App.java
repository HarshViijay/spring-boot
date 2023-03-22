package com.spring.jdbcnew;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbcnew.dao.StudentDao;
import com.spring.jdbcnew.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Lets start coding!!!!!!!!!!!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbcnew/jdbcconfig.xml");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
//        Student student = new Student();
        
        // Insert
        
//        student.setId(333);
//        student.setName("Parvati");
//        student.setCity("Magadh");
//        
//        int result = studentDao.insert(student);
//        System.out.println("Students added "+ result);
        
        // Update
        
//        student.setId(111);
//        student.setName("Harsh Vijay");
//        student.setCity("Kanpur");
//        int result = studentDao.change(student);
//        System.out.println("Number of records updated..."+result);
        
        // Delete
        
//        int result = studentDao.delete(333);
//        System.out.println("Records deleted..."+result);
        

        
        // Select single query
        
//        Student student = studentDao.getStudent(444);
//        System.out.println(student);
        
        // Select all students
        
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students)
        {
        	System.out.println(s);
        }
       
        
        
    }
}
