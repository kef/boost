package au.net.netstorm.boost.type.util.core;

public interface Validator {
    void checkNotEmpty(String ref, String msg);

    void checkNotNull(Object ref, String msg);

    void checkNotEmpty(int[] ref, String msg);

    void checkEmpty(String msg);

    boolean empty(Object[] objects);

    boolean empty(String item);
}
