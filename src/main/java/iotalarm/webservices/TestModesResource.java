package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import iotalarm.service.TestModesService;
import iotalarm.service.TravelTimeService;

public class TestModesResource {

	@Path("testmodes")
	public class TravelTimeResource extends BasicResource{
		private TestModesService service = new TestModesService();
		@GET
		@Produces("application/json")
		public String getTestModes() {
			try {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("testmodes", service.getTestModes());
				return job.build().toString();
			}
		catch(Exception e) {
			return NotFoundJSON();
		}}
		
		@Path("flip")
		@POST
		@Produces("application/json")
		public String setTravelTime(){
			try {
				service.flipTestModes();
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("succes", true);
				return job.build().toString();
			}
			catch (Exception e){
				return UnknownError(e);
			}
		}
	}
}
