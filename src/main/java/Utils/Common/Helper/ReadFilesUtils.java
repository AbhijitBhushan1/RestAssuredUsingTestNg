package Utils.Common.Helper;

import Service.UserService.UserServiceDto.UserDto;
import Utils.Common.Restutils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFilesUtils {
   static Gson gson = new Gson();
    String payload="";

    public String getData(String filename) {
        try {
             payload = new String(Files.readAllBytes(Paths.get(filename)));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return payload;
    }
    public static <T> T fromJsonToObject(String responseData,Class<T> tClass) throws Exception {
       return gson.fromJson(responseData,tClass);
    }
    public static <T> T fromJson(String jsonData,Type typeToken) {
        return gson.fromJson(jsonData, (Type) typeToken);
    }
}
