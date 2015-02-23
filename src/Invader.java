
public abstract class Invader implements GameCharacter
{
	protected String name;
	protected boolean canDodge;
	protected int lifeForceRemaining;
	protected int strikePower;
	
	public Invader()
	{
		this("Unknown",false,0,0);
	}
	
	public Invader(String name,boolean canDodge,int lifeForceRemaining,int strikePower)
	{
		setName(name);
		setCanDodge(canDodge);
		setLifeForceRemaining(lifeForceRemaining);
		setStrikePower(strikePower);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public boolean getCanDodge()
	{
		return canDodge;
	}
	
	public void setCanDodge(boolean canDodge)
	{
		this.canDodge=canDodge;
	}
	
	public int lifeForceRemaining()
	{
		return lifeForceRemaining;
	}
	
	public void setLifeForceRemaining(int lifeForceRemaining)
	{
		this.lifeForceRemaining=lifeForceRemaining;
	}
	
	public int strikePower()
	{
		return strikePower;
	}
	
	public void setStrikePower(int strikePower)
	{
		this.strikePower = strikePower;
	}
	
	public String toString()
	{
		String output = String.format("Name: %s\nAbility to Dodge: %s\n"
				+ "Life Force Remaining: %d\nStrike Power: %d\n"
				,name,canDodge,lifeForceRemaining,strikePower);
		return output;
	}
}














