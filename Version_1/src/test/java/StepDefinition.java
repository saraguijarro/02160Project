
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
//Feature: register client
	Client client = new Client();
	ClientDatabase CD;
	ResponseObject registerResponse;
	LogisticCompany company;
	
	//Background
	
	@Given("a logistic company {string}")
	public void a_logistic_company(String name) {
		company = new LogisticCompany();
		company.setName(name);
	}
	
	@Given("a client database")
	public void a_client_database() {
		CD = company.clientDatabase;
	}
	
	//Scenario 1: all correct info
		
	@Given("a valid client name {string}")
	public void a_valid_client_name(String name) {
	    client.setName(name);
	}

	@Given("a valid address: {string}, {string}, {string}, {string}, {string}")
	public void a_valid_address(String country, String city, String postcode, String streetname, String streetnumber ) {
	    Address address = new Address(country,city,postcode,streetname,streetnumber);
	    client.setAddress(address);
	}

	@Given("a valid reference person {string}")
	public void a_valid_reference_person(String referencePerson) {
	    client.setReferencePerson(referencePerson);
	}

	@Given("a valid email {string}")
	public void a_valid_email(String email) {
	    client.setEmail(email);
	}

	@When("Registering in {string}")
	public void registering(String database) {
		if (database.equals("client database")) {
			registerResponse = CD.registering(client);
		}
		else if (database.equals("journey database")) {
			
		}
	    
	}

	@Then("the system displays a message confirming the registration of client") //code 100
	public void the_system_displays_a_message_confirming_the_registration_of_client() {
	    assertEquals("Client succesfully registered.", registerResponse.getMessage());
	}

	@Then("a new client id is automaticly generated")
	public void a_new_client_id_is_automaticly_generated() {
	    assertEquals(client.getHasID(),true);
	}
	
	//Scenario 2 - missing info
	@Then("the system displays a message confirming the registration and indicating the missing fields") //code 101
	public void the_system_displays_a_message_confirming_the_registration_and_indicating_the_missing_fields() {
		 assertEquals("Client registered, but some or all fields are missing.", registerResponse.getMessage());
	}
	
	//Scenario 3 - missing name
	@Then("the system displays a message telling that the client needs a name")
	public void the_system_displays_a_message_telling_that_the_client_needs_a_name() {
		assertEquals("Clients needs a name to be registered, no changes were made!", registerResponse.getMessage());
	}
	
	//Scenario 4 - already registered
	@Then("the system displays a message telling that the client is already registered")
	public void the_system_displays_a_message_telling_that_the_client_is_already_registered() {
		assertEquals("Client with the same name already registered, no changes were made!", registerResponse.getMessage());
	}

//Feature: client update client info
	
	String updateChoice;
	String updateContent;
	ResponseObject updateResponse;
	Client client2 = new Client();
		
	//Background:
	@Given("a client database with the client {string}")
	public void a_client_database_with_the_client(String name) {
	    
		CD = company.clientDatabase;
		
		Client c= new Client();
	    c.setName(name);
	    
	    CD.registering(c);  
	}

	//Scenario 1: The client updates a piece of information that can be changed

	@Given("an update choice {string}")
	public void an_update_choice(String Choice) {
	    updateChoice = Choice;
	}

	@When("Update client information")
	public void update_client_information() {
	    updateResponse = client.update(updateChoice, updateContent);
	}

	@Then("the client information is updated")
	public void the_client_information_is_updated() {
		assertEquals("Client information succesfully updated", updateResponse.getMessage());

	}

