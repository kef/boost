package au.net.netstorm.boost.util.tostring;

class TestNestedFields {
    private final String name;
    private final TestFixed nested;

    public TestNestedFields(String name, TestFixed nested) {
        this.name = name;
        this.nested = nested;
    }
}
