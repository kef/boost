package au.net.netstorm.boost.test.atom;

public final class DefaultCaptialiser implements Captialiser {
    public String captialise(String str) {
        if (str.length() == 0) return str;
        String upper = upperFirstLetter(str);
        String remainder = getRemainder(str);
        return upper + remainder;
    }

    private String upperFirstLetter(String str) {
        String firstLetter = str.substring(0, 1);
        return firstLetter.toUpperCase();
    }

    private String getRemainder(String str) {
        int endIndex = str.length();
        return str.substring(1, endIndex);
    }
}
