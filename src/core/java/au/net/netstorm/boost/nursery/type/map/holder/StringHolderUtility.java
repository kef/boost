package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.StringHolder;

public interface StringHolderUtility {
    <T extends StringHolder> T replaceAll(T holder, String regex, String replacement);
}
