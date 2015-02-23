
public class Terrorist extends Invader
{
	private int bombs;
	
	public Terrorist()
	{
		this("Terrorist",false,75,1750,1);
	}
	
	public Terrorist(String name,boolean canDodge,int lifeForceRemaining,int strikePower,int bombs)
	{
		super(name,canDodge,lifeForceRemaining,strikePower);
		setBombs(bombs);
	}
	
	public void setBombs(int bombs)
	{
		this.bombs = bombs;
	}
	
	public int getBombs()
	{
		return bombs;
	}
	
	public String toString()
	{
		String output = super.toString()+"\nBombs Left: "+bombs;
		return output;
	}

}
