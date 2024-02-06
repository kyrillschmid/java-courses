public class Main {

    public static String checkObject(Object obj) {
        return switch (obj) {
            case String s -> "This is a String";
            case null -> "It is null";
            default -> "It is an object";
        };
    }

    public static void main(String[] args){
        String result = Main.checkObject("Test-String");
        System.out.println(result);
    }

}
