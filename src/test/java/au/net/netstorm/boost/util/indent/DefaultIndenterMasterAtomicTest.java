package au.net.netstorm.boost.util.indent;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.separator.Separator;

public class DefaultIndenterMasterAtomicTest extends BoooostCase {
    private static final String LF = Separator.LINE;
    private static final String EXPECTED_SINGLE_LINE = "    hello";
    private static final String EXPECTED_TWO_LINE = "    line0" + LF + "    line1";

    public void testIndent() {
        IndenterMaster indenter = new DefaultIndenterMaster();
        assertEquals(EXPECTED_SINGLE_LINE, indenter.indent("hello"));
        assertEquals(EXPECTED_TWO_LINE, indenter.indent("line0" + LF + "line1"));
    }
}
