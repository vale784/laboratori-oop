import university.*;

public class ExampleApp {

	public static void main(String[] args) {
		
		String universityName = "Politecnico di Torino";
		
		University poli = new University(universityName);
		
		poli.setRector("Imperatore", "Supremo");
		
		System.out.println("Rector of " + poli.getName() + " : " + poli.getRector());
		
		int s1 = poli.enroll("Fapobianco","Cancesco");
		int s2 = poli.enroll("Caniele","Darrozzino");
		
		System.out.println("Enrolled students " + s1 + ", " + s2);
		System.out.println("s1 = " + poli.student(s1));
		System.out.println("s2 = " + poli.student(s2));
		
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop   = poli.activate("Object Oriented Programming", "Marco Torchiano");
		
		System.out.println("Activated courses " + macro + " and " + oop);
		poli.register(s1, macro);
		poli.register(s2, macro);
		
		System.out.println(poli.listAttendees(macro)); 
		System.out.println(poli.studyPlan(s1));
		
	}
}
