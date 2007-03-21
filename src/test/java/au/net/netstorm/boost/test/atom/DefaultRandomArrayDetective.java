package au.net.netstorm.boost.test.atom;

public final class DefaultRandomArrayDetective implements RandomArrayDetective {
    public boolean isRandomizable(Class type) {
        return false;
    }
}
