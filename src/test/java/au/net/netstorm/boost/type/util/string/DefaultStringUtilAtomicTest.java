package au.net.netstorm.boost.type.util.string;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultStringUtilAtomicTest extends BoooostCase {
    private static final String START_MARKER = "-Start-";
    private static final String END_MARKER = "-End-";
    private static final String LARRY_STRING = "BadCharacters-Start-LarryIsALegend-End-MoreBadCharacters";
    private static final String KEVIN_STRING = "GoGoGadget---Start-KevinIsDocumenting-End---End-InspectorGadget";
    StringUtil subject = new DefaultStringUtil();

    public void testStart() {
        checkStart(LARRY_STRING, START_MARKER, 13);
        checkStart(KEVIN_STRING, START_MARKER, 12);
    }

    public void testEnd() {
        checkEnd(LARRY_STRING, END_MARKER, 39);
        checkEnd(KEVIN_STRING, END_MARKER, 48);
    }

    private void checkEnd(String str, String marker, int expected) {
        int result = subject.getEnd(str, marker);
        assertEquals(expected, result);
    }

    private void checkStart(String str, String marker, int expected) {
        int result = subject.getStart(str, marker);
        assertEquals(expected, result);
    }
}