//Feature: Company find client
		
	String searchword;
	String filter;
	ResponseObject searchResponse;
	
	//Background
	@Given("a client database with the client {string} {string} {string} and {string}")
	public void a_client_database_with_the_client_and(String name1, String name2, String name3, String name4) {
	    Client c1 = new Client(name1, new Address("Denmark","Lyngby","2800","Fysikvej","315A"),"Oskar","sara@student.du.dk");
	    Client c2 = new Client(name2, new Address("Denmark","Lyngby","2800","Kampsax","30"),"None","mihai@student.dtu.dk");
	    Client c3 = new Client(name3, new Address("Denmark","Lyngby","2800","Fysikvej","315A"),"Sammy","thomas@student.dtu.dk");
	    Client c4 = new Client(name4, new Address("Denmark","Lyngby","2800","Kampsax","48"), "Suzan", "miguel@student.dtu.dk");
	    
	    company.clientDatabase.registering(c1);
	    company.clientDatabase.registering(c2);
	    company.clientDatabase.registering(c3);
	    company.clientDatabase.registering(c4);
	}

	
	//Scenario 1: The company uses the criteria from an existing client without filter
	//Scenario 2: no matches
	@Given("a searchword {string}")
	public void a_searchword(String word) {
	    searchword = word;
	}

	@Given("a filter {string}")
	public void a_filter(String filt) {
	    filter = filt;
	}

	@When("searching for client")
	public void searching_for_client() {
	    searchResponse=company.clientDatabase.resultSearchClient(searchword, filter);
	}

	@Then("the corresponding {string} client\\(s) is\\/are found.")
	public void the_corresponding_client_s_is_are_found(String expectedClients) {
		assertEquals(expectedClients+" clients found with the searchword: ["+searchword+"] and the filter: ["+filter+"]", searchResponse.getMessage());
	}
	
	
	
// JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY	
// JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY	
// JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY	
// JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY	
// JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY JOURNEY	
	
	
	
	//Feature: Client Find Journey
		
		Jou j = new Jou();
		//ClientDatabase CD;
		journeyDB JD;
		
	@Given("a client {string}")
	public void a_client(String name) {
		client.setName(name);
	}


	//Background

	
	@Given("a journey database with the departing port {string} {string} and {string}")
	public void a_journey_database_with_the_departing_port_and(String dp1, String dp2, String dp3) {
		Jou j1 = new Jou(dp1 ,"CPH","Veggies","Netto","JOU00001");
	    Jou j2 = new Jou(dp2, "Bey","oil","Total","JOU00002");
	    Jou j3 = new Jou(dp3,"NYC","pork","Meat Lovers","JOU00003");
	    
	    
	}

	@When("searching for journey")
	public void searching_for_journey() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the corresponding journey is\\/are found.")
	public void the_corresponding_journey_is_are_found() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	//Feature:
	//@Given("a client {string}")

	@Given("a journey database")
	public void a_journey_database() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a valid port of origin {string}")
	public void a_valid_port_of_origin(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a valid destination {string}")
	public void a_valid_destination(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a valid content {string}")
	public void a_valid_content(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a valid company {string}")
	public void a_valid_company(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	/*
	@When("Registering")
	public void registering() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	*/

	@Then("the system displays a message confirming the registration of journey")
	public void the_system_displays_a_message_confirming_the_registration_of_journey() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a new journey id is automaticly generated")
	public void a_new_journey_id_is_automaticly_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	//Feature:

	/*
	@Given("a client {string}")

	@Given("a journey database")

	@Given("a valid port of origin {string}")

	@Given("a valid destination {string}")

	@Given("a valid company {string}")

	@When("Registering")
	*/

	@Then("the system displays a message telling that the content needs to be filled")
	public void the_system_displays_a_message_telling_that_the_content_needs_to_be_filled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	/*
	@Given("a logistic company {string}")
	public void a_logistic_company(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	*/

	/*
	@Given("a client database with the client {string}")
	public void a_client_database_with_the_client(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
	/*
	@Given("an update choice {string}")
	public void an_update_choice(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

	@When("Update journey information")
	public void update_journey_information() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the journey information is updated")
	public void the_journey_information_is_updated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//Mandatory 3 and Optional 1 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//Feature: Add measurements about the container’s internal status
	ContainerCurrent currentStatus;
	Container container = new Container();
	String dataChoice;
	int updateData;
	UpdateData modifyData;
		
	//Scenario: Update measurements about the container’s internal status
		
	@Given("a journey id {string} exists for the corresponding container")
	public void a_journey_id_exists_for_the_corresponding_container(String journeyID) {
		assertEquals(container.hasId(container),true);
	}
		
	@Given("an update choice {string}")
	public void an_update_choice(String Choice) {
	    dataChoice = Choice;
	}
		
	@When("the logistic company {string} wants to add measurements to the internal status")
	public void the_logistic_company_wants_to_add_measurements_to_the_internal_status(String company) {
		modifyData = company.update(dataChoice,updateData);
	}
		
	@Then ("the system sets the internal status to the latests measurements") 
	public void the_system_sets_the_internal_status_to_the_latests_measurements() {
		assertEquals("Measurement succesfully added.",modifyData);
	}
		
		
//Feature: Retrieve measurements about the container’s internal status
	UpdateData retrieveData;
	Client client3 = new Client();
		
	//Scenario: Retrieve measurements from the system
	
	/* @Given("a journey id {string} exists for the corresponding container") *///////////////////////////////////////////////
		
	/* @Given("an update choice {string}") */////////////////////////////////////////////////////////////////////////
		
	@Given("the container corresponds to the client {string}")
	public void the_container_corresponds_to_the_client(String client) {
		containerDatabase = /////////////////////////////////////////////////////////////////////////WORK ON THIS WITH THOMAS
	}
		
	@When ("a client {string} wants to retrieve measurements from the internal status")
	public void a_client_wants_to_retrieve_measurements_from_the_internal_status(String client) {
		retrieveData = client.retrieve(dataChoice);
	}
		
	@Then ("these measurements are retrieved from the internal status")
	public void these_measurements_are_retrieved_from_the_internal_status() {
		assertEquals("Measurement succesfully retrieved.",retrieveData);
	}
		
		
//Feature: Track each container
	ContainerHistory internalStatus;
	ContainerHistory containerLocation;
	UpdateData trackData;
	UpdateData locateContainer;
		
	//Scenario: Tracking the internal status
	
	/* @Given ("a journey id {string} exists for the corresponding container") *////////////////////////////////////////////
	@Given("a database exists for the measures of the container’s internal status")
	public void a_database_exists_for_the_measures_of_the_container_internal_status() {
		
	}
		
	@When("the system measures the internal status facts")
	public void the_system_measures_the_internal_facts() {
		trackData = internalStatus.track(dataChoice);
	}
		
	@Then("the system adds the data given to the internal status’ database")
	public void the_system_adds_the_data_given_to_the_internal_status_database() {
		assertEquals("Tracked internal status.",trackData);
	}
		
	//Scenario: Tracking the journey
	
	/* @Given ("a journey id {string} exists for the corresponding container") *////////////////////////////////////////////
		
	@Given("a database exists for the container’s journeys")
	public void a_database_exists_for_the_container_journeys() {
		
	}
		
	@When("the system determines the location of the container")
	public void the_system_determines_the_location_of_the_container() {
		locateContainer = containerLocation.locate(container);
	}
		
	@Then("the system add the location found to the journey’s database")
	public void the_system_add_the_location_found_to_the_journey_database() {
		assertEquals("Tracked location.",containerLocation);
	}
			
	//Scenario: There is no journey id for the tracked container
			
	@Given("the journey id {string} doesn’t exist for the corresponding container")
	public void the_journey_id_does_not_exist_for_the_coresponding_container(String journeyID) {
		
	}
		
	@When("trying to obtain information about the internal status or the journey evolution")
	public void trying_to_obtain_information_about_the_internal_status_or_the_journey_evolution() {
		assertEquals("No journey id has been found for the corresponding container.",container.getMessage());
	}
		
	@Then("the search is unsuccessful")
	public void the_search_is_unsuccessful() {
		assertEquals("Thus the research is unsuccessful.",container.getMessage());
	}

//Feature: Retrieve info about each container
		


	
}
