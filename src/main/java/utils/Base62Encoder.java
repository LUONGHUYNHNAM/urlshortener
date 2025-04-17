package utils;

public class Base62Encoder {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final  int BASE = BASE62.length();

//  Encode
    public static String encode (long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int remainder = (int) (id % BASE);
            sb.append(BASE62.charAt(remainder));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    public static long decode (String shortCode) {
        long id = 0;
        for (int i = 0; i < shortCode.length(); i++) {
            id = id * BASE + BASE62.indexOf(shortCode.charAt(i));
        }
        return id;
    }
}
