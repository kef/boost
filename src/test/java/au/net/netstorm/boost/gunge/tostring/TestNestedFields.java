package au.net.netstorm.boost.gunge.tostring;

class TestNestedFields {
    private final String name;
    private final TestFixed nested;

    public TestNestedFields(String name, TestFixed nested) {
        this.name = name;
        this.nested = nested;
    }
}
