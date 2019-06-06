package iotalarm.service;

public class ServiceProvider {
	private static CalendarService eventService=new EventService();
	private static CalendarService testService=new TestService(); 
	private static TestModesService testmoduesService=new TestModesService();

	private ServiceProvider() {}
	
	public static CalendarService getCalendarService() {
		if (testmoduesService.getTestModes()) {
			return testService;
		}else {
			return eventService;
		}
	}
}
