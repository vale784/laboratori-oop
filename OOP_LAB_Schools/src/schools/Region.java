package schools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// Hint: to write compact stream expressions
// you can include the following
//import static java.util.stream.Collectors.*;
//import static java.util.Comparator.*;

/**
 * Represents the region and serves as a facade class
 * for the package.
 * 
 * It provides factory methods for creating instances of
 * {@link Community}, {@link Municipality}, {@link School}, and {@link Branch}
 *
 */
public class Region {
	
	String name;
	private Map<String,Municipality> municipalities;
	private Map<String,Community> communities;
	private Map<String,School> schools; 
	
	/**
	 * Creates a new region with the given name.
	 * @param name the name of the region
	 */
	public Region(String name){
		this.name = name;
		this.municipalities = new HashMap<>();
		this.communities = new HashMap<>();
		this.schools = new HashMap<>();
	}
	
	/**
	 * Getter method
	 * @return the name of the region
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Retrieves all schools in the region
	 * @return collection of schools
	 */
	public Collection<School> getSchools() {
		return this.schools.values();
	}
	
	/**
	 * Retrieves all the communities
	 * @return the collection of all communities
	 */
	public Collection<Community> getCommunities() {
		return this.communities.values();
	}
	
	/**
	 * Retrieves all municipalities in the region
	 * @return the collection of municipalities
	 */
	public Collection<Municipality> getMunicipalies() {
		return this.municipalities.values();
	}
	
	
	// factory methods
	
	/**
	 * Factory method that build a new community of the given type.
	 * The type is {@link Community.Type}
	 * 
	 * @param name name of the community
	 * @param type type of the community
	 * @return the new created community
	 */
	public Community newCommunity(String name, Community.Type type){
		Community toReturn = new Community(name,type);
		this.communities.put(name,toReturn);
		return toReturn;
	}

	/**
	 * Factory method that build a new municipality.
	 * 
	 * @param nome 		name of the municipality
	 * @param province 	province of the municipality
	 * @return the new created municipality
	 */
	public Municipality newMunicipality(String nome, String province){
		Municipality toReturn = new Municipality(nome,province,null);
		this.municipalities.put(name,toReturn);
		return toReturn;
	}
	
	/**
	 * Factory methods, that build a new municipality that
	 * is part of a community.
	 * 
	 * @param nome 		name of the municipality
	 * @param province 	province of the municipality
	 * @param comunita  community the municipality belongs to 
	 * @return the new created municipality
	 */
	public Municipality newMunicipality(String nome, String province, Community comunita){
		Municipality toReturn = new Municipality(nome,province,comunita);
		this.municipalities.put(name,toReturn);
		return toReturn;
	}
	
	/**
	 * Factory method that creates a new school
	 * 
	 * @param name    name of the school
	 * @param code    code of the school
	 * @param grade	  grade of the school (1 to 4)
	 * @param description  description of the school
	 * 
	 * @return a new school object
	 */
	public School newSchool(String name, String code, int grade, String description){
		School toReturn = new School(name,code,grade,description);
		this.schools.put(code, toReturn);
		return toReturn;
	}
	
	/**
	 * Factory method that creates a new school branch
	 * 
	 * @param regionalCode	regional code of the branch
	 * @param municipality	municipality where the branch is located
	 * @param address		address of the branch
	 * @param zipCode		zip code of the branch
	 * @param school		school the branch is part of
	 * @return	the new created branch
	 */
	public Branch newBranch(int regionalCode, Municipality municipality, 
							String address, int zipCode, School school)	{
		Branch toReturn = new Branch(regionalCode,municipality,address,zipCode,school);
		this.schools.get(school.getCode()).branches.add(toReturn);
		return toReturn;
	}
	
