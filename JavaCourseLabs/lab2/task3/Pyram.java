public class Pyram{
	public static void main(String[] args){
		int number = Integer.parseInt(args[0]);
		int counter = number+number ; 
		String repeated ;
		for(int i = 1 ; i<=number ; i++){
			repeated = new String(new char[i]).replace("\0", "*");
			System.out.print(repeated);
			
			repeated = new String(new char[counter]).replace("\0", " ");
			counter--; 
			counter--; 
			System.out.print(repeated);
			
			repeated = new String(new char[i]).replace("\0", " *");
			System.out.print(repeated);
			
			System.out.print("\n");
			}
}
}

/*public class Pyram{
	public static void main(String[] args){
		int number = Integer.parseInt(args[0]);
		
		String repeated ;
		for(int i = 1 ; i<=number ; i++){
			for(int j = 0 ;j<i ;j++){
			repeated = new String(new char[i]).replace("\0", "*");
			System.out.print(repeated);
			}
			System.out.print("\n");
			}
}
}
*/








