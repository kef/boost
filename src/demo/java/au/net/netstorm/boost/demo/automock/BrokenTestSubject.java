package au.net.netstorm.boost.demo.automock;

import java.io.DataInput;
import java.util.Map;

public final class BrokenTestSubject implements TestSubject {
    private final DelegateSubject delegate;

    public BrokenTestSubject(DelegateSubject delegate) {
        this.delegate = delegate;
    }

    public void executeGet(Map map) {
    }

    public void executePut(Map map, DataInput[] dataInputs) {
    }
}
