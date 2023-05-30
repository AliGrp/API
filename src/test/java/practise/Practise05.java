package practise;

import base_urls.RegresInAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class Practise05 extends RegresInAppBaseUrl {
    @Test
    public void test01() {
          /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

            spec.pathParam("first","unknown");
            Response response = given().spec(spec).when().get("/{first}");
            response.prettyPrint();

            response.
                    then().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    body("data",hasSize(6));


//        1)Status code is 200
            response.then().assertThat().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        List<String> pantone_value= jsonPath.getList("data.pantone_value");
        System.out.println("pantone_value = " + pantone_value);

        List<Integer> id_list= jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("id_list = " + id_list);
        Assert.assertEquals(3,id_list.size());

        List<Integer> id_list1= jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("id_list1 = " + id_list1);
        Assert.assertEquals(2,id_list1.size());

        }
}
