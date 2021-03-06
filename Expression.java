import java.util.List; 
import java.util.Iterator; 
import java.util.LinkedList; 
//an expression is a list of terms, which can be a factor. 
public class Expression extends Factor implements Comparable, Iterable{
  
  //private Stack<Term> stack;  
  private BinaryTreeList<Term> termList; 
  private Term lastAdded; 
  
  public void addTerms(List<Term> terms){
    
    termList.addAll(terms); 
    
  }
  
  public Iterator<Term> iterator(){
    return termList.iterator();  
  }
  
  public Term addTerm(Term t){ 
    termList.add(t); 
    return t; 
  }
  
  public boolean isEmpty(){
    return termList.size() <= 0;  
  }
  
  public int size(){
    return termList.size(); 
  }
  
  
  public Expression(){
    termList = new BinaryTreeList<Term>(); 
    
    
  }
  
  
  
  public Expression(Iterable<Term> terms){
    if(terms instanceof BinaryTreeList){
      this.termList = (BinaryTreeList<Term>)terms; 
    }
    else {
      if(terms instanceof Expression)
        operations = new OperationList(((Expression)terms).operations()); 
      
      //implement this 
      termList = new BinaryTreeList<Term>(); 
      for(Term t : terms)
        termList.add(t); 
    }
    
  }
  
  public void append(char c) {
    throw new IllegalArgumentException("Can't append an expression!"); 
  }
  
  public List<Term> terms(){
    
    return termList.asList(); 
    
  }
  
  public String toString(){
    //System.out.println("There (is/are) " + terms().size() + " term(s)."); 
    StringBuilder toRet = new StringBuilder(); 
    
    //toRet.append(getSign() ? "" : '-'); 
    toRet.append('('); 
    Iterator<Term> termIter = terms().iterator(); 
    if(termIter.hasNext())
      toRet.append(termIter.next()); 
    else return "()"; 
    while(termIter.hasNext()){
      toRet.append('+'); 
      toRet.append(termIter.next()); 
      
    }
    toRet.append(')'); 
    
    toRet.append(operations != null ? operations : ""); 
    
    return toRet.toString(); 
    
  }
  
  public int compareTo(Object o){
    
    Expression that = (Expression)o; 
    
    if(this.size() < that.size())
      return -1; 
    else if(this.size() > that.size())
      return 1; 
    
    //if sizes are equivalent:
    Iterator<Term> thisIter = terms().iterator(); 
    Iterator<Term> thatIter = that.terms().iterator(); 
    int termComp; 
    while(thisIter.hasNext()){
      termComp = thisIter.next().compareTo(thatIter.next()); 
      if(termComp < 0)
        return -1; 
      else if(termComp > 0)
        return 1; 
    }
    
    return 0; 
    
    
  }
  
  
} //End of the class  