package iotalarm.webservices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import iotalarm.domain.Event;
import iotalarm.service.EventService;


@Path("events")
public class EventResource {
private EventService service=new EventService();

@GET
@Produces("application/json")
public String getEvents(@QueryParam("eu") String eu,@QueryParam("url") String url,@QueryParam("h") String params,@QueryParam("group") String group){
	url=convertUrl(url,params,group,eu);
	JsonArrayBuilder jab=Json.createArrayBuilder();
	for (Event e:service.getEvents(url)) {
		jab.add(convertJson(e));
	}
	return jab.build().toString();
}

@Path("today")
@GET
@Produces("application/json")
public String getTodaysEvents(@QueryParam("eu") String eu,@QueryParam("url") String url,@QueryParam("h") String params,@QueryParam("group") String group){
	url=convertUrl(url,params,group,eu);
	JsonArrayBuilder jab=Json.createArrayBuilder();
	for (Event e:service.getTodaysEvents(url)) {
		jab.add(convertJson(e));
	}
	return jab.build().toString();
}

@Path("today/first")
@GET
@Produces("application/json")
public String getTodaysFirstEvent(@QueryParam("eu") String eu,@QueryParam("url") String url,@QueryParam("h") String params,@QueryParam("group") String group){
	url=convertUrl(url,params,group,eu);
	Event todaysevent=service.getTodaysFirstEvent(url);
	JsonObjectBuilder job=Json.createObjectBuilder();
	if (todaysevent!=null) {
	job=convertJson(todaysevent);
	}
	return job.build().toString();
}

private JsonObjectBuilder convertJson(Event e) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	JsonObjectBuilder job=Json.createObjectBuilder();
	job.add("id", e.getId());
	job.add("title", e.getTitle());
	job.add("location", e.getLocation());
	job.add("date", dateFormat.format(e.getDate()));
	return job;
}

private String convertUrl(String base,String params, String group,String eu) {
	String result=base;
	result+="&h=";
	result+=params;
	if (group!=null) {
		result+="&group="+group;
	}
	if (eu!=null) {
		result+="&eu="+eu;
	}
	System.out.println(result);
	return result;
}
}
