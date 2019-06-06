package iotalarm.config;

public class TravelTime {
	private static TravelTime instance;
	private static int travelTime = 0;
	
	private TravelTime(){}
		
	static{
		
        try{
            instance = new TravelTime();
        }
        catch(Exception e){
            throw new RuntimeException("Exception occured in creating TravelTime instance");
        }
    }
	
	public static TravelTime getInstance(){
        return instance;
    }
	
	public static void setTravelTime(int travelTime){
		TravelTime.travelTime = travelTime;
	}
	
	public static int getTravelTime(){
		return travelTime;
	}
	
}