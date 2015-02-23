/**Class definition for a Circle, as a point with a radius.
*/
public class Circle extends Point{

  private double radius; 
  		
  public Circle() {
	    setRadius(0);
   }
  
  /** all attributes known
   @param r the radius (double)
   @param a x-coordinate of centre
   @param b y-coordinate of centre
   */  
  public Circle(double r, int a, int b) {
    	 //setPoint(a,b);
	  	super(a,b);
    	 setRadius(r);    
    }

  public void setRadius(double r){
	    if (r>0)
	    	radius = r;
	    else
	    	radius = 0;
    }

  public double getRadius(){
	     return radius;
    }

  /** 
   *@return the centre coords and the radius, with explanatory text, on one line
   */
  public String toString(){
	     return "Center of circle is at " + super.toString() + "; Radius is " + radius;
	}
   /** calculates the area, based on the radius
    *@return the area of the circle, a double
    */		
   public double area(){
			 return Math.PI*radius*radius;
	}
		
   /** implements the Shape getName() method
    *@return "Circle"
    */
   public String getName(){
			 return "Circle";
	} 				
   
  
}