package iotalarm.config;

public class TestMode {
	private static TestMode instance;
	private static boolean testModes = false;
	
	private TestMode(){}
		
	static{
		
        try{
            instance = new TestMode();
        }
        catch(Exception e){
            throw new RuntimeException("Exception occured in creating TestModes instance");
        }
    }
	
	public static TestMode getInstance(){
        return instance;
    }
	
	public static void setTestMode () {
		if (testModes == false){
			testModes = (!testModes);
			}
		
		else if (testModes == true) {
			testModes = (!testModes);
			}
		
		else {
			System.out.println("A unknown error occurred");
		}
	}
	
	public boolean getTestModes(){
		return testModes;
	}
	
}