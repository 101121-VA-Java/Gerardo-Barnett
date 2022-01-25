
public class Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validatePIN("121317")); //true

        System.out.println(validatePIN("1234")); // true

        System.out.println(validatePIN("45135")); // false, pin must be 4 chars long or 6 chars long using numbers from 0 to 9

        System.out.println(validatePIN("89abc1"));//  false, pin must have numbers only

        System.out.println(validatePIN("900876"));//  true

        System.out.println(validatePIN(" 4983"));// false, no space allowed
	}

	 public static boolean validatePIN(String pin){
	        boolean isValid = true;
	        if(pin.length() != 4 && pin.length() != 6){
	            isValid = false;
	        }

	        if(!pin.matches("[0-9]+")){
	            
	            isValid = false;
	        }

	        return isValid;
	    }
}
