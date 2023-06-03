package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static Utilities.AuthenticationHerOkuApp.generateToken;

public class HerOkuAppBaseUrl {
    //Bu set Up methodu ile request isleminde tekrarli yapilacak islemler burada bir kez yapilacak. @Test oncesi calismasi icin @Before anotasyonu ekliyoruz
    protected RequestSpecification spec;
    @Before//Her tet methodu oncesi calisir
    public void setUp(){
        spec = new RequestSpecBuilder().addHeader("Cookie",generateToken()).setBaseUri("https://restful-booker.herokuapp.com/").build();
    }

}
