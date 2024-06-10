public class User {

  private Long id;
  private String name;
  private Long age;

  private User(UserBuilder user) {
    this.id = user.id;
    this.age = user.age;
    this.name = user.name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getAge() {
    return age;
  }

  public static UserBuilder builder(){
    return new UserBuilder();
  }

  @Override
public String toString() {
    return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
}

static class UserBuilder {

    private Long id;
    private String name;
    private Long age;

    public UserBuilder setId(Long id) {
      this.id = id;
      return this;
    }

    public UserBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder setAge(Long age) {
      this.age = age;
      return this;
    }

    public User build(){
        return new User(this);
    }
  }
}
