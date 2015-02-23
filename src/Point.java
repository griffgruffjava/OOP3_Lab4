/**A class definition for a Point, that implements the
Shape interface*/
public class Point implements Shape{

	private int x,y; //point coordinates
  		
  /** default point is (0,0) */
  public Point() {
	    setPoint(0,0);
    }
  /** a known point
   *@param a the x coordinate
   *@param b the y coordinate
   */  
  public Point(int a, int b) {
	    setPoint(a,b);
    }

   /** change both of a point's coordinates
   *@param a the new x coordinate
   *@param b the new y coordinate
   */ 
  public void setPoint(int a, int b){
	     x=a;
	     y=b;
    }

  /** get the x coordinate
   *@return the x coordinate
   */
  public int getX(){
	     return x;
    }

  /** get the y coordinate
   *@return the y coordinate
   */
  protected int getY(){
	     return y;
    }

  /**
   *@return the point's coordinates in the form [x,y]
   */
  public String toString(){
	     return "[" + x +  "," + y + "]";
	}
  /** method must be provided for all Shapes
   *@return 0 as points don't have a shape
   */		
  public double area(){
			 return 0.0;
}	
  /** method must be provided for all Shapes
   *@return the name of the class, ie Point
   */
  public String getName(){
			 return "Point";
  } 											
}