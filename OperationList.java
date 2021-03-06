import java.util.LinkedList; 
import java.util.Iterator; 
public class OperationList extends LinkedList<OperationNode> implements Comparable{
  
  public OperationList(){
   super();  
  }
  
  public OperationList(OperationList o){
    for(OperationNode node : o){
     
      
      this.add(new OperationNode(node.operator(), Factor.deepCopy(node.factor()))); 
      
    }
  }
  
  public void add(char c, Factor f){
   
    super.add(new OperationNode(c, f)); 
    
  }
  
  public int compareTo(Object o){
    
    OperationList that = (OperationList)o; 
    int listCompare = 0; 
    
    if(size() != that.size())
      listCompare = (size()-that.size())/(Math.abs(size()-that.size())); //likely not most efficient way to do this... but watever for now
    if(listCompare != 0)
      return listCompare; 
    
    //if sizes are unequal
    
    Iterator<OperationNode> thisIterator = iterator(); 
    Iterator<OperationNode> thatIterator = that.iterator(); 
    OperationNode thisPtr, thatPtr; 
    int ptrComp; 
    while(thisIterator.hasNext()){ //they should process parallel: 
     thisPtr = thisIterator.next(); 
     thatPtr = thatIterator.next(); 
     
     ptrComp = thisPtr.compareTo(thatPtr); 
     if(ptrComp < 0)
       return -1; 
     else if(ptrComp > 0)
       return 1; 
     
     
     
    }
    return 0; 
    
  }
  
  public String toString(){
    StringBuilder toRet = new StringBuilder(); 
   if(size() == 0)
     return ""; 
   Iterator<OperationNode> thisIter = iterator(); 
   while(thisIter.hasNext()){
     toRet.append(thisIter.next().toString()); 
   }
   return toRet.toString();   
  }
  
  
}