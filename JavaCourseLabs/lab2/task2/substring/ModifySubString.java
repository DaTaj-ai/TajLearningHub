public class ModifySubString{
	public static void main(String[] args){
		String str = args[0];
		
		int dotIndex  = 0 ;
		int end = 100 ; 
		 	       
			   
		while(end != -1 ){
			end = str.indexOf("." , dotIndex);
			if(end > 0 ){
			System.out.println(str.substring(dotIndex ,end ));
			dotIndex = end+1 ;
			}
			else{
			System.out.println(str.substring(dotIndex ,str.length() ));
			}
		}
	}
	}






/*public class ModifySubString{
	public static void main(String[] args){
		String str = args[0];
		
		int dotIndex  = 0 ;
		int end = str.indexOf("." , dotIndex+1);
		 	
			   
		while(end != -1 ){
			System.out.println(str.substring(dotIndex ,end ));
			dotIndex = str.indexOf("." ,end );
			end = str.indexOf("." , dotIndex+1);
		}
	}
	}

*/

/*public class ModifySubString{
	public static void main(String[] args){
		String str = args[0];
		
		int dotIndex  = 0 ;  
		for(int i =0 ; i<4 ; i++){
			dotIndex = str.indexOf(".");	
			System.out.println(str.substring(0 ,dotIndex));
			str = str.substring(dotIndex+1);
			
		}
	}
}*/
