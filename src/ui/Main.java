package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Course;
import model.Student;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Course course;

	public static void main(String[] args) throws IOException {
		menu();
	}
	
	public static void menu() throws IOException {
		System.out.println("Please type the name of course");
		String name = br.readLine();
		System.out.println("Now type the number of students in the course");
		int numStudents = Integer.parseInt(br.readLine());
		course = new Course(name, numStudents);
		menu2();
	}
	
	public static void menu2() throws NumberFormatException, IOException {
		boolean menu = true;
		while(menu) {
			System.out.print("(1). Add new student\n"
							+ "(2). Delete a student\n"
							+ "(3). Show student list\n"
							+ "(4). Exit\n");
			int option = Integer.parseInt(br.readLine());
			switch(option) {
				case 1:	addStudent();
				break;
				case 2: deleteStudent();
				break;
				case 3:	showStudentList();
				break;
				case 4: System.out.println("\nBye ;)");
						menu = false;
				break;
				default: System.out.println("\nInvalid option\n");
						 menu2();
				break;
			}
		}
	}
	
	public static void addStudent() throws IOException {
		System.out.print("\nType the name:\n");
		String name = br.readLine();
		System.out.print("\nType the code:\n");
		String code = br.readLine();
		Student newStudent = new Student(name, code);
		course.addStudent(newStudent);
	}

	public static void deleteStudent() throws IOException {
		System.out.print("\nType the name of student:\n");
		String name = br.readLine();
		if(course.deleteStudent(name) != -1) {
			System.out.println("\nStudents deleted: "+course.deleteStudent(name)+"\n");
		}else {
			System.out.println("\nStudent not found\n");
		}
		
	}

	public static void showStudentList() {
		System.out.println("------ Student list ------");
		System.out.println(course.showStudent());
	}

}
