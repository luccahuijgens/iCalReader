package iotalarm.config;

public class TestModes {
	private static TestModes instance;
	private static boolean testModes = false;
	
	private TestModes(){}
		
	static{
		
        try{
            instance = new TestModes();
        }
        catch(Exception e){
            throw new RuntimeException("Exception occured in creating TestModes instance");
        }
    }
	
	public static TestModes getInstance(){
        return instance;
    }
	
	public static void setTestMode () {
		if (testModes == false){
			testModes = true;
			}
		
		else if (testModes == true) {
			testModes = false;
			}
		
		else {
			System.out.println("A unknown error occurred");
		}
	}
	
	public boolean getTestModes(){
		return testModes;
	}
	
}