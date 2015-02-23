
public abstract class Defender implements GameCharacter
{
	protected String name;
	protected int shield;
	protected int lifeForceRemaining;
	protected int strikePower;
	
	public Defender()
	{
		this("Unknown",0,0,0);
	}
	
	public Defender(String name,int shield,int lifeForceRemaining,int strikePower)
	{
		setName(name);
		setShield(shield);
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
	
	public int getShield()
	{
		return shield;
	}
	
	public void setShield(int shield)
	{
		this.shield=shield;
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
		String output = String.format("Name: %s\nShield: %d\nLife Force Remaining: %d\nStrike Power: %d\n",name,shield,lifeForceRemaining,strikePower);
		return output;
	}
}














