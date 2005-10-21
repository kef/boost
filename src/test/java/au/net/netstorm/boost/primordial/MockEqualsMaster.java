package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.util.equals.EqualsMaster;

final class MockEqualsMaster implements EqualsMaster {
    private Object o1;
    private Object o2;
    private boolean equals;

    public boolean equals(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
        return equals;
    }

    public void prepare(boolean equals) {
        this.equals = equals;
    }

    public Object getObject1() {
        return o1;
    }

    public Object getObject2() {
        return o2;
    }
}
