package au.net.netstorm.boost.test.atom;

public interface RandomProvider {
    Object getRandom(Class type);

    boolean isRandomizable(Class type);
}
