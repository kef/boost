package au.net.netstorm.boost.pebble.newer.fixture;

// FIX BREADCRUMB 1665 -6000 Do we really want these broken fields here?
public class Fred {
    private NewDefaultNed newDefaultNed;
    private NewTedImpl newTedImpl;
    // FIX 33203 Jury is out on this one.
    //    private String newNotANewerType;
    private final NewTedImpl newNotANewerBecauseFinal = null;
    private NewDefaultNed newNotANewerBecauseAssigned = new AnImplementatationOfNewDefaultNed();

    private interface NewDoesNotImplementMarker {
    }

    private class AnImplementatationOfNewDefaultNed implements NewDefaultNed {
        public Ned create() {
            throw new UnsupportedOperationException();
        }
    }
}
