package au.net.netstorm.boost.nursery.type.holder;

import au.net.netstorm.boost.nursery.type.StringHolder;

public interface StringHolderUtil {
    <T extends StringHolder> T replaceAll(T holder, String regex, String replacement);
}
