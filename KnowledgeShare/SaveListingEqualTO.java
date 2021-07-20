package KnowledgeShare;

import files.Payload;
import files.resuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import javax.swing.*;

import static io.restassured.RestAssured.*;


public class SaveListingEqualTO {

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://xpress-api.q84sale.com/live/index.php/";
    }


    @Test //(dataProvider="listingData")
    public static void saveListing() {

       given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!", "Device-id", "web_user_00000965")
                .body(Payload.saveListings1())
                .when().post("/V4/MyListings/saveListing")
                .then().log().all().assertThat().statusCode(200).body("response.is_paid", equalTo(1))
       .header("Server","Apache/2.4.18 (Ubuntu)");
    }
}