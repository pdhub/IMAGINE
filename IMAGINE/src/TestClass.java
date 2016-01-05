
public class TestClass {

	public static void main(String[] args) {
		
		String  s = null;
		String v = "AV";
		System.out.println(s.equalsIgnoreCase(v));
		
		boolean ex21Enabled, ex26Enabled, menuParmAt514;
		
		ex21Enabled = true;
		ex26Enabled = true;
		menuParmAt514 = false;
		
		if(!ex21Enabled || (ex21Enabled && ex26Enabled && !menuParmAt514)) {
			System.out.println("Base");
			
		}
		else{
			System.out.println("EX21");
		}
	}
	
	
	
}
