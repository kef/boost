package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.util.core.KeyExists;

// FIX 57383 All this stuff is not part of natural.  Move to km.type
public interface TypedMapRead extends KeyExists {
    String getString(String key);

    int getInt(String key);

    long getLong(String key);

    boolean getBoolean(String key);

    int[] getInts(String key);

    byte[] getBytes(String key);
}
