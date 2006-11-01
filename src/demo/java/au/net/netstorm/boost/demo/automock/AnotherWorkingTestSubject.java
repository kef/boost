package au.net.netstorm.boost.demo.automock;

import java.util.Map;

public final class AnotherWorkingTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public AnotherWorkingTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void execute(Map map) {
        delegate.operate("foo");
    }
}
