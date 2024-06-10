public class FactoryClass {
    
    public static Developer getDeveloper(String type){
        if(type.equalsIgnoreCase("ANDROID")){
            return new AndroidDeveloper();
        }
        else if(type.equalsIgnoreCase("WEB")){
            return new WebDeveloper();
        }
        return null;
    }
}
