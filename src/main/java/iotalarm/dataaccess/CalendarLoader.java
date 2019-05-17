package iotalarm.dataaccess;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	public CalendarLoader(String url) {
			CalendarBuilder builder = new CalendarBuilder();
			try{ 
				InputStream is = new URL(url).openStream();
				cal = builder.build(is);
				is.close();
				fillEvents();
				}
			catch (Exception e){
				e.printStackTrace();
				}
			}

	
	private boolean fillEvents() {
		try {
		ComponentList calendarevents = cal.getComponents().getComponents(
	            Component.VEVENT);
		for(int i = 0; i < calendarevents.size(); i++) {
			VEvent event = (VEvent) calendarevents.get(i);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
			//Get the unix Epoch time by making a devide with 1000.
			long unixEpoch = (sdf.parse(event.getStartDate().getValue()).getTime() /1000);
			Event parsedEvent = new Event(i+1,event.getSummary().getValue(),event.getLocation().getValue(),unixEpoch);
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