package au.net.netstorm.boost.nursery.type.supa;

import au.net.netstorm.boost.util.typed.TypedMap;
import au.net.netstorm.boost.util.typed.TypedMapRead;
import au.net.netstorm.boost.util.typed.TypedMapWrite;

public interface SuperMapAssembler {
    SuperMap assemble(TypedMapRead read);

    SuperMap assemble(TypedMapWrite write);

    SuperMap assemble(TypedMap typed);
}
