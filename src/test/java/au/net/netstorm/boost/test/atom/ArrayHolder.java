package au.net.netstorm.boost.test.atom;

interface ArrayHolder {
    int length();
    Object get(int index);
    void set(int index, Object value);
    Class elementType();
}
