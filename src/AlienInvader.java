
public class AlienInvader extends Invader
{
	private int fleet;
	
	public AlienInvader()
	{
		this("AlienInvader",true,600,250,3);
	}
	
	public AlienInvader(String name,boolean canDodge,int lifeForceRemaining,int strikePower,int fleet)
	{
		super(name,canDodge,lifeForceRemaining,strikePower);
		setFleet(fleet);
	}
	
	public void setFleet(int fleet)
	{
		this.fleet = fleet;
	}
	
	public int getFleet()
	{
		return fleet;
	}
	
	public String toString()
	{
		String output = super.toString()+"\nFleet Size: "+fleet;
		return output;
	}

}