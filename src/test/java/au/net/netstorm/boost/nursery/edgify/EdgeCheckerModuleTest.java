package au.net.netstorm.boost.nursery.edgify;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.test.aggregator.RegexPattern;
import au.net.netstorm.boost.test.aggregator.TestClassLocator;
import au.net.netstorm.boost.test.aggregator.TestRegexPattern;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.array.ArrayOperator;
import au.net.netstorm.boost.util.array.DefaultArrayOperator;

// OK ClassDataAbstractionCoupling {
public final class EdgeCheckerModuleTest extends BoooostCase {
    private final ArrayOperator array = new DefaultArrayOperator();
    private final TestClassLocator classLocator = new TestClassLocator();
    private final EdgeChecker constructorChecker = new DefaultEdgeConstructorChecker();
    private final EdgeChecker fieldChecker = new DefaultEdgeFieldChecker();
    private final EdgeChecker classChecker = new DefaultEdgeClassChecker();
    private final EdgeChecker edgifierChecker = new DefaultEdgeEdgifierChecker();
    private final EdgeChecker parameterChecker = new DefaultEdgeParameterChecker();
    private final EdgeChecker packageChecker = new DefaultEdgePackageChecker("com.rsa.keymanager.edge.");
    private Class[] edgeClasses;

    protected void gearup() {
        Class[] startingWithEdge = getClasses(".*DefaultEdge.*");
        Class[] endingWithSupplier = getClasses(".*Supplier");
        Class[] endingWithConverter = getClasses(".*Converter");
        Class[] endingWithChecker = getClasses(".*Checker");
        Class[] excludingSuppliers = (Class[]) array.minus(startingWithEdge, endingWithSupplier);
        Class[] excludingCheckers = (Class[]) array.minus(excludingSuppliers, endingWithChecker);
        edgeClasses = (Class[]) array.minus(excludingCheckers, endingWithConverter);
    }

    public void testEdgeStructure() {
        for (int i = 0; i < edgeClasses.length; i++) {
            checkStructure(edgeClasses[i]);
        }
    }

    private void checkStructure(Class edgeClass) {
        constructorChecker.check(edgeClass);
        fieldChecker.check(edgeClass);
        classChecker.check(edgeClass);
        edgifierChecker.check(edgeClass);
        parameterChecker.check(edgeClass);
        packageChecker.check(edgeClass);
    }

    private Class[] getClasses(String regex) {
        RegexPattern pattern = new TestRegexPattern(regex);
        return classLocator.locate(EdgeException.class, pattern);
    }
}
// } OK ClassDataAbstractionCoupling