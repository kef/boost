package au.net.netstorm.boost.demo.automock;

import java.util.Map;

public final class DefaultTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public DefaultTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void execute(Map map) {
        CharSequence value = (CharSequence) map.get("quake");
        delegate.operate(value);
    }
}
