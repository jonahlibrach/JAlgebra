
public class Constant extends Factor implements Comparable{
  
  private double value; 
  
  public double doubleValue() {
    return Double.parseDouble(valueMask.toString());
  }
  public int intValue() {
    return Math.round(Integer.parseInt(valueMask.toString()));
  }
  
  public Constant(char c){
    
    //System.out.println("CHAR CONSTRUCTOR"); 
    valueMask = new StringBuilder(); 
    valueMask.append(c);
  }
  
  public Constant(double num){
    
    //System.out.println("NUMBER CONSTRUCTOR"); 
    valueMask = new StringBuilder(""+num);
    this.value = num; 
  }
  
  public int compareTo(Object o){
   
    if(value < ((Constant)o).doubleValue())
      return -1; 
    else if (value == ((Constant)o).doubleValue())
      return 0; 
    else return 1; 
    
  }
  
  public String toString(){
    return "("+valueMask + (operations != null ? operations.toString() : "")+")";  
  }
  
  public Constant(Constant c){
    this.value = c.doubleValue(); 
    operations = new OperationList(c.operations()); 
  }
  
}
