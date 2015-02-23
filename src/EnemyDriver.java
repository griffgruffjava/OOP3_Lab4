
public class EnemyDriver
{
	public static void main(String args[])
	{
	
	Enemy badguy;
	Ghost g1 = new Ghost("Spooky",50);
	badguy = g1;
	System.out.println(g1.toString());
	System.out.println(badguy.toString());
	}
	
}
