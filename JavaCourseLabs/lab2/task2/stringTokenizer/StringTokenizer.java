
import java.util.StringTokenizer ; 


public class ModifyStringTokenizer{
	public static void main(String[] args){
		StringTokenizer st = new StringTokenizer(args[0] , "o");
     		while (st.hasMoreTokens()) {
         		System.out.println(st.nextToken());
     		}
	}
}
