package by.shylau.salerno.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserRequest {

    @NotBlank(message = "{errors.user.name_is_blank}")
    @Size(min = 3, max = 30, message = "{errors.user.invalid_name_size}")
    private String name;

    @NotBlank(message = "{errors.user.lastname_is_blank}")
    @Size(min = 3, max = 40, message = "{errors.user.invalid_lastname_size}")
    private String lastname;

    @Min(value = 16)
    @Max(value = 80)
    @NotNull
    private Integer age;

//    @Positive
    @Size(max = 50, message = "{errors.user.email_is_blank}")
    @NotBlank(message = "{errors.user.email_is_blank}")
    @Email(message = "{errors.user.email_is_incorrect}")
    private String email;

    @Pattern(regexp = "^(\\+995\\d{9})|(\\+48\\d{9})|(\\+375\\d{9})|(\\+380\\d{9})|(\\+7\\d{10})$",
            message = "{errors.user.invalid_phone_pattern}")
    @NotBlank(message = "{errors.user.phone_is_blank}")
    private String phoneNumber;
}