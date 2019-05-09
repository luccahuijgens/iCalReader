package iotalarm.service;

import java.util.List;

import iotalarm.dataaccess.EventReader;
import iotalarm.domain.Event;

public class EventService {

public List<Event> getEvents(String url){
	EventReader.getInstance().updateUrl(url);
	return EventReader.getEvents();
}

public List<Event> getTodaysEvents(String url){
	EventReader.getInstance().updateUrl(url);
	return EventReader.getTodaysEvents();
}

public Event getTodaysFirstEvent(String url) {
	EventReader.getInstance().updateUrl(url);
	List<Event>todaysevents=EventReader.getTodaysEvents();
	if (!todaysevents.isEmpty()) {
		return todaysevents.get(0);
		}
	return null;
}
}
