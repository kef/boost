package au.net.netstorm.boost.sniper.atom;

interface ArrayHolder {
    int length();

    Object get(int index);

    void set(int index, Object value);

    Class elementType();

    Object clone();

    Object getArray();
}
