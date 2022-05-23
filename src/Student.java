import java.util.Comparator;

public class Student {
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	public Student() {
		firstName = new String();
		lastName = new String();
		grade = 0;
		department = new String();
 	}
	
	public Student(String firstName,String lastName,double grade,String department) {
		setFName(firstName);
		setLName(lastName);
		setGrade(grade);
		setDepartment(department);
	}
	
	public String getName() {
		return getFName() + " " + getLName();
	}
	
	public String getFName() {
		return firstName;
	}
	
	public String getLName() {
		return lastName;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setFName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return String.format("%-10s", getFName()) + " " + String.format("%-10s", getLName()) + " " + String.format("%-10.2f", getGrade()) + " " + String.format("%-10s", getDepartment());
	}
	
	public int equals() {
		return 0;
	}
	
	// task2
	private static final Comparator<Student> COMPARE_TASK2 = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return (int)s1.grade - (int)s2.grade; 
		}
	};
	
	// task4
	private static final Comparator<Student> COMPARE_TASK41 = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			int compareLName = s1.lastName.compareTo(s2.lastName);
			if(compareLName != 0)
				return compareLName;
			else
				return s1.firstName.compareTo(s2.firstName);
		}
	};
	
	private static final Comparator<Student> COMPARE_TASK42 = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			int compareFName = s2.lastName.compareTo(s1.lastName);
			if(compareFName != 0)
				return compareFName;
			else
				return s2.firstName.compareTo(s1.firstName);
		}
	};
}
