package au.net.netstorm.boost.start;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Data;

public final class VmStyle extends Primordial implements Data {
    private final String style;

    public VmStyle(String style) {
        // FIXME: SC502 Move to validate(...).
        NullMaster master = new NullMaster();
        master.check(style);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
