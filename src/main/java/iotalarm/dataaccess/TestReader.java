package iotalarm.dataaccess;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import iotalarm.domain.Event;
import net.fortuna.ical4j.data.ParserException;

public class TestReader {
	private static TestReader instance;
	private static List<Event> list=new ArrayList<Event>();
	private static String url="";
	
	private TestReader() {
		list.add(new Event(1,"Test Event","Test Locatie",getTestDate()));
	}
	
	private Date getTestDate() {
		Date result=new Date();
		int currentMinutes=result.getMinutes();
		if (currentMinutes>57) {
			result.setHours(result.getHours());
			result.setMinutes(currentMinutes+2-60);
		}else {
			result.setMinutes(currentMinutes+2);
		}
		return result;
	}
	
	public static TestReader getInstance() {
		if (instance==null) {
			instance=new TestReader();
		}
		return instance;
	}
	
	public void updateUrl(String newurl) throws IOException, ParserException {
		if (!url.equals(newurl)) {
			url=newurl;
		}
	}

	
	public static List<Event> getEvents(){
		return list;
	}
	
	public static List<Event> getTodaysEvents(){
		List<Event>result=new ArrayList<Event>();
		for (Event e : list) {
			if (isToday(e.getDate())) {
				result.add(e);
			}
		}
		Collections.sort(result, new Comparator<Event>() {
			  public int compare(Event o1, Event o2) {
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
		return result;
	}
	
	private static boolean isToday(Date eventdate) {
LocalDate today=LocalDate.now();
LocalDate parsedEventDate=LocalDate.of(eventdate.getYear()+1900, eventdate.getMonth()+1, eventdate.getDate());
		if (parsedEventDate.isEqual(today)) {
			return true;
		}
		return false;
	}
}
