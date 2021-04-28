package com.yogesh.springORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yogesh.springORM.dao.StudentDao;
import com.yogesh.springORM.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
      ApplicationContext context =  new ClassPathXmlApplicationContext("config.xml");
      StudentDao dao = context.getBean("studentDao",StudentDao.class);
      Student stu = new Student(12,"yogeshTiwari", "pith");
      
      dao.insert(stu);
      //System.out.println("insert operation done on "+result +" row");
      System.out.println("done....");
    }
}
