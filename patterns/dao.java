import java.util.ArrayList;
import java.util.List;

public class Student{
	private String name;
	private int rollNo;
	
	Student(String name, int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getRollNo(){
		return rollNo;
	}
	
	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}
}

public interface StudentDao{
	public List<Student> getAllStudent();
	public Student getStudent(int rollNo);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
}

public class StudentDaoImpl implements StudentDao{
	
	List<Student> students;
	
	public StudentDaoImpl(){
		students = new ArrayList<Student>();
		Student student1 = new Student("John",0);
		Student student2 = new Student("Mark",1);
		students.add(student1);
		students.add(student2);
	}
	
	public void deleteStudent(Student student){
		students.remove(student.getRollNo());
		System.out.println("Student: Roll# "+ student.getRollNo() + ", deleted.");
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	public Student getStudent(int rollNo){
		return students.get(rollNo);
	}
	
	public void updateStudent(Student student){
		students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll# "+ student.getRollNo() + ", updated.");
	}
}

public class dao{
	public static void main(String[] args){
		StudentDao studentDao = new StudentDaoImpl();
		
		for(Student student : studentDao.getAllStudents()){
			System.out.println("Student: [Roll#: "+ student.getRollNo() +", Name: "+ student.getName() + " ]");
		}
		
		Student student = studentDao.getAllStudents().get(0);
		student.setName("Jaime");
		studentDao.updateStudent(student);
		
		studentDao.getStudent(0);
		System.out.println("Student: [Roll#: "+ student.getRollNo() +", Name: "+ student.getName() +" ]");
	}
}