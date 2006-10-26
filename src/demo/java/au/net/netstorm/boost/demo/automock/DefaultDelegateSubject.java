package au.net.netstorm.boost.demo.automock;

public final class DefaultDelegateSubject implements DelegateSubject {
    public void operate(CharSequence string) {
        throw new UnsupportedOperationException();
    }
}
