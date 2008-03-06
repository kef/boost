package au.net.netstorm.boost.util.tostring;

import au.net.netstorm.boost.nursery.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.separator.Separator;

// NOTE: Currently doesn't handle graphs, so recursive loops will kill it.
// FIX SC600.  Test nulls.

// DEBT ClassDataAbstractionCoupling {
public class IndentingToStringMasterAtomicTest extends BoooostCase {
    private static final TestNoField NO_FIELDS = new TestNoField();
    private static final TestTwoFields TWO_FIELDS_2_4 = new TestTwoFields(2, 4);
    private static final TestTwoFields TWO_FIELDS_5_7 = new TestTwoFields(5, 7);
    private static final TestNestedFields NESTED_FIELDS = new TestNestedFields("Andy", new TestFixed());
    private static final TestNullField NULL_FIELD = new TestNullField();
    private static final TestStringArrayField STRING_ARRAY_A_B = new TestStringArrayField(new String[]{"A", "B"});
    private static final TestIntArrayField INT_ARRAY = new TestIntArrayField(new int[]{1, 2, 4});
    private static final TestMixedArrayField MIXED_ARRAY = new TestMixedArrayField(new long[]{1L, 54L}, new String[]{"A", "Z"});
    private static final TestMultipleNestedFields MULTIPLE_NESTED_FIELDS =
            new TestMultipleNestedFields("multiple", new TestPreformattedTwoFields(2, 4));
    private static final TestStringArrayField STRING_ARRAY_C_D = new TestStringArrayField(new String[]{"C", "D"});
    private static final String EXPECTED_INDENTATION = "    ";
    private static final TestSingleField SINGLE_FIELD = new TestSingleField(9);

    public void testToString() {
        checkToString("TestNoField[]", NO_FIELDS);
        checkToString(singleField(9), SINGLE_FIELD);
        checkToString(twoFieldsResult(2, 4, 0), TWO_FIELDS_2_4);
        checkToString(twoFieldsResult(5, 7, 0), TWO_FIELDS_5_7);
    }

    public void testToStringMultiple() {
        checkToString(nestedFieldResult(), NESTED_FIELDS);
        checkToString(nullFieldResult(), NULL_FIELD);
        checkToString(stringArrayResult("A", "B"), STRING_ARRAY_A_B);
        checkToString(stringArrayResult("C", "D"), STRING_ARRAY_C_D);
        checkToString(intArrayResult(), INT_ARRAY);
        checkToString(mixedArrayResult(), MIXED_ARRAY);
        checkToString(multipleNestedFieldResult(), MULTIPLE_NESTED_FIELDS);
    }

    private String singleField(int i) {
        return "" + i;
    }

    private String nestedFieldResult() {
        return "TestNestedFields[" + lfIndent("name=Andy") + lfIndent("nested=FIXED") + lf("]");
    }

    private String nullFieldResult() {
        return "NULL";
    }

    private String multipleNestedFieldResult() {
        return "TestMultipleNestedFields[" + lfIndent("name=multiple") + lfIndent("two=") + twoFieldsResult(2, 4, 1) + lf("]");
    }

    private String mixedArrayResult() {
        return "TestMixedArrayField[" + lfIndent("longs={1,54}") + lfIndent("strings={A,Z}") + lf("]");
    }

    private String intArrayResult() {
        return "{1,2,4}";
    }

    private String stringArrayResult(String x, String y) {
        return "{" + x + "," + y + "}";
    }

    private String twoFieldsResult(int x, int y, int depth) {
        return "TestTwoFields[" + lfIndent("x=" + x, depth + 1) + lfIndent("y=" + y, depth + 1) + lfIndent("]", depth);
    }

    private String lf(String content) {
        return Separator.LINE + content;
    }

    private String lfIndent(String content) {
        return lfIndent(content, 1);
    }

    private String lfIndent(String content, int level) {
        return lf(indent(content, level));
    }

    private String indent(String content, int level) {
        String prefix = "";
        for (int i = 0; i < level; i++) prefix += EXPECTED_INDENTATION;
        return prefix + content;
    }

    private void checkToString(String expected, Object ref) {
        ToStringMaster indentingToStringMaster = new IndentingToStringMaster();
        String result = indentingToStringMaster.getString(ref);
        assertEquals(expected, result);
    }
}
// } DEBT ClassDataAbstractionCoupling
