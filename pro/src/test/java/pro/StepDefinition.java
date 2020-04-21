package pro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
//Feature: Client Find Journey
	Client c;
	Journey j = new Journey();
	clientDatabase CD;
	journeyDB JD;
	String searchword;
	String filter;
	ResponseObject searchResponse;
	
@Given("a client {string}")
public void a_client(String client) {
	Client c = new Client(client);
	c.setClient(client);
}

@Given("a client database")
public void a_client_database() {
	CD = c.clientDatabase;
}

//Background

@Given("a journey database with the departing port {string} {string} and {string}")
public void a_journey_database_with_the_departing_port_and(String dp1, String dp2, String dp3) {
	Jou j1 = new Jou(dp1 ,"CPH","Veggies","Netto","JOU00001");
    Jou j2 = new Jou(dp2, "Bey","oil","Total","JOU00002");
    Jou j3 = new Jou(dp3,"NYC","pork","Meat Lovers","JOU00003");
    
    c.journeyDB.registering(dp1);
    c.journeyDB.registering(dp2);
    c.journeyDB.registering(dp3);
    
}

@Given("a searchword {string}")
public void a_searchword(String sword) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("a filter {string}")
public void a_filter(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
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
@Given("a client {string}")

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

@When("Registering")
public void registering() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("the system displays a message confirming the registration")
public void the_system_displays_a_message_confirming_the_registration() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("a new journey id is automaticly generated")
public void a_new_journey_id_is_automaticly_generated() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
//Feature:

@Given("a client {string}")

@Given("a journey database")

@Given("a valid port of origin {string}")

@Given("a valid destination {string}")

@Given("a valid company {string}")

@When("Registering")

@Then("the system displays a message telling that the content needs to be filled")
public void the_system_displays_a_message_telling_that_the_content_needs_to_be_filled() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("a logistic company {string}")
public void a_logistic_company(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("a client database with the client {string}")
public void a_client_database_with_the_client(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("an update choice {string}")
public void an_update_choice(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

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
}
