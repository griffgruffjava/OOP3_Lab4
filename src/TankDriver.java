
public final class TankDriver extends Defender
{
	int shells;
	
	public TankDriver()
	{
		this("Tank Driver",1000,1000,250,30);
	}
	
	public TankDriver(String name,int shield,int lifeForceRemaining,int strikePower,int shells)
	{
		super(name,shield,lifeForceRemaining,strikePower);
		setShells(shells);
	}
	
	public void setShells(int shells)
	{
		this.shells = shells;
	}
	
	public int getShells()
	{
		return shells;
	}
	
	public String toString()
	{
		String output = super.toString()+"\nPlatoon Size: " + shells;
		return output;
	}
	
	
}