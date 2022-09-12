package com.soptionssix.api.dto;

import com.soptionssix.data.document.User;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserDto {

    @NotNull
    private final String id;
    private final String nickName;
    private final String phone;

    private UserDto(User user) {
        this.id = user.getId();
        this.nickName = user.getNickName();
        this.phone = user.getPhone();
    }

    public static UserDto of(User user) {
        return new UserDto(user);
    }
}
