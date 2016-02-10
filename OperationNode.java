public class OperationNode implements Comparable{

  private Factor factor; 
  private char operator; 
  
  public OperationNode(char operator, Factor f){
   this.factor = f; 
   this.operator = operator; 
  }
    
  public char operator(){
   return this.operator;  
  }
  
  public Factor factor(){
   return this.factor;  
  }
  
  public int compareTo(Object o){
   
    OperationNode that = (OperationNode)o; 
    
    if(this.operator < that.operator())
      return -1; 
    else if(this.operator > that.operator())
      return 1; 

    return this.factor.compareTo(that.factor()); 
    
    
    
  }
  
  public String toString(){
   StringBuilder sb = new StringBuilder(); 
   sb.append(operator); 
   sb.append(factor); 
   return sb.toString(); 
  }
    
}