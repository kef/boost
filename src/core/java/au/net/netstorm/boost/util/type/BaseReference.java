package au.net.netstorm.boost.util.type;

public interface BaseReference extends
        Instance, // FIX 32755 This is actually a WrappedInstance.
        ResolvedInstance, // FIX 32755 Rename to Instance.
        UnresolvedInstance {
}
