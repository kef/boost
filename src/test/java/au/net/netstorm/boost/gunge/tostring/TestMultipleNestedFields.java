package au.net.netstorm.boost.gunge.tostring;

class TestMultipleNestedFields {
    private final String name;
    private final TestTwoFields two;

    public TestMultipleNestedFields(String name, TestTwoFields two) {
        this.name = name;
        this.two = two;
    }
}
