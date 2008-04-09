package au.net.netstorm.boost.gunge.string;

public interface StringConverter {
    String convert(byte[] bytes, String charSet);

    byte[] convert(String str, String charSet);
}
