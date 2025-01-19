public class Calc{

public static void main(String[] args)
{	
	
	//System.out.println(num1);
	//System.out.println(num2);
	//System.out.println(args[1]);
	if(args.length > 0 ){
	
	float num1 = Integer.parseInt(args[0]); 
	float num2 = Integer.parseInt(args[2]);
	
	if(args[1].equals("+")){	
		System.out.println(num1 + num2 );
	}
	else if (args[1].equals("-")){	
		System.out.println(num1 - num2 );	
	}
	else if (args[1].equals("x")){
		System.out.println(num1 * num2 );	
	}
	else if (args[1].equals("/")){
		if(num2 != 0 ){
		System.out.println(num1 / num2 );
		}
		else{
		System.out.println("the number 2 = 0");
		}
	}
	else{
	System.out.println("Check your input");
	}
	}
	else{
	System.out.println(" no input ");
	}
	
}

}
