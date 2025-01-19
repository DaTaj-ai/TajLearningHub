
public class IpCutter{

	public static void main(String[] args){
	
		System.out.println(args[0]);
		String[] strArr = args[0].split("\\.");
		System.out.println(strArr[0]); 
		
		for(String str : strArr){
			System.out.println(str);
		}
	}
}
