package Utils.Common;
import Utils.Common.Helper.ReadProperties;
import Utils.Common.globalConstants.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Restutils {
   static RequestSpecBuilder requestSpecBuilder;
   static RequestSpecification requestSpecification;
   static Response response;
   static String env="";
    public static Restutils init() throws Exception {
       return new Restutils();
    }
    public  Restutils() throws Exception {
        initializeRequestSpec();
    }
    public void initializeRequestSpec() throws Exception {
        requestSpecBuilder=new RequestSpecBuilder();
        env=System.getProperty("env");
        switch (env)
        {
            case "QA":
                requestSpecBuilder.setBaseUri(ReadProperties.init().getProperties("baseUrl"))
                        .setBasePath(Endpoints.endpoints);
                break;
            case "Stage":
                requestSpecBuilder.setBaseUri(ReadProperties.init().getProperties("baseUrl"));
                break;
            case "Production" :
                requestSpecBuilder.setBaseUri(ReadProperties.init().getProperties("baseUrl"));
                break;
            default:
                requestSpecBuilder.setBaseUri(ReadProperties.init().getProperties("baseUrl"))
                        .setBasePath(Endpoints.endpoints);
                break;

        }

    }
    public Restutils setPath(String path)
    {
        requestSpecBuilder.setBasePath(path);
        return this;
    }
    public Restutils setBody(Object body)
    {
        requestSpecBuilder.setBody(body);
        return this;
    }
    public Restutils setBody(String body)
    {
        requestSpecBuilder.setBody(body);
        return this;
    }
    public Restutils pathParam(String key, String value) {
        requestSpecBuilder.addPathParams(key,value);
        return this;
    }
    public Restutils contentType()
    {
        requestSpecBuilder.setContentType(ContentType.JSON);
        return this;
    }
    public Restutils header(Map<String,String> header)
    {
        requestSpecBuilder.addHeaders(header);
        return this;
    }
    public Restutils params(String key,String value)
    {
        requestSpecBuilder.addParam(key,value);
        return this;
    }
    public Restutils get()
    {
        requestSpecification=requestSpecBuilder.build();
            response= given()
                    .filter(new AllureRestAssured())
                    .spec(requestSpecification)
                    .when().get()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .and()
                    .extract().response();
            return this;
    }
    public Restutils post()
    {
        requestSpecification=requestSpecBuilder.build();
        response= given().filter(new AllureRestAssured())
                .spec(requestSpecification)
                .when().post()
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .and()
                .extract().response();
        return this;

    }
    public Response getResponse()
    {
        return response;
    }
}
