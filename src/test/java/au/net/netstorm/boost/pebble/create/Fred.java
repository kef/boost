package au.net.netstorm.boost.pebble.create;

// FIX BREADCRUMB 1665 -6000 Do we really want these broken fields here?
class Fred {
    private NewDefaultNed newDefaultNed;
    private NewTedImpl newTedImpl;
    // FIX 33203 Jury is out on this one.
    //    private String newNotACreatorType;
    private final NewTedImpl newNotACreatorBecauseFinal = null;
    private NewDefaultNed newNotACreatorBecauseAssigned = new AnImplementatationOfNewDefaultNed();

    private interface NewDoesNotImplementMarker {
    }

    private class AnImplementatationOfNewDefaultNed implements NewDefaultNed {
        public Ned create() {
            throw new UnsupportedOperationException();
        }
    }
}
