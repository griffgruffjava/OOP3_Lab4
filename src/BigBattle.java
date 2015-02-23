import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class BigBattle extends JFrame implements ActionListener
{
	JMenu mainMenu;
	JMenu teamsMenu;
	JMenu moreInvaders;
	JMenu moreDefenders;
	ArrayList<Defender> goodguys = new ArrayList<Defender>();
	ArrayList<Invader> badguys = new ArrayList<Invader>();
	JTextArea jtext = new JTextArea(250,150);
	String goodTeam,badTeam;
	Container cpane;
	Terrorist ter;
	TankDriver td;
	FootSolider fs;
	AlienInvader ai;
	int goodPick,badPick;
	
	public BigBattle()
	{
		setTitle("Invaders VS Defenders!");
		setSize(300,250);
		setLocation(300,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMainMenu();
		createTeamsMenu();
	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(mainMenu);
		menuBar.add(teamsMenu);
		
		cpane = getContentPane();
		
//		cpane.add(badTeam);
		cpane.add(jtext);
		
		
		
		
		
		
		
		
		
	}//end constructor
	
	public static void main(String args[])
	{
		BigBattle bb = new BigBattle();
		bb.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();

		if (menuName.equals("Start Battle")) 
		{
			if(goodguys.size()==0||badguys.size()==0)
			{
				JOptionPane.showMessageDialog(null, "Both sides must have fighters before you can do Battle!");
			}
			else
			{
				doBattle();
			}
				
		}
		else if (menuName.equals("Quit")) 
		{
			System.exit(0);
		}
		else if (menuName.equals("Add Terrorist")) 
		{
			ter = new Terrorist();
			badguys.add(ter);
			jtext.setText(null);
			jtext.append(teamsToString());
			
		} 
		else if (menuName.equals("Add Alien Fleet")) 
		{
			ai = new AlienInvader();
			badguys.add(ai);
			jtext.setText(null);
			jtext.append(teamsToString());

		}
		else if (menuName.equals("Add Foot Solider Platoon")) 
		{
			fs = new FootSolider();
			System.out.println(fs.toString());
			goodguys.add(fs);
			jtext.setText(null);
			jtext.append(teamsToString());
			
		} 
		else if (menuName.equals("Add Tank")) 
		{
			td = new TankDriver();
			goodguys.add(td);
			jtext.setText(null);
			jtext.append(teamsToString());
		}

	}// end action handler
	
	private void createMainMenu()
	{
		JMenuItem item;
		mainMenu = new JMenu("Main Menu");
		
		item = new JMenuItem("Start Battle");
		item.addActionListener(this);
		mainMenu.add(item);
		
		item = new JMenuItem("Quit");
		item.addActionListener(this);
		mainMenu.add(item);
	}
	
	private void createTeamsMenu()
	{
		JMenuItem item;
		teamsMenu = new JMenu("Build Teams");
		
		moreInvaders = new JMenu("Add Invaders");
//		moreInvaders.addActionListener(this);
		teamsMenu.add(moreInvaders);
		
		item = new JMenuItem("Add Terrorist");
		item.addActionListener(this);
		moreInvaders.add(item);
		
		item = new JMenuItem("Add Alien Fleet");
		item.addActionListener(this);
		moreInvaders.add(item);
		
		moreDefenders = new JMenu("Add Defenders");
//		moreDefenders.addActionListener(this);
		teamsMenu.add(moreDefenders);
		
		item = new JMenuItem("Add Foot Solider Platoon");
		item.addActionListener(this);
		moreDefenders.add(item);
		
		item = new JMenuItem("Add Tank");
		item.addActionListener(this);
		moreDefenders.add(item);
		
	}
	
	public String teamsToString()
	{
		String output="";
		int ter=0,ai=0,fs=0,tk=0;
		
		for(Invader i: badguys)
		{
			if(i.getName().equals("Terrorist"))
			{
				ter++;
			}
			else
			{
				ai++;
			}
		}
		
		for(Defender i: goodguys)
		{
			if(i.getName().equals("Foot Solider"))
			{
				fs++;
			}
			else
			{
				tk++;
			}
		}
		output = String.format("GOOD GUYS\n---------\nFoot Solider Platoons: %d\n"
				+ "Total Tanks: %d\n\nBAD GUYS\n---------\nTerrorist: %d"
				+ "\nAlien Fleets: %d",fs,tk,ter,ai);
		
		return output;
	}
	
	public void doBattle()
	{
		goodPick = (int)(Math.random()*goodguys.size()-1);
		badPick = (int)(Math.random()*badguys.size()-1);
		
		Defender defender = goodguys.get(goodPick);
		Invader invader = badguys.get(badPick);
		
		if(invader instanceof Terrorist && defender instanceof FootSolider)
		{
			ter=(Terrorist)(invader);
			fs=(FootSolider)(defender);
			fightTerrorVsFoot(ter,fs);
		}
		else if(invader instanceof Terrorist && defender instanceof TankDriver)
		{
			ter=(Terrorist)(invader);
			td=(TankDriver)(defender);
			fightTerrorVsTank(ter,td);
		}
		else if(invader instanceof AlienInvader && defender instanceof TankDriver)
		{
			ai=(AlienInvader)(invader);
			td=(TankDriver)(defender);
			fightAlienVsTank(ai,td);
		}
		else
		{
			ai=(AlienInvader)(invader);
			fs=(FootSolider)(defender);
			fightAlienVsFoot(ai,fs);
		}
		
	}
	
	public void fightTerrorVsFoot(Terrorist i,FootSolider d)
	{
		int num = (int)(Math.random()*100+1);
		int dlf = (d.getPlatoonSize()*d.getShield())+(d.getPlatoonSize()*d.lifeForceRemaining());
		String narative="";
		
		narative+="This round was Terrorist VS a Foot Solider Platoon\n";
		if(num%2==0)//this is a hit from terrorist
		{
			narative+="The terrorist blew up their vest bomb in the crowd of soliders\n";
			dlf=dlf-i.strikePower();
			i.setBombs(i.getBombs()-1);
			i.setLifeForceRemaining(i.lifeForceRemaining-i.strikePower());
		}
		else
		{
			narative+="The terrorist did not get close enough to the soliders before their bomb blew up\n";
		}
		
		num = (int)(Math.random()*100+1);
		if(num%2==0)//this is a hit from platoon
		{
			narative+="The soliders shot at the terrorist when they saw him\n";
			i.setLifeForceRemaining(i.lifeForceRemaining-(d.strikePower()*d.getPlatoonSize()));
		}
		else
		{
			narative+="The soliders did not manage to shoot him\n";
		}
		
		if(i.lifeForceRemaining()<=0)
		{
			badguys.remove(badPick);
			narative+="The terrorist is dead\n";
		}
		else
		{
//			badguys.remove(badPick);
			badguys.set(badPick,i);
		}
		
		if(dlf<=0)
		{
			goodguys.remove(goodPick);
			narative+="All the soliders in the platoon are dead!\n";
		}
		else
		{
			if(dlf/100<10)
			{
				d.setPlatoonSize(dlf/100);
				d.setLifeForceRemaining(dlf/10);
				narative+="The platoon is damaged but still alive\n";
			}
			else
			{
				d.setPlatoonSize(10);
				d.setLifeForceRemaining(100);
				d.setShield((dlf-1000)/10);
				narative+="The platoon is undamaged and doing very well\n";
			}
			
//			goodguys.remove(goodPick);
			goodguys.set(goodPick,d);
			
		}
		
		JOptionPane.showMessageDialog(null, narative);
		jtext.setText(null);
		jtext.append(teamsToString());
		
	}//end terVSfs
	
	public void fightTerrorVsTank(Terrorist i,TankDriver d)
	{
		int num = (int)(Math.random()*100+1);

		String narative="";
		
		if(num%2==0)//terrorist hits
		{
			narative+="The terrorist gets within range of the tank before exploding bomb\n";
			i.setStrikePower(i.strikePower()-d.getShield());
			d.setLifeForceRemaining(d.lifeForceRemaining()-i.strikePower());
			i.setLifeForceRemaining(i.lifeForceRemaining()-i.strikePower());
		}
		else
		{
			narative+="The terrorist did not get close enough to do damage before his bomb exploded\n";
			
		}
		
		if(i.lifeForceRemaining()<=0)
		{
			badguys.remove(badPick);
			narative+="The terrorist was killed when the bomb exploded\n";
		}
		else
		{
			if(d.lifeForceRemaining()>0)
			{
				num=(int)(Math.random()*100+1);
				if(num%5==0)//tank misses 1/5 times
				{
					narative+="The tank fires and misses the terrorist\n";
				}
				else
				{
					if(d.getShells()<=0)
					{
						narative+="The tank has no shells to fire\n";
					}
					else
					{
						i.setLifeForceRemaining(i.lifeForceRemaining()-d.strikePower());
						d.setShells(d.getShells()-1);
						narative+="The tank shoots ant hits the terrorist\n";
						if(i.lifeForceRemaining()<0)
						{
							narative+="The terrorist was killed by the tank shell\n";
						
						}
					}
				}
				goodguys.set(goodPick,d);
			}
			else
				narative+="The tank and crew have been destroyed!\n";
				goodguys.remove(goodPick);
		}
		
		JOptionPane.showMessageDialog(null, narative);
		jtext.setText(null);
		jtext.append(teamsToString());
	}//end terVStank
	
	public void fightAlienVsTank(AlienInvader i,TankDriver d)
	{
		int num = (int)(Math.random()*100+1);

		String narative="";
		
		if(num%5==0)//tank misses
		{
			narative+="The tank shoots and misses the Aliens!\n";
			d.setShells(d.getShells()-1);
		}
		else
		{
			narative+="The tank shoots at the Aliens!\n";
			d.setShells(d.getShells()-1);
			num = (int)(Math.random()*100+1);
			if(num%3==0)//alien dodges fire
			{
				narative+="The tank shoots at the Aliens!\n";
			}
			else
			{
				narative+="And gets a direct hit!\n";
				i.setLifeForceRemaining(((i.lifeForceRemaining()*i.getFleet())-d.strikePower())/3);
				if(i.lifeForceRemaining()<=0)
				{
					narative+="This Alien fleet is destroyed\n";
					badguys.remove(badPick);
				}
				else
				{
					badguys.set(badPick, i);
				}
			}
			
		}
		
		num = (int)(Math.random()*100+1);
		
		if(i.lifeForceRemaining()>0)
		{
			if(num%5==0)//tank dodges alien fire
			{
				narative+="The Alien ships fire but miss the tank\n";
			}
			else
			{
				if(i.getFleet()*i.strikePower()>d.getShield())
				{
					narative+="The Alien fire on the tank\n";
					d.setLifeForceRemaining(d.lifeForceRemaining()-((i.getFleet()*i.strikePower())-d.getShield()));
				
					if(d.lifeForceRemaining()<=0)
					{
						narative+="The tank is destroyed!\n";
						goodguys.remove(goodPick);
					}
					else
					{
						narative+="The tank is damaged but not destroyed!\n";
						goodguys.set(goodPick,d);
					}
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, narative);
		jtext.setText(null);
		jtext.append(teamsToString());
			
			
	}//end etVStd
	
	public void fightAlienVsFoot(AlienInvader ai,FootSolider fs)
	{
		
	}//end et VS fs
	
	
}//end main

















