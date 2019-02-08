public class asd {
    public static boolean isIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
    public static void main(String[] args) {
        System.out.println(isIsogram("asf71873hdsg"));
    }
}