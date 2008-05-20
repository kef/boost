package au.net.netstorm.boost.gunge.type;

public final class DefaultReferenceMaster implements ReferenceMaster {
    public Object[] resolve(Reference<?>[] references) {
        Object[] resolved = new Object[references.length];
        for (int i = 0; i < references.length; ++i) resolved[i] = references[i].getRef();
        return resolved;
    }
}
