package UserService;

import Models.UserServiceResponseData.PostResponseData;
import Service.UserService.UserServiceDto.UserDto;
import Utils.Common.Helper.ReadFilesUtils;
import Utils.Common.Restutils;
import com.google.gson.reflect.TypeToken;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Listeners(Utils.Common.Listeners.Listeners.class)
public class Users {
    String data;
    {
        try {
            data = new String(Files.readAllBytes(Paths.get("src/test/java/UserService/TestData/UserData.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Restutils restutils=new Restutils();
    ReadFilesUtils readFilesUtils=new ReadFilesUtils();
    public Users() throws Exception {
    }

   @Test
    @Severity(SeverityLevel.BLOCKER)
    public void getData() throws Exception {
       // String payload=readFilesUtils.getData(data);
       Response response= restutils.init()
                .contentType()
                .params("page","2")
                .get()
                .getResponse();
        String responseData=response.prettyPrint();
        Assert.assertEquals(response.statusCode(),400,"passed");
    }
    @Test(dataProvider = "post user data",dataProviderClass =Users.class)
    public void createUser(UserDto userDto) throws Exception {
        userDto.setJob("Engineer");
        userDto.setName("Abhishek");
        Response response= restutils.init()
                .contentType()
                .setBody(userDto)
                .post()
                .getResponse();
        String userData=response.prettyPrint();
        PostResponseData responseData=ReadFilesUtils.fromJsonToObject(userData,PostResponseData.class);
        Assert.assertEquals(responseData.getName(),userDto.getName(),"Mis matched");
    }
    @DataProvider(name = "post user data")
    public Object[][] userPostData()
    {
        List<UserDto> datas= ReadFilesUtils.fromJson(data,new TypeToken<List<UserDto>>(){}.getType());
        Object[][] userData=new Object[datas.size()][];
        for (int i=0;i<userData.length;i++)
        {
            userData[i]=new Object[]{datas.get(i)};
        }
        return userData;
    }


}
