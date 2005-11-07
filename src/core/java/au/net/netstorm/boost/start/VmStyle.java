package au.net.netstorm.boost.start;

import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

public final class VmStyle extends Primordial implements Data {
    // FIXME: SC506 Remove these guys.
    public static final VmStyle FRONT_END = new VmStyle("FrontEnd");
    public static final VmStyle BACK_END = new VmStyle("BackEnd");
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
