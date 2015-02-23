import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class PupilDriver
{

	
	
	
	public static void main(String args[])
	{
		
		boolean keepGoing = true;
		ArrayList<Pupil> students = new ArrayList<Pupil>();
		
		while(keepGoing)
		{
			
			Object[] options = {"Primary Student", "Secondary Student"};		
			int choice=JOptionPane.showOptionDialog(null, "Select what kind of pupil you would like to make", "Add Student",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);	
			System.out.println(choice);
			
			if(choice==0)
			{
				students.add(makePrimaryPupil());
			}
			else
			{
				students.add(makeSecondaryPupil());
			}
			
			keepGoing = Boolean.parseBoolean(JOptionPane.showInputDialog("Would you like to add another student (true or false)?"));
		}
		
		String output="";
		
		for(Pupil p : students)
		{
			output += p.toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, output);
		
	
	}
	
	public static PrimaryPupil makePrimaryPupil()
	{
		PrimaryPupil pp;
		String name = JOptionPane.showInputDialog("What is the name of the student?");
		String address = JOptionPane.showInputDialog("What is " +name+ "'s address?");
		String dob = JOptionPane.showInputDialog("What is the date of birth for " +name+ "?");
		String school = JOptionPane.showInputDialog("What school does " +name+ " attend?");
		String className = JOptionPane.showInputDialog("What is the class name for "+name+"?");
		String teacherName = JOptionPane.showInputDialog("What is " +name+ "'s teacher's name?");
		
		
		pp = new PrimaryPupil(name,address,dob,school,className,teacherName);
		return pp;
	}
	
	public static SecondaryPupil makeSecondaryPupil()
	{
		SecondaryPupil sp;
		String name = JOptionPane.showInputDialog("What is the name of the student?");
		String address = JOptionPane.showInputDialog("What is " +name+ "'s address?");
		String dob = JOptionPane.showInputDialog("What is the date of birth for " +name+ "?");
		String school = JOptionPane.showInputDialog("What school does " +name+ " attend?");
		String className = JOptionPane.showInputDialog("What is the class name for "+name+"?");
		
		sp = new SecondaryPupil(name,address,dob,school,className,makeSubjectArray());
		return sp;
	}
	
	public static LinkedList<String> makeSubjectArray()
	{
		LinkedList<String> subjects = new LinkedList<String>();
		String subj="startValue";
		
		while(subj.charAt(0)!='x')
		{
			subj = JOptionPane.showInputDialog("Add a subject this student is taking (enter x to exit)");
			subjects.add(subj);
		}
		
		return subjects;
	}
	

}








