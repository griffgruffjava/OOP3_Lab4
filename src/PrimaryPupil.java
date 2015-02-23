
public class PrimaryPupil extends Pupil
{
	private String teacherName;
	
	
	public PrimaryPupil(String name,String address,String dob,String school,String className,String teacherName)
	{
		super(name,address,dob,school,className);
		setTeacherName(teacherName);
		
	}
	
	public String getTeacherName()
	{
		return teacherName;
	}

	public void setTeacherName(String teacherName)
	{
		this.teacherName = teacherName;
	}
	
	public String getCategory()
	{
		return "Primary Pupil";
	}
	
	public String toString()
	{
		String output = super.toString();
		output += String.format("Teacher: %s\nCategory: %s\n",teacherName,getCategory());

		return output;
		
	}
	
}
