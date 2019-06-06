package iotalarm.config;

public class TestModes {
	private static TestModes instance;
	private boolean testModes = false;
	
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
	
	public void setTestMode () {
		if (this.testModes = false){
			this.testModes = true;
			}
		
		else if (this.testModes = true) {
			this.testModes = false;
			}
		
		else {
			System.out.println("A unknown error occurred");
		}
	}
	
	public boolean getTestModes(){
		return this.testModes;
	}
	
}