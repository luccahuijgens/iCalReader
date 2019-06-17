/* ClassTitle: TravelTimeResource
 * Description: This class is responsible for handling requests regarding the travel time.
 * Its main purpose is to retrieve and set the current travel time.
 * Uses: BasicResource, TravelTimeService
 */

package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iotalarm.service.TravelTimeService;

@Path("timeoffset")
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
	
	@PUT
	@Produces("application/json")
	// The traveltime value is used as
	public String setTravelTime(@FormParam("traveltime") int traveltime){
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
