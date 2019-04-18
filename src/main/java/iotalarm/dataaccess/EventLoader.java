package iotalarm.dataaccess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import iotalarm.domain.Event;

public class EventLoader {
	List<Event> list=new ArrayList<Event>();

	public EventLoader() {
		try {
		Event event1=new Event(1,"DEIN Hoorcollege","HL15",new SimpleDateFormat("dd/MM/yyyy").parse("18/04/2019"));
		Event event2=new Event(2,"BDSD Werkcollege","HL15",new SimpleDateFormat("dd/MM/yyyy").parse("18/04/2019"));
		list.add(event1);
		list.add(event2);
		}
		catch (ParseException e){
		}
	}
	
	public List<Event> getEvents(){
		return list;
	}
	
	public List<Event> getTodaysEvents(){
		List<Event>result=new ArrayList<Event>();
		Date today=new Date();
		for (Event e : list) {
			if (today.compareTo(e.getDate())==0) {
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
}
