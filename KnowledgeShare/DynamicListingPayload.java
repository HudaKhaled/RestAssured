package KnowledgeShare;

import files.Payload;
import files.resuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class DynamicListingPayload {

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://xpress-api.q84sale.com/live/index.php/";
    }


    @Test //(dataProvider="listingData")
    public static void saveListing() {

//SaveListings
        String res = given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!", "Device-id", "web_user_00000965")
                .body(Payload.saveListings("2160", "h1 title", "h1 description"))
                .when().post("/V4/MyListings/saveListing")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
/*
        JsonPath advID = resuableMethods.rawtoJson(res);
        String id = advID.get("response.adv_id");
        System.out.println(id);*/
    }

    /*@DataProvider(name="listingData")

    public Object[][]  getData()

    {
        return new Object[][] {
                {"2164","title1 from script", "desc1"},
                {"2165","title2 from script","desc2"},
                {"2166","title3 from script","desc3"}
        };

    }*/

    @Test //(dataProvider="listingData")
    public static void saveListingWithFile() throws Exception {


        String res = given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!", "Device-id", "web_user_00000965")

                .body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\files\\saveListingFile.json"))))

                .when().post("/V4/MyListings/saveListing")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
/*
        JsonPath advID = resuableMethods.rawtoJson(res);
        String id = advID.get("response.adv_id");
        System.out.println(id);*/
    }
}