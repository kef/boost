package au.net.netstorm.boost.nursery.pebble.create;

class Fred {
    private NewDefaultNed newDefaultNed;
    private NewTedImpl newTedImpl;
    private String newNotACreatorType;
    private final NewTedImpl newNotACreatorBecauseFinal = null;
    private NewDefaultNed newNotACreatorBecauseAssigned = new AnImplementatationOfNewDefaultNed();
    private NewDoesNotImplementMarker newNotACreatorDoesNotImplementMarker;

    private interface NewDoesNotImplementMarker {
    }

    private class AnImplementatationOfNewDefaultNed implements NewDefaultNed {
        public Ned create() {
            throw new UnsupportedOperationException();
        }
    }
}
