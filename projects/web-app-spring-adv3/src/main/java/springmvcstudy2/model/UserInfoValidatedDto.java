package springmvcstudy2.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoValidatedDto {

    @NotBlank(message = " * can't be blank")
    @Size(min = 3, max = 10, message = " * must have from {min} to {max} characters")
    private String name1;

    @NotBlank(message = " * can't be blank")
    @Size(min = 3, max = 10)
    private String name2;

    @AssertTrue(message = " * Only humans are allowed to use this site")
    private boolean notARobot;

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

    public boolean isNotARobot() {
        return notARobot;
    }

    public void setNotARobot(boolean notARobot) {
        this.notARobot = notARobot;
    }
}
