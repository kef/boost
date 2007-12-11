package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.provider.SpecificProvider;

// FIX (Dec 11, 2007) CORE SPLIT 88531 Rename me. Not just a data provider anymore..
public interface DataProviders<T> extends SpecificProvider {
    void add(Class<? extends T> type, DataProvider<? extends T> provider);
}
