package au.net.netstorm.boost.start;

import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

public final class VmStyle extends Primordial implements Data {
    // FIXME: SC506 Remove these guys.
    public static final VmStyle WEB_SERVICE = new VmStyle("WebService");
    public static final VmStyle TASK_PROCESSOR = new VmStyle("TaskProcessor");
    public static final VmStyle RENDERER = new VmStyle("Renderer");
    private final String style;

    public VmStyle(String style) {
        NullMaster.check(style);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
