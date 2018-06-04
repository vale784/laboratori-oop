package university;

public class University {

	/**
	 * params
	 */
	final static int maxStud = 1000;
	final static int maxCour = 50;
	private int studCount;
	private int courCount;
	private String uniName;
	private String recFirstN;
	private String recLastN;
	private Student[] student;
	private Course[] course;
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		student = new Student[maxStud];
		course  = new Course[maxCour];
		this.uniName = name;
	}
	
	/**
	 * Getter for the name of the university
	 * @return name of university
	 */
	public String getName(){
		return this.uniName;
	}
	
	/**
	 * Defines the rector for the university
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.recFirstN = first;
		this.recLastN  = last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * @return
	 */
	public String getRector(){
		return this.recFirstN + " " + this.recLastN;
	}
	
	/**
	 * Enroll a student in the university
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		if((studCount + 1) > maxStud)
			return -1;
		student[studCount] = new Student(first,last,studCount++);
		return student[studCount - 1].getStudId();
	}
	
	private Student findStudent(int id) {
		for(int i=0; i<studCount; i++)
			if(student[i].getStudId() == id)
				return student[i];
		return null;
	}
	
	/**
	 * Retrieves the information for a given student
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int id){
		Student tmp = findStudent(id);
		if(tmp==null) return null;
		return tmp.getStud();		
	}
	
	/**
	 * Activates a new course with the given teacher
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		if(courCount + 1 > maxCour)
			return -1;
		course[courCount] = new Course(title,teacher,courCount++);
		return course[courCount - 1].getCourseId();
	}
	
	private Course findCourse(int code) {
		for(int i=0; i<courCount; i++)
			if(course[i].getCourseId() == code)
				return course[i];
		return null;
	}
	
	/**
	 * Retrieve the information for a given course
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		Course tmp = findCourse(code);
		if(tmp==null) return null;
		return tmp.getCourse();
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		Course  tmpC = findCourse(courseCode);
		Student tmpS = findStudent(studentID);
		
		if(tmpC==null || tmpS==null) return;
		
		tmpC.addStudToCourse(tmpS);
		tmpS.addCourseToStud(tmpC);
	}
	
	/**
	 * Retrieve a list of attendees
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		Course tmp = findCourse(courseCode);
		if(tmp==null) return null;
		return "\n--" + tmp.getCourse() + "--\n" + tmp.exportEnrolledStud();
	}

	/**
	 * Retrieves the study plan for a student
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		Student tmp = findStudent(studentID);
		if(tmp==null) return null;
		return "\n--" + tmp.getStud() + "--\n" + tmp.exportStudyPlan();
	}
}
