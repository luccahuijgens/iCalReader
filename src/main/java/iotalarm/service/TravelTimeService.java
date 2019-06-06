package iotalarm.service;

import iotalarm.config.TravelTime;

public class TravelTimeService {

	public int getTravelTime() {
		TravelTime.getInstance();
		return TravelTime.getTravelTime();
	}

	public void setTravelTime(int travelTime){
		TravelTime.getInstance();
		TravelTime.setTravelTime(travelTime);
	}

}
