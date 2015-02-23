
public abstract class Pupil implements Child{

	private String name;
	private String address;
	private String dateOfBirth;
	private String school;
	private String className;
	
	
	public Pupil()
	{
		this("Unknown","Unknown","Unknown","Unknown","Unknown");
	}
	
	public Pupil(String name,String address,String dob,String school,String className)
	{
		setName(name);
		setAddress(address);
		setDateOfBirth(dob);
		setSchool(school);
		setClassName(className);
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public abstract String getCategory();
	
	
	@Override
	public String toString()
	{
		String output="";
		
		output = String.format("Name: %s\nAddress: %s\nDate of Birth: %s\nSchool: %s\nClass: %nCategory: %s\n",name,address,dateOfBirth,school,className,getCategory());
		
		
		return output;
	}
	
}












