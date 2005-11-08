package au.net.netstorm.boost.ioc;

// FIXME: SC502 Test drive this.
public final class FieldAlreadyInitializedException extends IocException {

    // FIXME: SC502 Should probably require object reference and a fieldValueSpec.
    public FieldAlreadyInitializedException() {
        super("");
    }
}
