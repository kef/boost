package au.net.netstorm.boost.test.automock;

public interface FieldInspector {
    boolean isNull();

    boolean isFinal();

    boolean isUsed();
}
