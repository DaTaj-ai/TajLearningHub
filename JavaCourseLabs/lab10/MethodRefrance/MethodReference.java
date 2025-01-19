




// example one 
interface Sayable{  
    void say();  
}


public class MethodReference {  
    
	public static void saySomething(){  
        System.out.println("Example one static method.");  
    }  
	
	public  void saySomethingInstance(){  
        System.out.println("Example Instance method .");  
    }  
    
	
	public static void main(String[] args) {  
	// static method refrance  
        Sayable sayable = MethodReference::saySomething;  
        
        sayable.say();
		
	// Instance Method refrance ; 
	
	MethodReference methodReference = new MethodReference(); // Creating object  
         
            Sayable sayable1 = methodReference::saySomethingInstance;  
        
            sayable1.say();  
          

		
    }  
}  