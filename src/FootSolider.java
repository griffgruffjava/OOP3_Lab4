
public final class FootSolider extends Defender
{
	private int platoonSize;
	
	public FootSolider()
	{
		this("Foot Solider",25,100,50,10);
	}
	
	public FootSolider(String name,int shield,int lifeForceRemaining,int strikePower,int platoonSize)
	{
		super(name,shield,lifeForceRemaining,strikePower);
		setPlatoonSize(platoonSize);
	}
	
	public void setPlatoonSize(int platoonSize)
	{
		this.platoonSize = platoonSize;
	}
	
	public int getPlatoonSize()
	{
		return platoonSize;
	}
	
	public String toString()
	{
		String output = super.toString()+"\nPlatoon Size: "+platoonSize;
		return output;
	}
	
	
}







