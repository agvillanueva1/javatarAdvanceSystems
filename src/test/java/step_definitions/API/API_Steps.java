package step_definitions.API;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.CucumberLogUtils;

import java.util.HashMap;
import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;

public class API_Steps {

    String dataId, dataDuration, dataName;
    String resultFirstName, resultLastName, resultEmailAddress, token, errorMessage;

    Response response;
    final String BASEURI = ConfigReader.readProperty("baseURI");
    final String DEVCOURSES = ConfigReader.readProperty("endPointDevCourses");
    final String SDETCOURSES = ConfigReader.readProperty("endPointSDETCourses");
    final String STUDENTS = ConfigReader.readProperty("endPointStudents");
    final String ADMIN = ConfigReader.readProperty("endPointAdminInfoDb");
    final String BEARERTOKEN = ConfigReader.readProperty("bearerToken");





    @Given("I send a request to url")
    public void i_send_a_request_to_url() {
        RestAssured.baseURI = BASEURI;
    }

    @Then("Verify I can retrieve SDET courses database with status code {string}")
    public void verify_i_can_retrieve_sdet_courses_database_with_status_code(String statusCode) {
        Response response = RestAssured.given()
                .when()
                .get(SDETCOURSES)
                .then()
                .extract()
                .response();

        String log = "API Endpoint: " + SDETCOURSES + ". " +
                "Expected Status: " + SC_OK + ". " +
                "Response Status: " + response.statusCode();
        CucumberLogUtils.logInfo(log, "false");
        Assert.assertEquals(String.valueOf(response.statusCode()), statusCode);


    }

    @Then("Verify I can retrieve Dev courses database with status code {string}")
    public void verify_i_can_retrieve_dev_courses_database_with_status_code(String statusCode) {
        response = RestAssured.given()
                .get(DEVCOURSES)
                .then()
                .statusCode(SC_OK)
                .log().all()
                .extract()
                .response();

        String log = "API Endpoint: " + SDETCOURSES + ". " +
                "Expected Status: " + SC_OK + ". " +
                "Response Status: " + response.statusCode();
        CucumberLogUtils.logInfo(log, "false");
        Assert.assertEquals(String.valueOf(response.statusCode()), statusCode);
    }

    @Then("Verify Response Body Contains {string}, {string}, and {string}")
    public void verify_response_body_contains_and(String id, String duration, String name) {

        dataId = response.jsonPath().getString("data._" + id + "[0]");
        dataDuration = response.jsonPath().getString("data." + duration + "[0]");
        dataName = response.jsonPath().getString("data." + name + "[0]");

        String log = "ID: " + dataId + ". " +
                "Duration: " + dataDuration + ". " +
                "Name: " + dataName;
        CucumberLogUtils.logInfo(log, "false");

        Assert.assertTrue(id.length() > 0);
        Assert.assertTrue(duration.length() > 0);
        Assert.assertTrue(name.length() > 0);
    }

    @Then("Verify I can retrieve admin info database with status code {string}")
    public void verifyICanRetrieveAdminInfoDatabaseWithStatusCode(String statusCode) {
        response = RestAssured.given()
                .get(ADMIN)
                .then()
                .statusCode(SC_OK)
                .log().all()
                .extract()
                .response();

        String log = "API Endpoint: " + ADMIN + ". " +
                "Expected Status: " + SC_OK + ". " +
                "Response Status: " + response.statusCode();
        CucumberLogUtils.logInfo(log, "false");
        Assert.assertEquals(String.valueOf(response.statusCode()), statusCode);

    }

    @Then("Verify Admins Info DB Response Body Contains {string}, {string}, and {string}")
    public void verifyAdminsInfoDBResponseBodyContainsAnd(String firstName, String lastName, String email) {
        resultFirstName = response.jsonPath().getString("data." + firstName + "[1]");
        resultLastName = response.jsonPath().getString("data." + lastName + "[1]");
        resultEmailAddress = response.jsonPath().getString("data." + email + "[1]");

        String log = "First Name: " + resultFirstName + ". " +
                "Last Name: " + resultLastName + ". " +
                "Email: " + resultEmailAddress;
        CucumberLogUtils.logInfo(log, "false");

        Assert.assertTrue(firstName.length() > 0);
        Assert.assertTrue(lastName.length() > 0);
        Assert.assertTrue(email.length() > 0);
    }

    @When("User adds basic auth with username {string} and password {string}")
    public void userAddsBasicAuthWithUsernameAndPassword(String userName, String passWord) {
        Map<String, String> map = new HashMap<>();
        map.put("username", userName);
        map.put("password", passWord);
    }

    @And("User send GET request to the endpoint {string}")
    public void userSendGETRequestToTheEndpoint(String token) {
        response = RestAssured.given()
                .auth().preemptive().basic("user", "user123")
                .when()
                .get(token)
                .prettyPeek()
                .then()
                .extract()
                .response();
    }

    @Then("response should contain a token {string}")
    public void responseShouldContainAToken(String bearerToken) {
        token = response.jsonPath().getString(bearerToken);

        String log = "Token: " + token + ". ";
        CucumberLogUtils.logInfo(log, "false");

        Assert.assertTrue(bearerToken.length() > 0);
    }

    @Then("User adds new {string} and {string} to the endpoint {string}")
    public void userAddsNewAndToTheEndpoint(String name, String duration, String endpoint) {
        Map<String, String> Map = new HashMap<>();
        Map.put("name", name);
        Map.put("duration", duration);

        response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(Map)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @And("User should get status code {int}")
    public void userShouldGetStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }
}


