package iotalarm.service;

import iotalarm.config.TestMode;

public class TestModeService {
	
	public void flipTestMode(){
		TestMode.getInstance().setTestMode();
	}
	
	public boolean getTestMode(){
		return TestMode.getInstance().getTestModes();
	}
}
