package springmvcstudy.model;

public class WebsiteInfoDto {

    private String websiteName;
    private String websiteCategory;

    public String getWebsiteName() {
        return websiteName;
    }

    public WebsiteInfoDto() {
        System.out.println("Inside " + this.getClass().getSimpleName() + " constructor");
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteCategory() {
        return websiteCategory;
    }

    public void setWebsiteCategory(String websiteCategory) {
        this.websiteCategory = websiteCategory;
    }
}
