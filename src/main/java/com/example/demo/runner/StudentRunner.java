package com.example.demo.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;

@Component
public class StudentRunner implements ApplicationRunner {

	@Autowired
	private StudentController controller;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Scanner sc = new Scanner(System.in);

		Student s = new Student();

		List<Integer> list = new ArrayList<>();

		int id = 0;
		String name = "";
		int age = 0;
		double marks = 0.0;
		String addr = "";

		int choice = 0;
		int j = 1;
		while (j == 1) {
			
			System.out.println("1. INSERT");
			System.out.println("2. SELECT");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");

			System.out.println("Enter Your Choice :: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("1. Single Data Insert");
				System.out.println("2. Multiple Data Insert");

				System.out.println("Enter Your Choice :: ");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter Student ID :: ");
					id = sc.nextInt();

					sc.nextLine();
					System.out.println("Enter Student Name :: ");
					name = sc.nextLine();
					System.out.println("Enter Student Age :: ");
					age = sc.nextInt();
					System.out.println("Enter Student Marks :: ");
					marks = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter Student Address :: ");
					addr = sc.nextLine();

					s.setStudentId(id);
					s.setStudentName(name);
					s.setStudentAge(age);
					s.setStudentMarks(marks);
					s.setStudentAddr(addr);

					try {
						Student singleInsert = controller.singleInsert(s);
						System.out.println(singleInsert);
					} catch (Exception e) {
						e.printStackTrace();
					}

					break;
				case 2:
					System.out.println("How many Student record you want to INSERT :: ");
					int noOfRecord = sc.nextInt();

					for (int i = 1; i <= noOfRecord; i++) {
						System.out.println("Enter Student ID :: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Student Name :: ");
						name = sc.nextLine();
						System.out.println("Enter Student Age :: ");
						age = sc.nextInt();
						System.out.println("Enter Student Marks :: ");
						marks = sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter Student Address :: ");
						addr = sc.nextLine();

						s.setStudentId(id);
						s.setStudentName(name);
						s.setStudentAge(age);
						s.setStudentMarks(marks);
						s.setStudentAddr(addr);

						List<Student> list1 = new ArrayList<>();
						list1.add(s);
						try {
							List<Student> multipleInsert = controller.multipleInsert(list1);
							System.out.println(multipleInsert);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
				break;
			case 2:
				System.out.println("1. SELECT BY ID");
				System.out.println("2. SELECT ALL");
				System.out.println("3. SELECT ALL BY ID");
				System.out.println("4. STUDENT EXIST OR NOT");

				System.out.println("Enter Your Choice :: ");
				choice = sc.nextInt();

				switch (choice) {

				case 1:
					System.out.println("Enter Student ID :: ");
					id = sc.nextInt();

					try {
						Optional<Student> selectById = controller.selectById(id);
						if (selectById.isPresent()) {
							s = selectById.get();
							System.out.println("Student ID      :: " + s.getStudentId());
							System.out.println("Student Name    :: " + s.getStudentName());
							System.out.println("Student Age     :: " + s.getStudentAge());
							System.out.println("Student Marks   :: " + s.getStudentMarks());
							System.out.println("Student Address :: " + s.getStudentAddr());
						} else {
							System.out.println("ID not found");
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 2:

					try {
						List<Student> selectAll = controller.selectAll();
						for (Student s1 : selectAll) {
							System.out.println("Student ID      :: " + s1.getStudentId());
							System.out.println("Student Name    :: " + s1.getStudentName());
							System.out.println("Student Age     :: " + s1.getStudentAge());
							System.out.println("Student Marks   :: " + s1.getStudentMarks());
							System.out.println("Student Address :: " + s1.getStudentAddr());
							System.out.println("============================================");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter How many Student Details you want to Read :: ");
					int noOfStudentId = sc.nextInt();

					for (int i = 1; i <= noOfStudentId; i++) {
						System.out.println("Enter the Student ID :: ");
						id = sc.nextInt();
						list.add(id);
					}

					try {
						List<Student> selectAllById = controller.selectAllById(list);
						for (Student s1 : selectAllById) {
							System.out.println("Student ID      :: " + s1.getStudentId());
							System.out.println("Student Name    :: " + s1.getStudentName());
							System.out.println("Student Age     :: " + s1.getStudentAge());
							System.out.println("Student Marks   :: " + s1.getStudentMarks());
							System.out.println("Student Address :: " + s1.getStudentAddr());
							System.out.println("============================================");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 4:
					System.out.println("Enter the Student ID :: ");
					id = sc.nextInt();

					try {
						boolean studentExist = controller.studentExist(id);
						if (studentExist) {
							System.out.println("Student Details Found");
						} else {
							System.out.println("Student Details Not Found");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			case 3:
				System.out.println("Enter Student ID :: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Student Name :: ");
				name = sc.nextLine();
				System.out.println("Enter Student Age :: ");
				age = sc.nextInt();
				System.out.println("Enter Student Marks :: ");
				marks = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Student Address :: ");
				addr = sc.nextLine();

				s.setStudentId(id);
				s.setStudentName(name);
				s.setStudentAge(age);
				s.setStudentMarks(marks);
				s.setStudentAddr(addr);

				try {
					controller.singleInsert(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("1. DELETE BY ID");
				System.out.println("2. DELETE ALL");
				System.out.println("3. DELETE BY ENTITY");
				System.out.println("4. DELETE BY MULTIPLE IDS");
				System.out.println("5. DELETE BY STUDENT ENTITIES");

				System.out.println("Enter Your Choice :: ");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter Student ID :: ");
					id = sc.nextInt();

					try {
						controller.removeID(id);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						controller.removeAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter Student ID :: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Student Name :: ");
					name = sc.nextLine();
					System.out.println("Enter Student Age :: ");
					age = sc.nextInt();
					System.out.println("Enter Student Marks :: ");
					marks = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter Student Address :: ");
					addr = sc.nextLine();

					s.setStudentId(id);
					s.setStudentName(name);
					s.setStudentAge(age);
					s.setStudentMarks(marks);
					s.setStudentAddr(addr);

					try {
						controller.removeEntity(s);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("Enter how many Student ID you want to DELETE :: ");
					int noIDdelete = sc.nextInt();

					System.out.println("Enter Student IDs :: ");
					for (int i = 1; i <= noIDdelete; i++) {
						id = sc.nextInt();
						list.add(id);
					}

					try {
						controller.removeAllById(list);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Enter how many Student Details You want to DELETE :: ");
					int noOfStudentDelete = sc.nextInt();
					List<Student> recordDelete = new ArrayList<>();
					for (int i = 1; i <= noOfStudentDelete; i++) {
						System.out.println("Enter Student ID :: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Student Name :: ");
						name = sc.nextLine();
						System.out.println("Enter Student Age :: ");
						age = sc.nextInt();
						System.out.println("Enter Student Marks :: ");
						marks = sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter Student Address :: ");
						addr = sc.nextLine();

						s.setStudentId(id);
						s.setStudentName(name);
						s.setStudentAge(age);
						s.setStudentMarks(marks);
						s.setStudentAddr(addr);

						recordDelete.add(s);
						controller.removeAll(recordDelete);
					}
					break;
				}
				break;
			case 5:
				System.out.println("Thank You ....");
				j=0;
				break;
			}

			
		}
		
		if (sc != null)
			sc.close();
	}

}
