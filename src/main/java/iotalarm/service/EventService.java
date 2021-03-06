/*
This service class is used to get the required event data from the EventReader. 
*/

package iotalarm.service;

import java.io.IOException;
import java.util.List;

import iotalarm.dataaccess.EventReader;
import iotalarm.domain.Event;
import net.fortuna.ical4j.data.ParserException;

public class EventService implements CalendarService{

	@Override
public List<Event> getEvents(String url) throws IOException, ParserException{
	EventReader.getInstance().updateUrl(url);
	return EventReader.getEvents();
}

	@Override
public List<Event> getTodaysEvents(String url) throws IOException, ParserException{
	EventReader.getInstance().updateUrl(url);
	return EventReader.getTodaysEvents();
}

@Override
public Event getTodaysFirstEvent(String url) throws IOException, ParserException {
	EventReader.getInstance().updateUrl(url);
	List<Event>todaysevents=EventReader.getTodaysEvents();
	if (!todaysevents.isEmpty()) {
		return todaysevents.get(0);
		}
	return null;
}
}
