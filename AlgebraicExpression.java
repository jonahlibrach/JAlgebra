import java.util.Hashtable; 

public class AlgebraicExpression{
  
  private Hashtable<AlgebraicExpression, AlgebraicExpression> evalTable; 
  
  public AlgebraicExpression(){
    
  }
  
  public boolean contains(AlgebraicExpression expression){
    return false; 
  }
 
  

  
  
  public AlgebraicExpression get(AlgebraicExpression expression){
    return null; 
  }
  
  public void set(AlgebraicExpression expression, AlgebraicExpression evaluation){
    
    /*
     Sometimes, people may try to evaluate for something illegally. 
     For example:
     x has been evaluated to 2. x := 2
     They then try to set("x+2", "7") which doesn't make sense, because "x+2 = 4"...
     
     */
    
  }
  
  public Hashtable<AlgebraicExpression, AlgebraicExpression> getEvalTable(){
   return evalTable;  
  }
  
  public void setEvalTable(Hashtable<AlgebraicExpression, AlgebraicExpression> evalTable){
    this.evalTable = null; 
      
  }
  
  public void show(){
   
    
    
  }
  
  
  
}