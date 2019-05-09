package iotalarm.webservices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import iotalarm.domain.Event;
import iotalarm.service.EventService;

@Path("events")
public class EventResource {
	private EventService service = new EventService();

	@GET
	@Produces("application/json")
	public String getEvents(@HeaderParam("calendarurl") String url) {
		try {
			JsonArrayBuilder jab = Json.createArrayBuilder();
			for (Event e : service.getEvents(url)) {
				jab.add(convertJson(e));
			}
			return jab.build().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return NotFoundJSON();
		}
	}

	@Path("today")
	@GET
	@Produces("application/json")
	public String getTodaysEvents(@HeaderParam("calendarurl") String url) {
		try {
			JsonArrayBuilder jab = Json.createArrayBuilder();
			for (Event e : service.getTodaysEvents(url)) {
				jab.add(convertJson(e));
			}
			return jab.build().toString();
		} catch (Exception e) {
			return NotFoundJSON();
		}
	}

	@Path("today/first")
	@GET
	@Produces("application/json")
	public String getTodaysFirstEvent(@HeaderParam("calendarurl") String url) {
		try {
			Event todaysevent = service.getTodaysFirstEvent(url);
			JsonObjectBuilder job = Json.createObjectBuilder();
			if (todaysevent != null) {
				job = convertJson(todaysevent);
			}
			return job.build().toString();
		} catch (Exception e) {
			return NotFoundJSON();
		}
	}

	private JsonObjectBuilder convertJson(Event e) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", e.getId());
		job.add("title", e.getTitle());
		job.add("location", e.getLocation());
		job.add("date", dateFormat.format(e.getDate()));
		return job;
	}

	private String NotFoundJSON() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("error", "Exception");
		job.add("message", "We could not find your schedule. Maybe the url you provided is wrong.");
		return job.build().toString();
	}

}
