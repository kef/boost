package au.net.netstorm.boost.util.indent;

import au.net.netstorm.boost.util.separator.Separator;
import junit.framework.TestCase;

public class DefaultIndenterMasterAtomicTest extends TestCase {
    private static final String LF = Separator.LINE;
    private static final String EXPECTED_SINGLE_LINE = "    hello";
    private static final String EXPECTED_TWO_LINE = "    line0" + LF + "    line1";

    public void testIndent() {
        IndenterMaster indenter = new DefaultIndenterMaster();
        assertEquals(EXPECTED_SINGLE_LINE, indenter.indent("hello"));
        assertEquals(EXPECTED_TWO_LINE, indenter.indent("line0" + LF + "line1"));
    }

    // FIXME: SC501 Move this to IndentMasterAtomicTest.
    public void testConstant() {
        assertEquals("    ", IndenterMaster.INDENT);
    }
}
