package springmvcstudy2.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoValidatedDto {

    @NotBlank(message = " * can't be blank")
    @Size(min = 3, max = 10, message = " * must have 3 to 10 characters")
    private String name1;
    private String name2;

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
