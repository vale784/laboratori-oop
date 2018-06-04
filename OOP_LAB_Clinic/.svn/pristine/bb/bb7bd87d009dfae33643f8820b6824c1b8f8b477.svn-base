package clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;

/**
 * Represents a clinic with patients and doctors.
 * 
 */
public class Clinic {
	
	private Map<String,Patient> patients;
	private Map<Integer,Doctor> doctors;
	private static final int patientFields = 3;
	private static final int doctorFields = 5;
	
	public Clinic() {
		patients = new HashMap<>();
		doctors = new HashMap<>();
	}

	/**
	 * Add a new clinic patient.
	 * 
	 * @param first first name of the patient
	 * @param last last name of the patient
	 * @param ssn SSN number of the patient
	 */
	public void addPatient(String first, String last, String ssn) {
		this.patients.put(ssn.trim(), new Patient(first,last,ssn));
	}


	/**
	 * Retrieves a patient information
	 * 
	 * @param ssn SSN of the patient
	 * @return the object representing the patient
	 * @throws NoSuchPatient in case of no patient with matching SSN
	 */
	public String getPatient(String ssn) throws NoSuchPatient {
		Patient tmp;
		if((tmp = this.patients.get(ssn))!=null)
			return tmp.getLast() + " " + tmp.getFirst() + " ( " + tmp.getSsn() + " )";
		else {
			throw new NoSuchPatient();
		}
	}

