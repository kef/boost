package au.net.netstorm.boost.gunge.string;

public class DefaultStringTransform implements StringTransform {
    public String stripPrefix(String s, String prefix) {
        if (!s.startsWith(prefix)) fail(s, "start", prefix);
        int newStart = prefix.length();
        return s.substring(newStart);
    }

    public String stripSuffix(String s, String suffix) {
        if (!s.endsWith(suffix)) fail(s, "end", suffix);
        int newEnd = s.length() - suffix.length();
        return s.substring(0, newEnd);
    }

    private void fail(String s, String reason, String token) {
        throw new IllegalArgumentException("Can't transform " + s + " does not " + reason + " with " + token);
    }
}
