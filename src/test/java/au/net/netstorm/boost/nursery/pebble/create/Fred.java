package au.net.netstorm.boost.nursery.pebble.create;

// FIX 1665 Ensure naming works.  If a field is call fooCreator chuck a wobbly.

// FIX 1665 Close down scope.  Make package-private.
public class Fred {
    private final NewTedCreator newTedNotACreatorField = null;
    private NewNedCreator newNedNotACreatorField = new NewNedCreator();
    private NewNedCreator newNedCreator;
    private NewTedCreator newTedCreator;
    private String notACreatorField;

    private class NewTedCreator implements Creator {
    }

    private class NewNedCreator implements Creator {
    }
}
