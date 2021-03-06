/* ClassTitle: TestModeResource
 * Description: This class is responsible for handling requests regarding the testmodes.
 * Its main purpose is to activate the testmodes, replacing the events retrieved through EventResource
 * with a test event that will commence in a few minutes.
 * Uses: BasicResource, TestModeService
 */

package iotalarm.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import iotalarm.service.TestModeService;

@Path("testmode")
public class TestModeResource extends BasicResource{
		private TestModeService service = new TestModeService();
		
	@GET
	@Produces("application/json")
	/* FunctionTitle: getTestMode
	 * Description: This function is responsible for returning the current status of the testmode.
	 * If this fails, it returns the message from the error occured in the API.
	 * Uses: BasicResource.UnknownError, TestModeService.getTestMode
	 */
	public String getTestMode() {
		try {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("testmodes", service.getTestMode());
			return job.build().toString();
			}
		catch(Exception e) {
			return UnknownError(e);
			}}
	
	@PUT
	@Produces("application/json")
	/* FunctionTitle: flipTestTestMode
	 * Description: This function is responsible for "switching" the current status of the testmode.
	 * On a success it returns a positive message and returns the current status of the testmode
	 * On a fail, it returns the message from the error occurred in the API.
	 * Uses: BasicResource.UnknownError, TestModeService.getTestMode, TestModeService.flipTestMode
	 */
	public String setTestMode(){
		try {
			service.flipTestMode();
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("succes", true);
			job.add("result", service.getTestMode());
			return job.build().toString();
			}
		catch (Exception e){
			return UnknownError(e);
			}
		}
	}
