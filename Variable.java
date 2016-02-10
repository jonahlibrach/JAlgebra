
public class Variable extends Factor implements Comparable{
  
  private String subscript; 
  private char letter; 
   
  
  public Variable(char c){
    this.letter = c; 
    valueMask = new StringBuilder(""+c); 
  }
  
  public char letter(){
   return letter;  
  }
  
  
  public void setSubscript(String s){
    subscript = s; 
  }
  
  
  public void setValue(Constant constant){
    throw new UnsupportedOperationException("CAN'T EVALUATE YET!");
  }
  
  public void setValue(Double d){
    throw new UnsupportedOperationException("CAN'T EVALUATE YET!"); 
  }
  
  public String subscript(){
   return subscript;  
  }
  public int compareTo(Object o){
   
    if(!(o instanceof Variable)){
       throw new IllegalArgumentException("Variables only comparable to other factors.");
    }
       
    
    Variable that = (Variable)o;
    
    if(this.letter < that.letter())
      return -1; 
    else if(this.letter > that.letter())
      return 1; 
    else  
      return operations.compareTo(that.operations);  

    
  }
  
  public Variable(Variable v){
  
    System.out.println("In the variable constructor, copying "+v.letter()); 
    this.letter = v.letter(); 
    operations = new OperationList(v.operations()); 
  }
  
  
  
  
  public String toString(){
   StringBuilder sb = new StringBuilder(); 
   sb.append("("); 
   sb.append(valueMask); 
   if(operations != null)
    sb.append(operations.toString());
    
   sb.append(")"); 
   return sb.toString(); 
  }
  
}
