package step_definitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ConfigReader;
import utils.CucumberLogUtils;

import static org.apache.http.HttpStatus.SC_OK;

public class API_Steps {

    String dataId, dataDuration, dataName;
    Response response;
    final String BASEURI = ConfigReader.readProperty("baseURI");
    final String DEVCOURSES = ConfigReader.readProperty("endPointDevCourses");
    final String SDETCOURSES = ConfigReader.readProperty("endPointSDETCourses");
    final String STUDENTS = ConfigReader.readProperty("endPointStudents");


    @Given("I send a request to url")
    public void i_send_a_request_to_url() {
        RestAssured.baseURI = BASEURI;
    }

    @Then("Verify I can retrieve SDET courses database with status code {int}")
    public void verify_i_can_retrieve_sdet_courses_database_with_status_code(Integer int1) {
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
        Assert.assertEquals(String.valueOf(response.statusCode()), "200");


    }

    @Then("Verify I can retrieve Dev courses database with status code {int}")
    public void verify_i_can_retrieve_dev_courses_database_with_status_code(Integer int1) {
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
        Assert.assertEquals(String.valueOf(response.statusCode()), "200");
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

}
