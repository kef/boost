package au.net.netstorm.boost.nursery.gunge.tostring;

import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.gunge.indent.DefaultIndenterMaster;
import au.net.netstorm.boost.gunge.indent.IndenterMaster;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.separator.Separator;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;

import java.lang.reflect.Array;

// FIX 2299 Up coverage and out of nursery.
public class IndentingToStringMaster implements ToStringMaster {
    private static final String COMMA = ",";
    private static final String LF = Separator.LINE;
    private static final String BLANK = "";
    private final ClassMaster classer = new DefaultClassMaster();
    private final ReflectMaster reflecter = new DefaultReflectMaster();
    private final IndenterMaster indenter = new DefaultIndenterMaster();

    public String string(Object ref) {
        FieldValueSpec[] specs = reflecter.getInstanceFields(ref);
        boolean extended = useExtended(specs);
        return getClassName(ref, extended) + string(specs);
    }
    // FIX 2130 This beast has to live on!!!!!
//    if (MARKER.is(this, Sensitive.class)) return "Like XXXX, totally unflavoured.";

    public String string(FieldValueSpec[] specs) {
        boolean extended = useExtended(specs);
        String[] strings = extended ? multiple(specs) : single(specs[0]);
        return format(strings);
    }

    private String getClassName(Object ref, boolean extended) {
        return extended ? getClassName(ref) : BLANK;
    }

    private String format(String[] s) {
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

    private String[] multiple(FieldValueSpec[] specs) {
        String[] result = new String[specs.length];
        for (int i = 0; i < specs.length; i++) {
            result[i] = formatField(specs[i]);
        }
        return result;
    }

    private String[] single(FieldValueSpec spec) {
        return new String[]{fieldValue(spec)};
    }

    private String formatField(FieldValueSpec spec) {
        String name = spec.getName();
        String value = fieldValue(spec);
        return name + "=" + value;
    }

    private String fieldValue(FieldValueSpec spec) {
        Object value = spec.getValue();
        if (value == null) return "NULL";
        return isArray(value) ? arrayValue(value) : value.toString();
    }

    private String arrayValue(Object array) {
        return "{" + arrayToString(array) + "}";
    }

    private String arrayToString(Object array) {
        String result = BLANK;
        for (int i = 0; i < Array.getLength(array); i++) {
            result += Array.get(array, i) + COMMA;
        }
        return removeLastChar(result);
    }

    private String getClassName(Object ref) {
        Class cls = ref.getClass();
        return classer.getShortName(cls);
    }

    private boolean isArray(Object value) {
        Class cls = value.getClass();
        return cls.isArray();
    }

    private String removeLastChar(String s) {
        return s.length() == 0 ? s : s.substring(0, s.length() - 1);
    }

    private String indent(String result) {
        return indenter.indent(result);
    }

    private boolean useExtended(Object[] refs) {
        return refs.length != 1;
    }
}
// SUGGEST: It would be nice if byte[]s (int, long?) printed out in ASCII as well (hexdump style).