package university;

public class Course {
	
	final static int startCourId = 10;
	final static int maxEnrollStud = 100;
	private String courseName;
	private String teacher;
	private int courseId;
	private Student[] enrolledStud = new Student[maxEnrollStud];
	private int enStudCount;
	
	public Course(String courseName, String teacher,int id){
		this.courseName = courseName;
		this.teacher = teacher;
		this.courseId = startCourId + id;
	}
	
	/*
	 * getters
	 */
	public int getCourseId() {
		return courseId;
	}
	
	public String getCourse() {
		return courseId + " " + courseName + " " + teacher;
	}
	
	/*
	 * method enrolls a student to given course
	 */
	public void addStudToCourse(Student s) {
		if(enStudCount+1 > maxEnrollStud) {
			System.out.println("Class is full!\n");
			return;
		}
		this.enrolledStud[enStudCount++] = s;
	}
	
	public String exportEnrolledStud() {
		String res = "";
		for(int i=0;i<enStudCount;i++)
			res += enrolledStud[i].getStud() + "\n";
		return res;
	}
	
	

}
