package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_04_PATCH;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PATCH_NONBddStyle {
    //  PUT
    // Pre - Req.
    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;



    @Test
    public void test_patch_non_bdd() {
        String token = "803f8c906f7b17d";
        String bookingid = "331";

        Faker faker = new Faker();

        String name = faker.name().fullName();

        String payload="{\n" +
                "    \"firstname\" : \""+name+"\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);

        r.contentType(ContentType.JSON);
        r.cookie("token", token);
//        r.auth().digest()
        // r.auth().basic()
        r.body(payload).log().all();

        response = r.when().log().all().patch();


        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
