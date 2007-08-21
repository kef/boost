package au.net.netstorm.boost.nursery.string;

public interface StringConverter {
    String convert(byte[] bytes, String charSet);

    byte[] convert(String str, String charSet);
}