package model;

public class Student {
	public static int studentNum = 0;
	
	public int stNum;
	public String name = "hvhvh";
	public double age;
	
//	public Student(String name, int age) {
//		this.studentNum++;
//		
//		this.stNum = this.studentNum;
//		this.name = name;
//		this.age = age;
//	}
	
	public Student(String name, double age) {
		this.studentNum++;
		
		this.stNum = this.studentNum;
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public int getStudentNum() {
		return this.stNum;
	}
	
	public int total() {
		return this.studentNum;
		
	}
	
}
