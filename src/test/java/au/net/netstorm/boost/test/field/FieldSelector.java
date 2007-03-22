package au.net.netstorm.boost.test.field;

public interface FieldSelector {
    BoostField[] select(BoostField[] fields, Matcher matcher);
}
