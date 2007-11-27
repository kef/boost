package au.net.netstorm.boost.nursery.type.holder;

import au.net.netstorm.boost.nursery.type.StringHolder;
import au.net.netstorm.boost.provider.Nu;

public class DefaultStringHolderUtil implements StringHolderUtil {
    Nu nu;

    public <T extends StringHolder> T replaceAll(T holder, String regex, String replacement) {
        String s = holder.getValue();
        String result = s.replaceAll(regex, replacement);
        Class holderClass = holder.getClass();
        return (T) nu.nu(holderClass, result);
    }
}
