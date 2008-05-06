package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.gunge.provider.SpecificProvider;

public interface EnumProvider extends SpecificProvider {
    <T extends Enum> void add(Class<T> type);
}
