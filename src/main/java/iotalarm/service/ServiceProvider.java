package iotalarm.service;

public class ServiceProvider {
	private static CalendarService eventService=new EventService();
	private static CalendarService testService=new TestService(); 
	private static TestModeService testmoduesService=new TestModeService();

	private ServiceProvider() {}
	
	public static CalendarService getCalendarService() {
		if (testmoduesService.getTestMode()) {
			return testService;
		}else {
			return eventService;
		}
	}
}
