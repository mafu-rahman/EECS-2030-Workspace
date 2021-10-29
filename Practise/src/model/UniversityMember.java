package model;

	public class UniversityMember{
		public UniversityMember() {
		}
		String name;
		public String toString() {
			return "A University Member";
		}
	}
	class Student extends UniversityMember{
		public Student() {
		}
	}
	class Staff extends UniversityMember{	
		public Staff() {
		}
		public String toString() {
			return "A Staff";
		}
	}
	class Undergraduate extends Student{
		public Undergraduate() {
		}
		public String toString() {
			return "An Undergraduate Student";
		}
	}
	
	class Graduate extends Student{
		public Graduate() {
		}
	}
