package KnowledgeShare;

import files.Payload;
import files.resuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class STARTListingJsonPath {

    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://xpress-api.q84sale.com/live/index.php/";
    }


    @Test //(dataProvider="listingData")
    public static void saveListing1() throws InterruptedException {



//SaveListings
        String res = given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!")
                .body(Payload.saveListings1())
                .when().post("/V4/MyListings/saveListing")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath advID = resuableMethods.rawtoJson(res);
        String id = advID.get("response.adv_id");
        System.out.println(id);


//editListing
        String newtitleinEdit = "title from office";
        given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale.web aaaa bbbb"
                , "HMAC-Buster", "BustTheHMAC2!")
                .body(Payload.editListings(id, newtitleinEdit))
                .when().post("V4/MyListings/editListing")
                .then().log().all().assertThat().statusCode(200);



//getListingDetails
        String resp = given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!")
                .body(Payload.getListingDetails(id))
                .when().post("/V4/Listings/getListingDetails")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath checktitleAFterEdit = resuableMethods.rawtoJson(resp);
        String checktitleAFterEdit1= checktitleAFterEdit.getString("response.title");
        System.out.println(checktitleAFterEdit1);

        Assert.assertEquals(checktitleAFterEdit1, newtitleinEdit);


        //DeleteListing
// leeh f postman msh lazem 2a70t device id w hena lazem???
        given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!", "Device-Id","web_user_00000123")
                .body(Payload.SellListings(id))
                .when().post("V4/MyListings/sellListing")
                .then().log().all().assertThat().statusCode(200).body("response.is_sold", equalTo(1));

Thread.sleep(3000);
//todo ASK KHALID EZAY BYGEEB HENA DETAILS W HOWA MAMSOO7 3AL POSTMAN?? check custom authorization
        //get listingtany 3shan at2akd eno msh mawgood
      given().log().all().headers("Content-Type", "application/json"
               , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
            , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1552896005 ff6bc83348f1bdd9fd93d9bdc9eb0dabf3ce765c"
        , "HMAC-Buster", "BustTheHMAC2!","Device-Id","web_user_00000123")
             .body(Payload.getListingDetails(id))
               .when().post("/V4/Listings/getListingDetails")
              .then().log().all().assertThat().statusCode(200).body("error.message_en", equalTo("No Records Found. Your Request Returned an Empty Result Set."));

    }
}