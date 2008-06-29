package au.net.netstorm.boost.scalpel.testdata.real;

public final class Arrayo {
    private final ArrayElement element = new ArrayElement();

    public ArrayElement[] single() {
        return new ArrayElement[] {element, element};
    }

    public ArrayElement[][] multi() {
        return new ArrayElement[][] {single(), single()};
    }

    public ArrayElement[] real() {
        return single();
    }
}
