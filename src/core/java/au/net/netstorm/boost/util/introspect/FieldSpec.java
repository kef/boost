package au.net.netstorm.boost.util.introspect;

public interface FieldSpec {
    // FIX ? SC509 Get name is common. Named interface.
    String getName();

    Class getType();
}
