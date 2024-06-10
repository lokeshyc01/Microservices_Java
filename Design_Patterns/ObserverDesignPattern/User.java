public class User implements Observer{
    private String name;

    public User(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getNotified() {
       System.out.println("Hello "+this.name+" new video uploaded");
    }

    
}
