package by.shylau.salerno.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private String name;

    private String lastname;

    private Integer age;

    private Timestamp time;

    private String email;
}
