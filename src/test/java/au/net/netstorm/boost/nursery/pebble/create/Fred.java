package au.net.netstorm.boost.nursery.pebble.create;

class Fred {
    private NewNedCreator newNedCreator;
    private NewTedCreator newTedCreator;
    private String newNotACreatorType;
    private final NewTedCreator newNotACreatorBecauseFinal = null;
    private NewNedCreator newNotACreatorBecauseAssigned = new DefaultNewNedCreator();
    private NewDoesNotImplementMarker newNotACreatorDoesNotImplementMarker;

    private interface NewTedCreator extends Creator {
    }

    private interface NewNedCreator extends Creator {
    }

    private interface NewDoesNotImplementMarker {
    }

    private class DefaultNewNedCreator implements NewNedCreator {
    }
}
