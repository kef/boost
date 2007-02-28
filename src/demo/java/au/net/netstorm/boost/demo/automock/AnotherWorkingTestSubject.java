package au.net.netstorm.boost.demo.automock;

import java.util.List;
import java.util.Map;

public final class AnotherWorkingTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public AnotherWorkingTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void executeGet(Map map) {
        delegate.operate("foo");
    }

    public void executePut(Map map, List[] dataInputs) {
    }

    public void stringLengths(String[] strings) {
    }
}
