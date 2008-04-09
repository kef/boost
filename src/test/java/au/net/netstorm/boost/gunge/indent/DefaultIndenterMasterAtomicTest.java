package au.net.netstorm.boost.gunge.indent;

import au.net.netstorm.boost.gunge.separator.Separator;
import au.net.netstorm.boost.sniper.core.BoooostCase;

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
