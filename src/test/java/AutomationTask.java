import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AutomationTask {

    @Test
    void Test1(){

      Response response = get("https://gorest.co.in/public/v2/users");
        System.out.println("Response : "+ response.asString());
        System.out.println("Status code" +response.getStatusCode());
        System.out.println("Response : " + response.getBody().asString());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }



    @Test
    public void Post(){
        Response response = get("https://gorest.co.in/public/v2/users");
        //System.out.println("Status code" +response.getStatusCode());
        JSONObject request = new JSONObject();
        request.put("name","Ms. Kanti Pandey");
        request.put("email","pandey_kanti_ms@reilly.io");
        request.put("Gender","male");
        request.put("status","inactive");


        System.out.println(request.toJSONString());


    }

    @Test
   public void Posttwo(){
        Response response = get("https://gorest.co.in/public/v2/users");
        System.out.println("Status code" +response.getStatusCode());
        JSONObject request = new JSONObject();
        request.put("name","Preity Arora MD");
        request.put("email","arora_md_preity@hamill.org");
        request.put("Gender","female");
        request.put("status","inactive");
        request.put("id",3542);

        System.out.println(request.toJSONString());

    }

    @Test
    public void Postthree(){
        Response response = get("https://gorest.co.in/public/v2/users");
        System.out.println("Status code" +response.getStatusCode());
        JSONObject request = new JSONObject();
        request.put("name","Sen. Gitanjali Mehra");
        request.put("email","sen_mehra_gitanjali@williamson.co");
        request.put("Gender","male");
        request.put("status","inactive");
        request.put("id",3540);

        System.out.println(request.toJSONString());

    }

    @Test
    public void Put(){
        //Response response = get("https://gorest.co.in/public/v2/users");
        //System.out.println("Status code" +response.getStatusCode());
        JSONObject request = new JSONObject();
        request.put("name","Sen. Gitanjali Mehra");
        request.put("email","sen_mehra_gitanjali@williamson.co");
        request.put("Gender","female");
        request.put("status","inactive");
        request.put("id",3540);
        request.put("body","Commodi soluta qui. Laboriosam voluptas saepe. Quia maxime similique. Occaecati quod nobis");
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","aplication/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://gorest.co.in/public/v2/comments").
                then().
                statusCode(201)
                .log().all();


    }

    @Test
    public void Delete(){

        Response response = get("https://gorest.co.in/public/v2");

        when().
                delete("/todos").
                then().statusCode(204)
                .log().all();




    }

    //I know my codes are not working I tried so hard to understand why but I didn't find the problem,I tried every thing
    //We didn't learn this in class so this is just my hard effort to solve this task but in this moment I can't.


}

