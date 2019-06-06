package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import iotalarm.service.TestModesService;

@Path("testmode")
public class TestModesResource extends BasicResource{
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
	
	@POST
	@Produces("application/json")
	public String setTravelTime(){
		try {
			service.flipTestModes();
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("succes", true);
			job.add("result", service.getTestModes());
			return job.build().toString();
			}
		catch (Exception e){
			return UnknownError(e);
			}
		}
	}
