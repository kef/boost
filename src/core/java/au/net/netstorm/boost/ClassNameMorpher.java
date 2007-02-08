package au.net.netstorm.boost;

// FIX 1665 Move into appropriate package. 
public interface ClassNameMorpher {
    Class stripPrefix(String prefix, Class cls);
}
