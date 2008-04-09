package au.net.netstorm.boost.gunge.indent;

import au.net.netstorm.boost.gunge.separator.Separator;

public class DefaultIndenterMaster implements IndenterMaster {
    private static final String LS = Separator.LINE;
    private static final String INDENT = "    ";

    public String indent(String s) {
        return INDENT + s.replaceAll(LS, LS + INDENT);
    }
}
