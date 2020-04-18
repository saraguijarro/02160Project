
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
		modifyData = currentStatus.UpdateData(measurement);
	}
	
	@Then ("the system sets the internal status to the latests measurements") 
	public void the_system_sets_the_internal_status_to_the_latests_measurements() {
		assertEquals("Measurement succesfully added.",modifyData.getMeasurement());
	}
	
//Feature: Retrieve measurements about the container’s internal status
	
	//Scenario: Retrieve measurements from the system
	
	/* @Given a journey id "JO002160" exists for the corresponding container *///////////////////////////////////////////////
	
	
	@Given("the container corresponds to the client {string}")
	public void the_container_corresponds_to_the_client(String client) {
		
	}
	
	@When ("a client {string} wants to retrieve measurements from the internal status")
	public void a_client_wants_to_retrieve_measurements_from_the_internal_status(String client) {
		modifyData = currentStatus.RetrieveData(measurement);
	}
	
	@Then ("these measurements are retrieved from the internal status")
	public void these_measurements_are_retrieved_from_the_internal_status() {
		assertEquals("Measurement succesfully retrieved.",modifyData.getMeasurement());
	}
}
