package au.net.netstorm.boost.demo.automock;

public final class DefaultSomeData implements SomeData {
    private String aString;

    public DefaultSomeData(String aString) {
        this.aString = aString;
    }

    public String getAString() {
        return aString;
    }
}
