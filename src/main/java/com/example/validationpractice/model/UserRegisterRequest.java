package com.example.validationpractice.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    //    @NotBlank
    private String name;

    private String nickName;

    @NotBlank
    @Size(min = 1, max = 12)
    private String password;


    @NotNull
    @Max(100)
    @Min(1)
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name 또는 nick_name은 반드시 1개 이상 존재해야 합니다.")
    public boolean isNameCheck() {
        if (Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }
        if (Objects.nonNull(nickName) && !nickName.isBlank()) {
            return true;
        }

        return false;
    }




}
