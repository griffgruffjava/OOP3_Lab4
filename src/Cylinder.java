
public class Cylinder extends Circle
{
	private final double PI = 3.14;
	private double height;
	private double radius;
	
	public Cylinder()
	{
		this(1,3);
	}
	
	public Cylinder(double radius,double height)
	{
		setRadius(radius);
		setHeight(height);
		
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double area()
	{
		return (2*PI*radius*height)+(2*PI*(radius*radius));
		
	}
	
	public double volume()
	{
		return PI*(radius*radius)*height;
	}
	
	public String getName()
	{
		 return "Cylinder";
    } 
    
	public String toString()
	{
		return "The volume of the cylinder is " + volume();
	}
}
