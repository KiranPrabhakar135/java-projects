import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;



public class CheckBrackets {
	public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        int unmatchedPosition = -1;
        char unmatchedChar = 'a';
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                Bracket b = new Bracket(next, position);
                
                opening_brackets_stack.push(b);
                              
            }

            if (next == ')' || next == ']' || next == '}') {
               Bracket poppedElement = opening_brackets_stack.pop();
               if(!poppedElement.Match(next)){
            	   unmatchedPosition = position;
            	   unmatchedChar = next;
            	  break;
               }
            }
        }

        if(unmatchedPosition != -1){
        	System.out.println(unmatchedChar + " at position "  + unmatchedPosition);
        }
        else{
        	System.out.println("Success");
        }
        
    }
}
