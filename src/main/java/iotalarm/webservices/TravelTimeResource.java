package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import iotalarm.service.TravelTimeService;

@Path("traveltime")
public class TravelTimeResource extends BasicResource{
	private TravelTimeService service = new TravelTimeService();

	@GET
	@Produces("application/json")
	public String getTravelTime() {
		try {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("traveltime", service.getTravelTime()*60);
			return job.build().toString();
		}
	catch(Exception e) {
		return NotFoundJSON();
	}}
	
	@Path("set")
	@POST
	@Produces("application/json")
	public String setTravelTime(@HeaderParam("traveltime") int traveltime){
		try {
			service.setTravelTime(traveltime);
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("succes", true);
			return job.build().toString();
		}
		catch (Exception e){
			return UnknownError(e);
		}
	}
}
