import java.util.List;
import java.util.Iterator; 
import java.util.LinkedList; 
//an expression which is designated to be multiplied with another factor instance 
abstract class Factor implements Comparable{
  
  
  
  protected OperationList operations; //the factor that comes after the operation is stored as an operational factor 
  protected char nextOperation; 
  protected boolean sign = true; 
  protected StringBuilder valueMask; 
  
  
  public Factor(){
   operations = new OperationList();  
  }
  
  public static Factor deepCopy(Factor f){
   System.out.println("Factor.deepCopy(), "+f+" is a: " +f.getClass()); 
    if(f instanceof Expression)
      return new Expression((Expression)f); 
    else if(f instanceof Variable)
      return new Variable((Variable) f); 
    else if(f instanceof Constant)
      return f; 
    else
      throw new IllegalArgumentException("Weird type given for Factor..."); 
  }
  
  /*
   For parsing exponent, its going to be parsed in a temp "factory"
   the f
   */
  //this might just be for organization but what properties can i give factor? 

  
  final void addOperation(char c, Factor f){
    
    if(operations == null)
      operations = new OperationList(); 

    operations.add(c,f); 
   
  }
  
  final OperationList operations(){
   return operations;  
  }
  
  
 
  
}




