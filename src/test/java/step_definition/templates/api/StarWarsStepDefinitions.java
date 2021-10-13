package step_definition.templates.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static modules.endpoints.People.
        getPeople;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StarWarsStepDefinitions {
    String requestBuilder = "";
    Response response;

    @Given("I am using resources {string}")
    public void iAmUsingResources(String arg0) {
        requestBuilder = requestBuilder + arg0;
    }

    @And("searching for id {int}")
    public void searchingForId(int arg0) {
        requestBuilder = requestBuilder + "/" + arg0+ "/";
    }

    @When("I send {string} request")
    public void iSendRequest(String arg0) {
        response = getPeople(requestBuilder);
    }

    @Then("I get response code {int}")
    public void iGetResponseCode(int arg0) {
        assertEquals(arg0, response.getStatusCode());
        System.out.println(response.path("name"));
        response.getBody().prettyPrint();
    }
}
