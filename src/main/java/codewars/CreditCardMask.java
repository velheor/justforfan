package codewars;

public class CreditCardMask {
    public static void main(String[] args) {
        System.out.println(maskify("12345"));
    }

    public static String maskify(String str) {
        if(str.length()>4){
            return str.replace(str.substring(0,(str.length()-4)), "#".repeat(str.length()-4));
        }
        else
           return str;
    }
}
