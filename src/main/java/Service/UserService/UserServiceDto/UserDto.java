package Service.UserService.UserServiceDto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}
