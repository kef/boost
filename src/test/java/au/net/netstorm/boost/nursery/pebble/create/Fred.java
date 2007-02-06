package au.net.netstorm.boost.nursery.pebble.create;

class Fred {
    private NewNedCreator newNedCreator;
    private NewTedCreator newTedCreator;
    private String newNotACreatorType;
    private final NewTedCreator newNotACreatorBecauseFinal = null;
    private NewNedCreator newNotACreatorBecauseAssigned = new NewNedCreator();
    private NewDoesNotImplementMarker newNotACreatorDoesNotImplementMarker;

    private class NewTedCreator implements Creator {
    }

    private class NewNedCreator implements Creator {
    }

    private class NewDoesNotImplementMarker {
    }
}
