package au.net.netstorm.boost.util.tostring;

import java.lang.reflect.Array;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.indent.DefaultIndenterMaster;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.separator.Separator;

public class IndentingToStringMaster implements ToStringMaster {
    private static final String COMMA = ",";
    private static final String LF = Separator.LINE;
    private final ClassMaster classMaster = new DefaultClassMaster();

    public String getString(Object ref) {
        return getClassName(ref.getClass()) + formatFields(formatFields(ref));
    }

    private String formatFields(String[] s) {
        if (s.length == 0) return "[]";
        return "[" + LF + indent(getString(s)) + LF + "]";
    }

    private String getString(String[] s) {
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += s[i];
            if (i < s.length - 1) result += LF;
        }
        return result;
    }

    private String[] formatFields(Object ref) {
        // FIX SC506 Field.
        DefaultReflectMaster reflect = new DefaultReflectMaster();
        FieldValueSpec[] fields = reflect.getInstanceFields(ref);
        String[] result = new String[fields.length];
        for (int i = 0; i < result.length; i++) result[i] = formatField(fields[i]);
        return result;
    }

    private String formatField(FieldValueSpec fieldValue) {
        return fieldValue.getName() + "=" + fieldValue(fieldValue);
    }

    private String fieldValue(FieldValueSpec fieldValue) {
        // FIX SC600 incorporate and test this.
//        if (fieldValue == null) return "null";
        Object value = fieldValue.getValue();
        return (isArray(value) ? arrayValue(value) : value.toString());
    }

    private String arrayValue(Object array) {
        return "{" + arrayToString(array) + "}";
    }

    private String arrayToString(Object array) {
        String result = "";
        for (int i = 0; i < Array.getLength(array); i++) {
            result += Array.get(array, i)
                    .toString() + COMMA;
        }
        return removeLastChar(result);
    }

    private String getClassName(Class cls) {
        return classMaster.getShortName(cls);
    }

    private boolean isArray(Object value) {
        return value.getClass()
                .isArray();
    }

    private String removeLastChar(String s) {
        return s.length() == 0 ? s : s.substring(0, s.length() - 1);
    }

    private String indent(String result) {
        return new DefaultIndenterMaster().indent(result);
    }
}
// FIX SC050 It would be nice if byte[]s (int, long?) printed out in ASCII as well (hexdump style).