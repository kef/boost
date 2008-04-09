package au.net.netstorm.boost.gunge.equals;

class TestObject {
    private String aString;
    private int anInt;

    public TestObject(String aString, int anInt) {
        this.aString = aString;
        this.anInt = anInt;
    }

    public String toString() {
        return "For Checkstyle TestObject[aString=" + aString + ",anInt=" + anInt + "]";
    }
}
