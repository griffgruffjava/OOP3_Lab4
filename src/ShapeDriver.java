
public class ShapeDriver
{

	public static void main(String[] args)
	{
		Shape shape;
		Circle c1 = new Circle();
		Point c2 = new Circle(4.5,4,5);
		Shape c3 = new Circle(3.8,2,1);
		
		System.out.println(c1.toString());
		
		System.out.println(c2.toString());
		
		System.out.println(c3.toString());
		
		shape = c1;
		
		System.out.println(shape.toString());
		
		shape = c2;
		
		System.out.println(shape.toString());
		
		shape = c3;
		
		System.out.println(shape.toString());

	}

}
