package springmvcstudy2.model;

public class UserInfoDto {

    private String name1 = "initial name 1";
    private String name2 = "initial name 2";

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
