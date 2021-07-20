package KnowledgeShare;

import files.Payload;
import groovyjarjarpicocli.CommandLine;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class savelistingUsingSpecBuilder  {

    @Test
    public static void saveListing() {


        //   new RequestSpecBuilder().setBaseUri("https://xpress-api.q84sale.com/live/index.php/");

        given().spec(SpecBuilder.requestSpec).log().all()
                .body(Payload.saveListings("2160", "hudarestasssured", "hudarestasssured"))
                .when().post("/V4/MyListings/saveListing")
                .then().log().all().assertThat().statusCode(200);

    }
}
