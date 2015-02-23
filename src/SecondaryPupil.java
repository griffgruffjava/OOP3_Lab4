import java.util.LinkedList;


public class SecondaryPupil extends Pupil
{
	private LinkedList<String> subjects;
	
	public SecondaryPupil()
	{
		this("Unknown","Unknown","Unknown","Unknown","Unknown",null);
	}
	
	public SecondaryPupil(String name,String address,String dob,String school,String className,LinkedList<String> subjects)
	{
		super(name,address,dob,school,className);
		setSubjects(subjects);
	}
	
	public LinkedList<String> getSubjects()
	{
		return subjects;
	}
	
	public void setSubjects(LinkedList<String> subjects)
	{
		this.subjects=subjects;
	}
	
	public String getCategory()
	{
		return "Secondary Pupil";
	}
	
	public String toString()
	{
		String allSubjects="";
		
		for (String subs:subjects)
		{
			allSubjects += subs + "\n";
		}
		
		String output = super.toString();
		
		output += String.format("Subjects: %s\nCategory: %s\n",allSubjects,getCategory());

		return output;
		
	}
	
	

}
