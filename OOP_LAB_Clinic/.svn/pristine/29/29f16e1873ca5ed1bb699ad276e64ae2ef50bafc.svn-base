package clinic;

import java.util.Collection;
import java.util.LinkedList;

public class Doctor extends Patient {
	
	private String specialization;
	private int docID;
	private Collection<Patient> patients;
	
	public Doctor(String last, String first, String ssn, int docID, String specialization) {
		super(last,first,ssn);
		this.setDocID(docID);
		this.setSpecialization(specialization);
		this.patients = new LinkedList<>();
	}

	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * @return the docID
	 */
	public int getDocID() {
		return docID;
	}

	/**
	 * @param docID the docID to set
	 */
	public void setDocID(int docID) {
		this.docID = docID;
	}
	
	public void setPatient(Patient patient) {
		this.patients.add(patient);
	}
	
	public Collection<Patient> getPatients(){
		return patients;
	}
	

}
