package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.SpecificProvider;

public interface EnumProvider extends SpecificProvider {
    <T extends Enum> void add(Class<T> type);
}
