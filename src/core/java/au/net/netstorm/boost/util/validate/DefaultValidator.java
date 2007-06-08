package au.net.netstorm.boost.util.validate;

import au.net.netstorm.boost.type.util.core.Validator;

// FIX DEBT (was 36163) TD...
public final class DefaultValidator implements Validator {
    public void checkNotEmpty(String ref, String msg) {
        if (empty(ref)) throw new IllegalArgumentException(msg);
    }

    public void checkNotNull(Object ref, String msg) {
        if (ref == null) throw new IllegalArgumentException(msg);
    }

    public void checkNotEmpty(int[] ref, String msg) {
        boolean empty = ref == null || ref.length == 0;
        if (empty) throw new IllegalArgumentException(msg);
    }

    public void checkEmpty(String msg) {
        if (msg != null) throw new IllegalArgumentException(msg);
    }

    public boolean empty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    public boolean empty(String item) {
        return item == null || item.length() == 0;
    }
}
