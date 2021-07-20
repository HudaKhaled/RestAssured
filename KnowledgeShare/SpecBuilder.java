package KnowledgeShare;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;


public class SpecBuilder {

    public static RequestSpecification requestSpec;

    @BeforeMethod
    public static void specSpec() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://xpress-api.q84sale.com/live/index.php/");
        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("Accept", "*/*");
        builder.addHeader("Accept-Encoding", "gzip, deflate, br");
        builder.addHeader("Connection", "keep-alive");
        builder.addHeader("X-Custom-Authorization", "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8");
        builder.addHeader("HMAC-Buster", "BustTheHMAC2!");
        builder.addHeader("Device-id", "web_user_00000965");

        requestSpec = builder.build();
    }



   @BeforeMethod
    public static void specSpec1() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://xpress-api.q84sale.com/live/index.php/");
        requestSpecification.header("Content-Type", "application/json");

        RequestSpecification requestSpecification1 = RestAssured.given()
                .baseUri("https://xpress-api.q84sale.com/live/index.php/")
                .header("Content-Type", "application/json");

    }

}