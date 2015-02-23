
public class Ghost implements Enemy
{
	double strength;
	String name;
	
	

	public Ghost()
	{
		this("Ghost",100);
	}
	
	public Ghost(String name,double strength)
	{
		setName(name);
		setStrength(strength);
	}
	

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setStrength(double strength)
	{
		this.strength=strength;
	}
	
	public double getStrength()
	{
		return strength;
	}

	
	public void looseStrength(double amount)
	{
		double newStrength = getStrength() - amount;
		setStrength(newStrength);
	}
	
	public String toString()
	{
		String output = String.format("Name: %s\nStrength: %f",name,strength);
		return output;
	}

}
