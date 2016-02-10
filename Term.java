import java.util.*; 
//list of factors
public class Term implements Comparable, Iterable{
  
  private boolean sign; 
  private static boolean firstPushAfterExp; 
  private BinaryTreeList<Factor> factors; 
  private LinkedList<Constant> constants; 
   
  public boolean isEmpty(){
   return factors.size() + constants.size() != 0;  
  }
  
  public Factor addFactor(Factor f){
   // System.out.println(f+" was added."); 
    if(f instanceof Constant)
      constants.add((Constant)f); 
    else
      factors.add(f);
  //  System.out.println("And the term looks like: "+this); 
  //  System.out.println("The tree size is: " +factors.size()); 
    return f; 
    
  }
  
  public Iterator<Factor> iterator(){
    return new Iterator<Factor>(){
     Iterator<Constant> constIter = constants.iterator(); 
     Iterator<Factor> factorIter = factors.iterator(); 
      public boolean hasNext(){
        if(constIter.hasNext())
          return true; 
        else if(factorIter.hasNext())
          return true; 
        return false; 
      }
      
      public Factor next(){
        if(constIter.hasNext())
          return constIter.next(); 
        else return factorIter.next(); 
      }
      
      public void remove(){
       throw new UnsupportedOperationException();  
      }
      
    };
  
  }
  
  public int size(){
    
    return factors.size() + (constants != null ? constants.size() : 0); 
   
  }
  
  public void addFactors(List<? extends Factor> factors){
   Iterator<? extends Factor> iter = factors.iterator(); 
   while(iter.hasNext())
    addFactor(iter.next());  
  }
  
  
  public void setSign(boolean sign){
    this.sign = sign; 
  }
  
  public List<Constant> constants(){
    return constants; 
  }

  
  public Term(){
    factors = new BinaryTreeList<Factor>(); 
    constants = new LinkedList<Constant>(); 
    this.sign = true; 
  }
  
  public Term(Term t){
   
    factors = new BinaryTreeList<Factor>(); 
    constants = new LinkedList<Constant>(); 
    for(Factor f : factors.asList()){
     factors.add(Factor.deepCopy(f)); 
    }
    
    
  }

  public List<Factor> factors(){
   return factors.asList();  
  }
  
  public String toString(){
   // System.out.println("In the Term toString() method."); 
    
    
    StringBuilder termString = new StringBuilder(); 
  
   
    
    if(constants != null){
      for(Constant c : constants)
        termString.append(c.toString()); 
    }
    
    if(factors != null){
    for(Factor f : factors.asList()){
    //  System.out.println("~Term: Appending the factors of this term."); 
      termString.append(f.toString()); 
    }
    }
    
    return termString.toString();
  }
  
  public boolean getSign(){
   return this.sign;  
  }
  
  public int compareTo(Object o){
    
    if(!(o instanceof Term))
      throw new IllegalArgumentException("Illegal comparison."); 
    Term that = (Term)o; 
    Iterator<Factor> thatIter = that.factors().iterator(); 
    Iterator<Factor> thisIter = factors().iterator(); 
    
    if(this.size() == that.size()){
      int elementCompare = 0; 
      while(thisIter.hasNext()){
     
      elementCompare = thisIter.next().compareTo(thatIter.next()); 
      if(elementCompare != 0)
        return elementCompare;
      return 0; 
      }
    }
    
    else if(this.size() < that.size())
       return -1; 
    return 1; 
    
    
  }
  
  public void removeFactor(Factor f){
    
    factors.remove(f); 
  }
  
  public List<Factor> allFactors(){
   LinkedList<Factor> toReturn = new LinkedList<Factor>();  
   toReturn.addAll(constants); 
   toReturn.addAll(factors.asList()); 
   return toReturn; 
  }

  
  
  
}
