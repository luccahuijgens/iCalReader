package iotalarm.service;

import iotalarm.config.TestModes;

public class TestModesService {
	
	public void flipTestModes(){
		TestModes.getInstance().setTestMode();
	}
	
	public boolean getTestModes(){
		return TestModes.getInstance().getTestModes();
	}
}
