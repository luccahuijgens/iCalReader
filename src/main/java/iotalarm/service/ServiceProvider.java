package iotalarm.service;

public class ServiceProvider {
	private static CalendarService eventService=new EventService();
	private static CalendarService testService=new TestService(); 

	private ServiceProvider() {}
	
	public static CalendarService getCalendarService() {
		if (true) {
			return testService;
		}else {
			return eventService;
		}
	}
}
