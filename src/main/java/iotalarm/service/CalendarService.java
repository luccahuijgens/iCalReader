package iotalarm.service;

import java.io.IOException;
import java.util.List;

import iotalarm.domain.Event;
import net.fortuna.ical4j.data.ParserException;

public interface CalendarService {
	public List<Event> getEvents(String url) throws IOException, ParserException;

	public List<Event> getTodaysEvents(String url) throws IOException, ParserException;

	public Event getTodaysFirstEvent(String url) throws IOException, ParserException;
}
