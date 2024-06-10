public class Test {
    public static void main(String[] args) {
        
        Subject youtube = new Youtube();
        Observer observer = new User("abhay");

        youtube.subScribe(observer);
        youtube.newVideoUpload();
    }
}
