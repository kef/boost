package au.net.netstorm.boost.type.util.string;

public final class DefaultStringUtil implements StringUtil {
    public int getStart(String string, String marker) {
        return string.indexOf(marker);
    }

    public int getEnd(String string, String marker) {
        return string.lastIndexOf(marker) + marker.length();
    }
}
