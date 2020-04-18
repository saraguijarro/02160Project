
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

//Feature: Add measurements about the container’s internal status
	LogisticCompany company;
	currentInternalStatus currentStatus;
	Container container = new Container();
	UpdateData modifyData;
	
	
	//Scenario: Update measurements about the container’s internal status
	
	@Given("a journey id {string} exists for the corresponding container")
	public void a_journey_id_exists_for_the_corresponding_container(String journeyID) {
		assertEquals(container.hasId(container),true);
	}
	
	@When("the logistic company {string} wants to add measurements to the internal status")
	public void the_logistic_company_wants_to_add_measurements_to_the_internal_status(String company) {
		modifyData = currentInternalStatus.update(measurement);
	}
	
	@Then ("the system sets the internal status to the latests measurements") {
		assertEquals("Measurement succesfully updated.",modifyData.getMeasurement());
	}
}
