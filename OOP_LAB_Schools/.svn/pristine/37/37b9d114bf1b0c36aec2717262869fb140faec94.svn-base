package schools;

/**
 * Represents a branch of a {@link School}.
 * For each school there exist one or more branches.
 *
 */
public class Branch {
	
	private int regionalCode,zipCode;
	private String address;
	private Municipality municipality;
	private School school;
	
	/**
	 * Builder
	 * 
	 * @param regionalCode
	 * @param municipality
	 * @param address
	 * @param zipCode
	 * @param school
	 */
	public Branch(int regionalCode, Municipality municipality, 
							String address, int zipCode, School school) {
		this.regionalCode = regionalCode;
		this.municipality = municipality;
		this.address = address;
		this.zipCode = zipCode;
		this.school = school;
		school.branches.add(this);
	}
	
	
	/**
	 * Getter method for the code
	 * @return code of the branch
	 */
	public int getCode() {
		return this.regionalCode;
	}
	
	/**
	 * Getter method for the address
	 * @return address of the branch
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Getter method for the CAP (zip code)
	 * @return zip code of the branch
	 */
	public int getCAP() {
		return this.zipCode;
	}

	/**
	 * Retrieve the municipality where the branch is located
	 * @return municipality of the branch
	 */
	public Municipality getMunicipality(){
		return this.municipality;
	}
	
	/**
	 * Retrieve the school this branch belongs to.
	 * @return school the branch belongs to
	 */
	public School getSchool(){
		return this.school;
	}

}
