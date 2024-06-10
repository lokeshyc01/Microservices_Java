public class Test {
    public static void main(String[] args) {
        User user = new User.UserBuilder().setId(1L).setAge(22L).setName("xyz").build();

        User newUser = User.builder().setId(2L).setName("abc").setAge(25L).build();
        System.out.println(newUser);
        System.out.println(user);

        User thirdUser = User.builder().setId(33L).setName("zxy").build();
        System.out.println(thirdUser);
    }
}
