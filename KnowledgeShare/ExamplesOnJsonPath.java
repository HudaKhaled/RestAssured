package KnowledgeShare;


import files.Payload;
import files.resuableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ExamplesOnJsonPath {
    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://xpress-api.q84sale.com/live/index.php/";
    }


    @Test
    public static void TestExamples() {
        String resp1 = given().log().all().headers("Content-Type", "application/json"
                , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
                , "Connection", "keep-alive", "X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
                , "HMAC-Buster", "BustTheHMAC2!", "Device-Id", "web_user_0000123")
                .body(Payload.getListings())
                .when().post("/V4/MyListings/getListings")
                .then().log().all().extract().response().asString();

        JsonPath responseItems = resuableMethods.rawtoJson(resp1);

        //Get the count of pinned items
        int pinnedItemsCount = responseItems.getInt("response.listings.pinned_items.size()");
        System.out.println("Numbers of pinned items " + pinnedItemsCount);

        // get the title of the second pinned item fl array
        String pinnedItems3 = responseItems.get("response.listings.pinned_items[3].title");
        System.out.println("Title of first pinned items: " +pinnedItems3);

        //get title and id of every pinned items in array .bygeeb el title wel id bta3 kol l pinned items
        for (int i = 0; i < pinnedItemsCount; i++) {
           // int id1=  responseItems.getInt("response.listings.pinned_items["+i+"].id");
            String title1 = responseItems.get("response.listings.pinned_items[" + i + "].title");
            //law msh 3rfa a3ml variable w 23lm print f one line.. bast5dm toString 3shan print expect String argument
            System.out.println(responseItems.get("response.listings.pinned_items[" + i + "].id").toString());

            // System.out.println(id1);
            System.out.println(title1);
        }


        int normalItemsCount = responseItems.getInt("response.listings.normal_items.size()");
        // law 3ayza ageeb title bta3 listing b id mo3yan masln?
        for (int i = 0; i < normalItemsCount; i++) {
            int catID = responseItems.get("response.listings.normal_items[" + i + "].cat_id");
            if (catID == 2160) {
                String x = responseItems.get("response.listings.normal_items[" + i + "].title");
                System.out.println(x);
                break;
            }
        }

    }
}