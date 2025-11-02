package dto.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO {

    @JsonProperty("age")
    private int age;
    @JsonProperty("editor")
    private String editor;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    @JsonProperty("role")
    private String role;
    @JsonProperty("screenName")
    private String screenName;
    @JsonProperty("id")
    private int id;

    public PlayerDTO() {
    }

    private PlayerDTO(Builder builder) {
        this.age = builder.age;
        this.editor = builder.editor;
        this.gender = builder.gender;
        this.login = builder.login;
        this.password = builder.password;
        this.role = builder.role;
        this.screenName = builder.screenName;
        this.id = builder.id;
    }

    public int getAge() {
        return age;
    }

    public String getEditor() {
        return editor;
    }

    public String getGender() {
        return gender;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getScreenName() {
        return screenName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "age='" + age + '\'' +
                ", editor='" + editor + '\'' +
                ", gender='" + gender + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", screenName='" + screenName + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer age;
        private String editor;
        private String gender;
        private String login;
        private String password;
        private String role;
        private String screenName;
        private Integer id;

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder editor(String editor) {
            this.editor = editor;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder screenName(String screenName) {
            this.screenName = screenName;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public PlayerDTO build() {
            return new PlayerDTO(this);
        }
    }
}
