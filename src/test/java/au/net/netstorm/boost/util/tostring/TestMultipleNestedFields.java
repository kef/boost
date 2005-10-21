package au.net.netstorm.boost.util.tostring;

class TestMultipleNestedFields {
    private final String name;
    private final TestTwoFields two;

    public TestMultipleNestedFields(String name, TestTwoFields two) {
        this.name = name;
        this.two = two;
    }
}
