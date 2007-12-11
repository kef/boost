package au.net.netstorm.boost.test.specific;

// FIX (Dec 11, 2007) CORE SPLIT 88531 Rename me - not just a Data provider anymore
public interface DataProvider<T> {
    T get();
}
