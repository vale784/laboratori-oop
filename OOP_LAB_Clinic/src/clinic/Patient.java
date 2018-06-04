package clinic;

public class Patient {

	private String first, last, ssn;
	Doctor doctor = null;
	
	public Patient(String first, String last, String ssn) {
		this.setFirst(first);
		this.setLast(last);
		this.setSsn(ssn);
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}


	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}


	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Doctor getDoctor() {
		return this.doctor;
	}

}
