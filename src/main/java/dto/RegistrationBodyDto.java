package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class RegistrationBodyDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
