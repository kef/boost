package au.net.netstorm.boost.type.util.string;

public interface StringConverter {
    String convert(byte[] bytes, String charSet);

    byte[] convert(String str, String charSet);
}
