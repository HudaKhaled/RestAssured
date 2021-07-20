package files;

import io.restassured.http.Headers;
import static io.restassured.RestAssured.given;

public class Payload {

    public static String addPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }


    public static String coursePrice() {

        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}\n" +
                "]\n" +
                "}\n";
    }

//====================================================================================
    public static String saveListings(String catID, String title, String description) {
        return "{\n" +
                "   \n" +
                "    \"region_id\":\"1\",\n" +
                "    \"category_id\": \"" + catID + "\",\n" +
                "    \"districts_ids\":[1],\n" +
                "    \"description\": \"" + description + "\",\n" +
                "    \"title\":\"" + title + "\",\n" +
                "    \"device_id\": \"web_user_00000123\",\n" +
                "    \"extra_info\": {\n" +
                "        \"type\": \"personal\"\n" +
                "    },\n" +
                "    \"images\": [\n" +
                "   \n" +
                "        \"1585660375290150645.jpg\"\n" +
                "    ],\n" +
                "    \"is_draft\": 0,\n" +
                "    \"is_pm_enabled\": 1,\n" +
                "    \"is_voip_enabled\": 1,\n" +
                "    \"language\": \"ar\"\n" +
                "}";
    }

    public static String saveListings1() {
        return "{\n" +
                "   \n" +
                "    \"region_id\":\"1\",\n" +
                "    \"category_id\": \"2160\",\n" +
                "    \"districts_ids\":[1],\n" +
                "    \"description\": \"Huda SaveListings1 in category 2160\",\n" +
                "    \"title\":\"Huda SaveListings1 in category 2160\",\n" +
                "    \"device_id\": \"web_user_00000123\",\n" +
                "    \"extra_info\": {\n" +
                "        \"type\": \"personal\"\n" +
                "    },\n" +
                "    \"images\": [\n" +
                "   \n" +
                "        \"1585660375290150645.jpg\"\n" +
                "    ],\n" +
                "    \"is_draft\": 0,\n" +
                "    \"is_pm_enabled\": 1,\n" +
                "    \"is_voip_enabled\": 1,\n" +
                "    \"language\": \"ar\"\n" +
                "}";
    }


    public static String editListings(String id, String title) {
        return "{\n" +
                "   \"source\":\"4sale-mobile\",\n" +
                "   \"adv_id\":\""+id+"\",\n" +
                "   \"device_id\":\"web_user_00000123\",\n" +
                "   \"region_id\":1,\n" +
                "   \"category_id\": \"788\",\n" +
                "   \"districts_ids\":[2],\n" +
                "   \"plan_id\": \"18\",\n" +
                "   \"title\":\""+title+"\",\n" +
                "   \"description\":\"EditListing the draft ad\",\n" +
                "   \"contact_no\":null,\n" +
                "   \"language\":\"en\",\n" +
                "   \"addons_requested\":[\n" +
                "   ],\n" +
                "   \"extra_attrs\":[\n" +
                "   ],\n" +
                "   \"is_pm_enabled\":1,\n" +
                "   \"is_voip_enabled\":1,\n" +
                "   \"is_draft\":0,\n" +
                "   \"is_anonymous\":false,\n" +
                "   \"attempt_abuse\":0,\n" +
                "   \"geotag_lon\":\"\",\n" +
                "   \"geotag_lat\":\"\",\n" +
                "   \"asking_price\":\"900\",\n" +
                "   \"repost_auto_renew\":false,\n" +
                "   \"do_not_disturb\":0,\n" +
                "   \"images\":[\n" +
                "      \"1591519818196416786.jpg\"\n" +
                "   ],\n" +
                "   \"video_url\":null,\n" +
                "   \"extra_info\":{\n" +
                "      \"type\":\"personal\"\n" +
                "   },\n" +
                "   \"prohibited_keywords\":null\n" +
                "}";

    }

    public static String getListingDetails(String id) {

        return "{\"adv_id\":\""+id+"\",\n" +
                "\"lang\":\"en\"}";

    }

    public static String getListings() {

        return "{\n" +
                "    \"device_id\":\"web_user_00000123\",\n" +
                "    \"lang\":\"en\",\"page\":1,\n" +
                "    \"page_size\":30,\"region_id\":1,\n" +
                "    \"search_string\":\"\",\n" +
                "    \"translation\":\"\"\n" +
                "}\n";

}


public static  String SellListings(String id)
{
    return "{\n" +
            "\"page\" : 1,\n" +
            "\"device_id\" :\"web_user_00000123\",\n" +
            "\"adv_id\": \""+id+"\"\n" +
            "}";
}





    //public static Headers headers() {
    //    return (given().headers("Content-Type", "application/json"
     //           , "Accept", "*/*", "Accept-Encoding", "gzip, deflate, br"
      //          , "Connection", "keep-alive", "X-Custom-Authorization",
        //        "com.forsale.forsale 1479908298 b53f721bb45168da216b3ded50ff847b947e75f8"
      //          , "HMAC-Buster", "BustTheHMAC2!"););


    }


