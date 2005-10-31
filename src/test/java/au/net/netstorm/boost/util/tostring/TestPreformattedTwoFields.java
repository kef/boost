package au.net.netstorm.boost.util.tostring;

import au.net.netstorm.boost.util.separator.Separator;

// FIXME: SC506 Rename to TestPre....
class TestPreformattedTwoFields extends TestTwoFields {
    private static final String LINE = Separator.LINE;

    public TestPreformattedTwoFields(int x, int y) {
        super(x, y);
    }

    public String toString() {
        return "TestTwoFields[" + LINE + "    x=2" + LINE + "    y=4" + LINE + "]";
    }
}
