package api_tests.okhttptests;

import dto.*;
import interfaces.Base_Api;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class AddNewCarTestsOkHttp implements Base_Api {

    TokenDto token;
    @BeforeClass
    public void login(){
        RegistrationBodyDto bodyDto = RegistrationBodyDto.builder()
                .username("margo@gmail.com").password("Mmar123456$").build();

        RequestBody requestBody = RequestBody.create(GSON.toJson(bodyDto),JSON);

        Request request = new Request.Builder()
                .url(BASE_URL+LOG_URL)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            token = GSON.fromJson(response.body().string(), TokenDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(token);
    }

    @Test
    public void addNewCarPositiveTest(){

        int i = new Random().nextInt(1000)+1000;

        CarDto car = CarDto.builder()
                .serialNumber("145-"+i)
                .manufacture("Toyota")
                .model("Ist")
                .year("2020")
                .fuel(Fuel.DIESEL.getFuel())
                .seats(4)
                .carClass("A")
                .pricePerDay(100.00)
                .city("Haifa").build();

        RequestBody requestBody = RequestBody.create(GSON.toJson(car),JSON);

        Request request = new Request.Builder()
                .url(BASE_URL+ADD_NEW_CAR)
                .addHeader("Authorization", token.getAccessToken())
                .post(requestBody)
                .build();

        Response response;
        String responseBody;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (response.code() ==200){
            try {
                responseBody=response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ResponseMessageDto responseMessageDto = GSON.fromJson(responseBody,ResponseMessageDto.class);
            System.out.println(responseMessageDto);
            Assert.assertEquals(responseMessageDto.getMessage(),"Car added successfully");
        }else
            Assert.fail("Error, response code---> "+response.code());
        Assert.assertTrue(response.isSuccessful());
    }
}
