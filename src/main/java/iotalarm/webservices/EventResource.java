package iotalarm.webservices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import iotalarm.domain.Event;
import iotalarm.service.EventService;


@Path("events")
public class EventResource {
private EventService service=new EventService();

@GET
@Produces("application/json")
public String getEvents(){
	JsonArrayBuilder jab=Json.createArrayBuilder();
	for (Event e:service.getEvents()) {
		jab.add(convertJson(e));
	}
	return jab.build().toString();
}

@Path("today")
@GET
@Produces("application/json")
public String getTodaysEvents(){
	JsonArrayBuilder jab=Json.createArrayBuilder();
	for (Event e:service.getTodaysEvents()) {
		jab.add(convertJson(e));
	}
	return jab.build().toString();
}

private JsonObjectBuilder convertJson(Event e) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	JsonObjectBuilder job=Json.createObjectBuilder();
	job.add("id", e.getId());
	job.add("title", e.getTitle());
	job.add("location", e.getLocation());
	job.add("date", dateFormat.format(e.getDate()));
	return job;
}
}
