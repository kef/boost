package au.net.netstorm.boost.gunge.string;

// FIX 2328 implement me and wire into class warper
public interface StringTransform {
    String stripPrefix(String s, String prefix);
    String stripSuffix(String s, String prefix);
}
