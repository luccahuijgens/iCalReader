package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import iotalarm.domain.Event;

public class BasicResource {

	protected JsonObjectBuilder convertJson(Event e) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", e.getId());
		job.add("title", e.getTitle());
		job.add("location", e.getLocation());
		job.add("date",e.getDate());
		return job;
	}

	protected String NotFoundJSON() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("error", "Exception");
		job.add("message", "We could not find your schedule. Maybe the url you provided is wrong.");
		return job.build().toString();
	}
	
	//Returns the java error message.
	protected String UnknownError(Exception e){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("error", "Exception");
		job.add("message", e.getMessage());			
		return job.build().toString();
	}

}
