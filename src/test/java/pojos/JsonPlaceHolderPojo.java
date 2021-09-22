package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
    {
        "userId": 10,
        "title": "quis eius est sint explicabo",
        "completed": true
    }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    //1.Step: Create private variables
    private Integer userId;
    private String title;
    private Boolean completed;


    //2.Step:Create constructors parameterized and un-parameterized
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }
    public JsonPlaceHolderPojo() {
    }
    //3.Step: Create all getters and setters
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    //4.Step: Create toString();
    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';

    }
}