package Service.UserService;

import Service.UserService.UserServiceDto.UserDto;
import Utils.Common.Helper.ReadFilesUtils;
import Utils.Common.Restutils;
import Utils.Common.globalConstants.Endpoints;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.DataProvider;

import javax.naming.event.ObjectChangeListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public void getUser() throws Exception {
        Map<String,String> header=new HashMap<>();
        header.put("Accept","Application/json");
        Restutils restutils=Restutils.init()
                .header(header)
                .contentType()
                .params("page","2")
                .get();
    }
    @Step("Create user data")
    public void addUser(UserDto userDto) throws Exception {
       Restutils postResponse= Restutils.init()
                .setBody(userDto)
                .contentType()
                .setPath(Endpoints.users)
                .post();
    }


}
