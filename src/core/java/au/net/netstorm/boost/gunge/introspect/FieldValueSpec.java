package au.net.netstorm.boost.gunge.introspect;

// FIX SC600 Extend NameValueSpec.  Then have FieldValueSpec/PropertyValueSpec extend NameValueSpec.
public interface FieldValueSpec {
    String getName();

    Object getValue();
}
