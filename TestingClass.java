import java.io.*; 

public class TestingClass{


public static void main() throws Exception{
  PrintWriter inPrint = new PrintWriter(new File("high_tally.in")); 
   for(int i = 0; i < 1000; i++){
   inPrint.write("game overlapping_win_p1.txt overlapping_loss_p2.txt\n"); 
  }
  StringBuilder sb = new StringBuilder(); 
  for(int i = 0; i < 1000; i++){
   
    sb.append("X's move\n(plays NW)\nO's move\n(plays C)\nX's move\n(plays W)\nO's move\n(plays NE)\nX's move\n(plays SW)\nX wins\nScore is\n)");
    sb.append("X "+(i+1)+"\n");
    sb.append("O "+(i)+"\n");  
    sb.append("O's move\n(plays NW)\nX's move\n(plays C)\nO's move\n(plays W)\nX's move\n(plays NE)\nO's move\n(plays SW)\nO wins\nScore is\n)");
    sb.append("X "+(i+1)+"\n");
    sb.append("O "+(i+1)+"\n");
  }
}

  
}