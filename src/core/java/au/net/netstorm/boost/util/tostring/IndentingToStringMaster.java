package au.net.netstorm.boost.util.tostring;

import java.lang.reflect.Array;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.indent.DefaultIndenterMaster;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.separator.Separator;

public class IndentingToStringMaster implements ToStringMaster {
    private static final String COMMA = ",";
    private static final String LF = Separator.LINE;
    private static final String BLANK = "";
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final ReflectMaster reflect = new DefaultReflectMaster();

    public String getString(Object ref) {
        FieldValueSpec[] fields = reflect.getInstanceFields(ref);
        return formatFields(ref, fields);
    }

    public String formatFields(Object ref, FieldValueSpec[] fields) {
        boolean extended = useExtended(fields);
        String[] strings = extended ? formatMultipleFields(fields) : formatSingleField(fields[0]);
        return getClassName(ref, extended) + layoutFields(strings);
    }

    private String getClassName(Object ref, boolean extended) {
        return extended ? getClassName(ref) : BLANK;
    }

    private String layoutFields(String[] s) {
        if (s.length == 0) return "[]";
        if (s.length == 1) return getString(s);
        return "[" + LF + indent(getString(s)) + LF + "]";
    }

    private String getString(String[] s) {
        String result = BLANK;
        for (int i = 0; i < s.length; i++) {
            result += s[i];
            if (i < s.length - 1) {
                result += LF;
            }
        }
        return result;
    }

    private String[] formatMultipleFields(FieldValueSpec[] fields) {
        int length = fields.length;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = formatField(fields[i]);
        }
        return result;
    }

    private String[] formatSingleField(FieldValueSpec field) {
        return new String[]{fieldValue(field)};
    }

    private String formatField(FieldValueSpec fieldValue) {
        String name = fieldValue.getName();
        String value = fieldValue(fieldValue);
        return name + "=" + value;
    }

    private String fieldValue(FieldValueSpec fieldValue) {
        Object value = fieldValue.getValue();
        if (value == null) return "null";
        return isArray(value) ? arrayValue(value) : value.toString();
    }

    private String arrayValue(Object array) {
        return "{" + arrayToString(array) + "}";
    }

    private String arrayToString(Object array) {
        String result = BLANK;
        for (int i = 0; i < Array.getLength(array); i++) {
            result += Array.get(array, i)
                    .toString() + COMMA;
        }
        return removeLastChar(result);
    }

    private String getClassName(Object ref) {
        Class cls = ref.getClass();
        return classMaster.getShortName(cls);
    }

    private boolean isArray(Object value) {
        Class cls = value.getClass();
        return cls.isArray();
    }

    private String removeLastChar(String s) {
        return s.length() == 0 ? s : s.substring(0, s.length() - 1);
    }

    private String indent(String result) {
        return new DefaultIndenterMaster().indent(result);
    }

    private boolean useExtended(Object[] refs) {
        return refs.length != 1;
    }
}
// SUGGEST: It would be nice if byte[]s (int, long?) printed out in ASCII as well (hexdump style).