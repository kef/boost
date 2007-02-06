package au.net.netstorm.boost.nursery.pebble.create;

// FIX 1665 Ensure naming works.  If a field is call fooCreator chuck a wobbly.

// FIX 1665 Close down scope.  Make package-private.
public class Fred {
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

    private class NewDoesNotImplementMarker { }
}
