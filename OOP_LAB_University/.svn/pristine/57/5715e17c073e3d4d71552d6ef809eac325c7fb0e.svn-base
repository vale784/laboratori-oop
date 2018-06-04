package university;

public class Student {
	
	final static int startId = 10000;
	final static int maxCourses = 25;
	private String studFirstName;
	private String studLastName;
	private int studId;
	private Course[] courseTaken = new Course[maxCourses];
	private int courTakenCount;	
	
	/**
	 * builder	 
	 */
	public Student(String first,String last,int studCount) {
		this.studFirstName = first;
		this.studLastName  = last;
		this.studId = startId + studCount;
	}
	
	/**
	 * getter
	 * @return studInfo
	 */
	public String getStud(){
		if(this.studId - startId < 0)
			return null;
		return this.studFirstName + " " + this.studLastName + " " + this.studId; 
	}
	
	
	public int getStudId() {
		return this.studId;
	}
	
	/*
	 * method gives a course to given student 
	 */
	public void addCourseToStud(Course c) {
		if(courTakenCount +1 > maxCourses) {
			System.out.println("Calm down, you have too much courses!!\n");
			return;
		}
		this.courseTaken[courTakenCount++] = c;
	}
	
	public String exportStudyPlan() {
		String res = "";
		for(int i=0;i<courTakenCount;i++)
			res += courseTaken[i].getCourse() + "\n";
		return res;
	}

}