	/**
	 * Load data from a file.
	 * 
	 * The file must be a CSV file and it is supposed to contain the following fields:
	 * <ul>
	 *  <li>{@code "Provincia"},   (province)
	 *  <li>{@code "Comune"},		(municipality)
	 *  <li>{@code "Grado Scolastico"}, (school grade)
	 *  <li>{@code "Descrizione Scuola"}, (school description)
	 *  <li>{@code "Cod Sede"}, (branch code)
	 *  <li>{@code "Cod Scuola"}, (school code)
	 *  <li>{@code "Denominazione Scuola"}, (name of the school)
	 *  <li>{@code "Indirizzo e n. civico"}, (address of the branch)
	 *  <li>{@code "C.A.P."}, (zip code of the branch)
	 *  <li>{@code "Comunita Collinare"}, (Hill community)
	 *  <li>{@code "Comunita Montana"},  (Mountain community)
	 * </ul>
	 * 
	 * @param file the path of the file
	 */
	public void readData(String file) {
		List<String> lines = null;
		try(BufferedReader in = new BufferedReader(new FileReader(file))){
			lines = in.lines().collect(toList());
		}catch(IOException e) { System.err.println(e.getMessage()); }
				
		// each item of the list contains a line of
		// the CSV file that can be split using "," as separator
		
		lines.stream().skip(1).map(s -> s.split(","))
		.forEach(col -> { 
			
			//preparing the string where i save the name of community or null if there isn't a community
			String communityName = col.length == 9 ? null:(col.length == 10 ? col[9]:col[10]);
			Community tmpCom = null;
			Municipality tmpMun = null;
			School tmpSch = null;
			
			//if not present it adds the community
			if(this.communities.get(communityName) == null && col.length != 9)
				this.newCommunity(communityName,(col.length == 10 ? Community.Type.MONTANA:Community.Type.COLLINARE));
			
			tmpCom = this.communities.get(communityName);
			
			//if not present it adds the municipality 				
			if(this.municipalities.get(col[1]) == null)
				this.newMunicipality(col[1],col[0],tmpCom);
			
			tmpMun = this.municipalities.get(col[1]);
			
			//if not present it adds the school		
			if(schools.get(col[5]) == null);
				this.newSchool(col[6],col[5],Integer.parseInt(col[2]),col[3]);
				
			tmpSch = this.schools.get(col[5]);
			
			//add a new branch by default
			this.newBranch(Integer.parseInt(col[4]), tmpMun, col[7], Integer.parseInt(col[8]), tmpSch);
				
		});
		
	}

	/**
	 * Counts how many schools there exist for each description
	 * @return a map of school count vs. description
	 */
	public Map<String,Long>countSchoolsPerDescription(){
		return this.schools.values().stream()
				.collect(groupingBy(School::getDescription,counting()));	
	}

	/**
	 * Count how many school branches there exist for each municipality
	 * @return a map of branch count vs. municipality
	 */
	public Map<String,Long>countBranchesPerMunicipality(){		
		return this.schools.values().stream()
				.map(s -> s.getBranches())
				.flatMap(Collection::stream)
				.collect(groupingBy(b -> b.getMunicipality().getName(),counting()));				
	}

	/**
	 * Counts the number of school branches per municipality
	 * and groups them by province.
	 * @return a map of maps the inner reports count of branches vs. municipality
	 * 			the outer reports provinces as keys
	 */
	public Map<String,Map<String,Long>>countBranchesPerMunicipalityPerProvince(){
		return this.schools.values().stream()
				.map(s -> s.getBranches())
				.flatMap(Collection::stream)
				.collect(groupingBy(ext -> ext.getMunicipality().getProvince(),
						 groupingBy(b -> b.getMunicipality().getName(),counting())));
	}


	/**
	 * returns a list of strings with format
	 * {@code "### - XXXXXX"}, where 
	 * {@code ###} represents the number of schools (not branches)
	 * and {@code XXXXXX} represents the name of the municipality.
	 * If a school has more than one branch in a municipality
	 * it must be counted only once.
	 * 
	 * @return a collection of strings with the counts
	 */
	public Collection<String> countSchoolsPerMunicipality(){
		return this.schools.values().stream()
				.map(s -> s.getBranches())
				.flatMap(Collection::stream)
				.collect(groupingBy(s -> s.getCommunity().getName()),
						mapping(Branch::getSchool,collectingAndThen(toSet(), Set::size )
								)
						)
				.entrySet().stream()
				.map(e -> e.getValue() + " " + e.getKey())
				.collect(toList());
				
	}
	
	/**
	 * returns a list of strings with format
	 * {@code "### - XXXXXX"}, where 
	 * {@code ###} represents the number of schools (not branches)
	 * and {@code XXXXXX} represents the name of the community.
	 * They are sorted by descending number of schools.
	 * The list must contain only schools having at least
	 * a branch in a municipality part of a community.
	 * 
	 * @return a collection of strings with the counts
	 */
	public List<String> countSchoolsPerCommunity(){
		return null;
	}

	
}
