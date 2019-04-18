package iotalarm.service;

import java.util.List;

import iotalarm.dataaccess.EventLoader;
import iotalarm.domain.Event;

public class EventService {
private EventLoader eventLoader=new EventLoader();

public List<Event> getEvents(){
	return eventLoader.getEvents();
}

public List<Event> getTodaysEvents(){
	return eventLoader.getTodaysEvents();
}
}
