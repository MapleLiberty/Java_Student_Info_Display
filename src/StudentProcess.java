import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.lang.*;

public class StudentProcess {
	
	public static void main(String[] args) {
		
		// task 1
		System.out.println("Task 1:\n");
		System.out.println("Complete Student list:");
		
		Student[] students = {
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
				 new Student("John", "White", 47.0, "Media"),
				 new Student("Laney", "White", 62.0, "IT"),
				 new Student("Jack", "Jones", 32.9, "Business"),
				 new Student("Wesley", "Jones", 42.89, "Media")};
		 
		List<Student> studentList = Arrays.asList(students);
		
		studentList.forEach(System.out::println);
		
		
		// task 2
		System.out.println("\nTask 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		
		Stream<Student> studentStream2 = studentList.stream();
		
		Predicate<Student> fiftyToHundred = student -> student.getGrade() >= 50 && student.getGrade() <= 100; // filter()
		
		studentStream2.filter(fiftyToHundred)
					  .sorted(Comparator.comparing(Student::getGrade))
		              .forEach(System.out::println);
		

		
		
		// task 3
		System.out.println("\n\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		
		Stream<Student> studentStream3 = studentList.stream();
		studentStream3.filter(fiftyToHundred)
					 .findFirst()
		             .ifPresent(System.out::println);
		
		
		
		// task 4
		System.out.println("\n\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		
		Comparator<Student> comparatorTask = Comparator.comparing(Student::getLName).thenComparing(Student::getFName);
		
		Stream<Student> studentStream41 = studentList.stream();
		studentStream41.sorted(comparatorTask)
		             .forEach(System.out::println);
		
		
		System.out.println("\nStudents in descending order by last name then first:");
		
		Stream<Student> studentStream42 = studentList.stream();
		studentStream42.sorted(comparatorTask.reversed())
		               .forEach(System.out::println);
		
		
		// task 5 
		System.out.println("\n\nTask 5:\n");
		System.out.println("Unique Student last names:");
		
		Stream<Student> studentStream5 = studentList.stream();

		studentStream5.map(Student::getLName)
					  .distinct()
		              .sorted()
		              .forEach(System.out::println);
		
	
		
		// task 6 
		System.out.println("\n\nTask 6:\n");
		System.out.println("Student names in order by last name then first name:");
		
		Stream<Student> studentStream6 = studentList.stream();
		studentStream6.sorted(Comparator.comparing(Student::getLName).thenComparing(Student::getFName))
					  .map(Student::getName)
					  .forEach(System.out::println);
		
		
		// task 7
		System.out.println("\n\nTask 7:\n");
		System.out.println("Students by department:");
	
		
		Map<String,List<Student>> departmentMap = new HashMap<>();
		
		Predicate<Student> mediaDepart = student -> student.getDepartment() == "Media";
		Predicate<Student> itDepart = student-> student.getDepartment() == "IT";
		Predicate<Student> businessDepart =  student-> student.getDepartment() == "Business";
		
		List<Student> media = studentList.stream().filter(mediaDepart).collect(Collectors.toList());  //Collectors.groupingBy()
		List<Student> it = studentList.stream().filter(itDepart).collect(Collectors.toList());
		List<Student> business = studentList.stream().filter(businessDepart).collect(Collectors.toList());

		departmentMap.put("Media",media);
		departmentMap.put("IT",it);
		departmentMap.put("Business",business);
		
		System.out.println("Media");
		departmentMap.get("Media").forEach(System.out::println);
		System.out.println();
		System.out.println("IT");
		departmentMap.get("IT").forEach(System.out::println);
		System.out.println();
		System.out.println("Business");
		departmentMap.get("Business").forEach(System.out::println);
		System.out.println();
		
		// task 8
		System.out.println("\n\nTask 8:\n");
		System.out.println("Count of Students by department:");
		
		Map<String,Long> departmentCountMap = new HashMap<>();	
		
		long mediaCount = studentList.stream().filter(mediaDepart).collect(Collectors.counting());
		long itCount = studentList.stream().filter(itDepart).collect(Collectors.counting());
		long businessCount = studentList.stream().filter(businessDepart).collect(Collectors.counting());
		
		departmentCountMap.put("Media", mediaCount);
		departmentCountMap.put("IT", itCount);
		departmentCountMap.put("Business", businessCount);
		
		System.out.println("Business has " + departmentCountMap.get("Business") + " Student(s)");
		System.out.println("IT has " + departmentCountMap.get("IT") + " Student(s)");	
		System.out.println("Media has " + departmentCountMap.get("Media") + " Student(s)");
		
		
		// task 9
		System.out.println("\n\nTask 9:\n");
		
		Stream<Student> studentStream9 = studentList.stream();
		
		System.out.println("Sum of Students' grades: " + studentStream9.mapToDouble(Student::getGrade).sum() );
		

		
		// task 10
		System.out.println("\n\nTask 10:\n");
		
		Stream<Student> studentStream10 = studentList.stream();
		
		System.out.println("Average of Students' grades: " + (double)Math.round( (studentStream10.mapToDouble(Student::getGrade).average().getAsDouble())*100)/100 );	
		
	}
}
