package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {
    //Bu set Up methodu ile request isleminde tekrarli yapilacak islemler burada bir kez yapilacak. @Test oncesi calismasi icin @Before anotasyonu ekliyoruz
    protected RequestSpecification spec;
    @Before//Her tet methodu oncesi calisir
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1/").build();
    }

}
