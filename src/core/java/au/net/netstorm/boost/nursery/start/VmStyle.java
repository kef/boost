package au.net.netstorm.boost.nursery.start;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;
import au.net.netstorm.boost.gunge.type.Data;

public final class VmStyle extends Primordial implements Data {
    private final String style;

    public VmStyle(String style) {
        this.style = style;
        validate();
    }

    private void validate() {
        NullMaster master = new DefaultNullMaster();
        master.check(style, "style");
    }

    public String getStyle() {
        return style;
    }
}
