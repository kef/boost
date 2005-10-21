package au.net.netstorm.boost.util.indent;

import au.net.netstorm.boost.util.separator.Separator;

public class DefaultIndenterMaster implements IndenterMaster {
    private static final String LS = Separator.LINE;

    public String indent(String s) {
        return INDENT + s.replaceAll(LS, LS + INDENT);
    }
}
