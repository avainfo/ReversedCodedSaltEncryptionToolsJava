package java.fr.avainfo;

public class RSCE {

    public static void main(String[] args) {
        encrypt("coucou", "1234");
    }

    public static String encrypt(String inputText, String code) {
        StringBuilder text = new StringBuilder();
        for(char c : inputText.toCharArray()) {
            System.out.println(c);
        }
        return text.toString();
    }
}