	/**
	 * Add a new doctor working at the clinic
	 * 
	 * @param first first name of the doctor
	 * @param last last name of the doctor
	 * @param ssn SSN number of the doctor
	 * @param docID unique ID of the doctor
	 * @param specialization doctor's specialization
	 */
	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		//idk why requirements are bad written
		this.patients.put(ssn, new Patient(first,last,ssn));
		this.doctors.put(docID, new Doctor(first,last,ssn,docID,specialization));
	}

	/**
	 * Retrieves information about a doctor
	 * 
	 * @param docID ID of the doctor
	 * @return object with information about the doctor
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public String getDoctor(int docID) throws NoSuchDoctor {
		Doctor tmp;
		if((tmp = doctors.get(docID))!=null)
			return tmp.getLast() + " " + tmp.getFirst() + " (" + tmp.getSsn() + ") [" 
					+ tmp.getDocID() + "]: " + tmp.getSpecialization();
		else {
			throw new NoSuchDoctor();
		}
	}
	
	/**
	 * Assign a given doctor to a patient
	 * 
	 * @param ssn SSN of the patient
	 * @param docID ID of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor exists with a matching ID
	 */
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		Patient tmpPat;
		Doctor tmpDoc;
		
		if((tmpPat = patients.get(ssn)) == null) throw new NoSuchPatient();
		if((tmpDoc = doctors.get(docID)) == null) throw new NoSuchDoctor();
		
		tmpPat.setDoctor(tmpDoc);
		tmpDoc.setPatient(tmpPat);
	}
	
	/**
	 * Retrieves the id of the doctor assigned to a given patient.
	 * 
	 * @param ssn SSN of the patient
	 * @return id of the doctor
	 * @throws NoSuchPatient in case of not patient with matching SSN
	 * @throws NoSuchDoctor in case no doctor has been assigned to the patient
	 */
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
		
		Patient tmpPat, tmpDoc;
		
		if((tmpPat = patients.get(ssn)) == null) throw new NoSuchPatient();
		if((tmpDoc = tmpPat.getDoctor()) == null) throw new NoSuchDoctor();
		
		return ((Doctor)tmpDoc).getDocID();
	}
	
	/**
	 * Retrieves the patients assigned to a doctor
	 * 
	 * @param id ID of the doctor
	 * @return collection of patient SSN
	 * @throws NoSuchDoctor in case the {@code id} does not match any doctor 
	 */
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {
		
		Doctor tmpDoc;
		
		if((tmpDoc=doctors.get(id))==null) throw new NoSuchDoctor();
		
		return tmpDoc.getPatients().stream()
				.map(Patient::getSsn)
				.collect(toList());
	}


	/**
	 * Loads data about doctors and patients from the given stream.
	 * <p>
	 * The text file is organized by rows, each row contains info about
	 * either a patient or a doctor.</p>
	 * <p>
	 * Rows containing a patient's info begin with letter {@code "P"} followed by first name,
	 * last name, and SSN. Rows containing doctor's info start with letter {@code "M"},
	 * followed by badge ID, first name, last name, SSN, and specialization.<br>
	 * The elements on a line are separated by the {@code ';'} character possibly
	 * surrounded by spaces that should be ignored.</p>
	 * <p>
	 * In case of error in the data present on a given row, the method should be able
	 * to ignore the row and skip to the next one.<br>

	 * 
	 * @param path the path of the required file
	 * @throws IOException in case of IO error
	 */
	public void loadData(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
		String line,sepLine[];
		try {
			while( (line = br.readLine()) != null) {
				line.trim();
				sepLine = line.trim().split(";");			
				if(sepLine[0].equals("P") && (sepLine.length == patientFields + 1)) {
					if(patients.get(sepLine[3])==null)
						this.addPatient(sepLine[1], sepLine[2], sepLine[3]);
				}else if(sepLine[0].equals("M") && (sepLine.length == doctorFields + 1)) {
					if(doctors.get(Integer.parseInt(sepLine[1]))==null)
						this.addDoctor(sepLine[2], sepLine[3], sepLine[4], Integer.parseInt(sepLine[1]), sepLine[5]);
				}	
			}
		}catch(IOException e) {
			System.err.println("Problemi in lettura del file");
		}
	}


	/**
	 * Retrieves the collection of doctors that have no patient at all, sorted in alphabetic order.
	 * 
	 * @return the collection of doctors with no patient sorted in alphabetic order (last name and then first name)
	 */
	public Collection<Integer> idleDoctors(){
		return doctors.values().stream()
				.filter(p -> p.getPatients().size() == 0 )
				.sorted((a,b)-> {
					return a.getLast().equals(b.getLast()) ? 
							a.getFirst().compareTo(b.getFirst()) : a.getLast().compareTo(b.getLast());
				})
				.map(Doctor::getDocID)
				.collect(toList());
	}

	/**
	 * Retrieves the collection of doctors having a number of patients larger than the average.
	 * 
	 * @return  the collection of doctors
	 */
	public Collection<Integer> busyDoctors(){
		return doctors.values().stream()
				.filter(d -> d.getPatients().size() > 
					(doctors.values().stream()
					.map(doc ->  doc.getPatients())
					.collect(averagingInt(Collection::size))))
				.map(d -> d.getDocID())
				.collect(toList());
	}

	/**
	 * Retrieves the information about doctors and relative number of assigned patients.
	 * <p>
	 * The method returns list of strings formatted as "{@code ### : ID SURNAME NAME}" where {@code ###}
	 * represent the number of patients (printed on three characters).
	 * <p>
	 * The list is sorted by decreasing number of patients.
	 * 
	 * @return the collection of strings with information about doctors and patients count
	 */
	public Collection<String> doctorsByNumPatients(){
		return doctors.values().stream()
				.map(d -> String.format("%3d", d.getPatients().size()) + " : " 
						+ d.getDocID() + " " + d.getLast() + " " + d.getFirst())
				.sorted((a,b) ->{
					return -a.compareTo(b);
					})
				.collect(toList());
	}
	
	/**
	 * Retrieves the number of patients per (their doctor's)  specialization 
	 * <p>
	 * The information is a collections of strings structured as {@code ### - SPECIALITY}
	 * where {@code SPECIALITY} is the name of the speciality and 
	 * {@code ###} is the number of patients cured by doctors with such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic specialization.
	 * 
	 * @return the collection of strings with specialization and patient count information.
	 */
	public Collection<String> countPatientsPerSpecialization(){
		return doctors.values().stream()
				.map(d -> String.format("%3d", doctors.values().stream()
						.filter(doc->doc.getSpecialization() == d.getSpecialization()) 
						.map(doc -> doc.getPatients())
						.flatMap(Collection::stream)
						.count()) + " - " + d.getSpecialization())
				.distinct()
				.sorted((a,b) ->{
					return -a.compareTo(b);
					})
				.collect(toList());
	}
	
}
