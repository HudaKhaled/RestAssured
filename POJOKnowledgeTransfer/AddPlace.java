package POJOKnowledgeTransfer;

import files.Payload;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import POJOKnowledgeTransfer.*;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace {

    @Test
    public static void SerAddPlace() {
        AddPlacePOJO p = new AddPlacePOJO();
        p.setAccuracy(100);
        p.setAddress("6 october");
        p.setLanguage("3araby");
        p.setName("Huda Khaled");
        p.setPhone_number("01005498469");
        p.setWebsite("4sale.com");

        LocationPOJO l = new LocationPOJO();
        l.setLat(12);
        l.setLng(13);
        p.setLocation(l);
        ArrayList <String> list = new ArrayList<String>();
        list.add("abc");
        list.add("xyz");
         p.setTypes(list);


        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String addPlaceResponse = given().log().all().queryParam("key", "qaclick123") // this log is for the input
                .header("Content-Type", "application/json")
                .body(p)
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))// this log is for the output
                .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();
    }
}
