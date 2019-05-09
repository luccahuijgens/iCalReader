package iotalarm.dataaccess;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import iotalarm.domain.Event;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.VEvent;

public class CalendarLoader {
	private ArrayList<Event> events=new ArrayList<Event>();
	Calendar cal;

	public CalendarLoader(String url) throws IOException, ParserException{
			InputStream is = new URL(url).openStream();
		   cal = new CalendarBuilder().build(is);
			is.close();
			fillEvents();
	}
	
	private boolean fillEvents() {
		try {
		ComponentList calendarevents = cal.getComponents().getComponents(
	            Component.VEVENT);
		for(int i = 0; i < calendarevents.size(); i++) {
			VEvent event = (VEvent) calendarevents.get(i);
			Event parsedEvent = new Event(i+1,event.getSummary().getValue(),event.getLocation().getValue(),event.getStartDate().getDate());
			events.add(parsedEvent);
		}
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Event> getEvents(){
		return events;
	}
}
