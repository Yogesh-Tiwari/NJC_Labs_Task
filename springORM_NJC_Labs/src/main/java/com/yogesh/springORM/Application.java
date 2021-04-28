package com.yogesh.springORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yogesh.springORM.dao.StudentDao;
import com.yogesh.springORM.entities.Student;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		
		while(go) {
			System.out.println("**************Welcome to Student Details Manipulation Project****************");
			System.out.println("Press 1 for add new student");
			System.out.println("press 2 for display all students");
			System.out.println("press 3 for display details of single student");
			System.out.println("press 4 for delete student");
			System.out.println("press 5 for exit");
			
			try {
				
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				
				case 1:
					//add new student
					System.out.println("Enter id: ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Student Name: ");
					String name = br.readLine();
					System.out.println("Enter city: ");
					String city = br.readLine();
					dao.insert(new Student(id,name,city));
					System.out.println("Student inserted..");
					break;
					
				case 2:
					//Display all students
					List<Student> allStudents = dao.getAllStudents();
					for(Student s : allStudents) {
						System.out.println(s);
					}
					break;
					
				case 3:
					//Display single student details
					System.out.println("Student id to show: ");
					int showId = Integer.parseInt(br.readLine());
					Student student = dao.getStudent(showId);
					System.out.println(student);
					break;
					
				case 4: 
					//Delete Student
					System.out.println("Student id to delete: ");
					int delId = Integer.parseInt(br.readLine());
					dao.deleteStudent(delId);
					System.out.println("deleted");
					break;
	
					
				case 5:
					//exit
					go = false;
					break;

				
				
			}  }
				catch (Exception e) {
				System.out.println("Wrong input, please give valid one!!");
				
			}
			
			
			
		}
	
}

}
	