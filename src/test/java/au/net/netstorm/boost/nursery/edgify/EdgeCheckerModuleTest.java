package au.net.netstorm.boost.nursery.edgify;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.test.aggregator.RegexPattern;
import au.net.netstorm.boost.test.aggregator.TestClassLocator;
import au.net.netstorm.boost.test.aggregator.TestRegexPattern;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.array.ArrayOperator;
import au.net.netstorm.boost.util.array.DefaultArrayOperator;

// FIX 33398 Write test to check for edgify engine.

// OK ClassDataAbstractionCoupling {
public final class EdgeCheckerModuleTest extends BoooostCase {
    private final ArrayOperator arrayOperator = new DefaultArrayOperator();
    private final TestClassLocator classLocator = new TestClassLocator();
    private final EdgeChecker edgeConstructorChecker = new DefaultEdgeConstructorChecker();
    private final EdgeChecker edgeFieldChecker = new DefaultEdgeFieldChecker();
    private final EdgeChecker edgeClassChecker = new DefaultEdgeClassChecker();
    private final EdgeChecker edgeEdgifierChecker = new DefaultEdgeEdgifierChecker();
    private final EdgeChecker edgeParameterChecker = new DefaultEdgeParameterChecker();
    private final EdgeChecker edgePackageChecker = new DefaultEdgePackageChecker();
    private Class[] edgeClasses;

    protected void gearup() {
        Class[] startingWithEdge = getClasses(".*DefaultEdge.*");
        Class[] endingWithSupplier = getClasses(".*Supplier");
        Class[] endingWithConverter = getClasses(".*Converter");
        Class[] endingWithChecker = getClasses(".*Checker");
        Class[] excludingSuppliers = (Class[]) arrayOperator.minus(startingWithEdge, endingWithSupplier);
        Class[] excludingCheckers = (Class[]) arrayOperator.minus(excludingSuppliers, endingWithChecker);
        edgeClasses = (Class[]) arrayOperator.minus(excludingCheckers, endingWithConverter);
    }

    public void testEdgeStructure() {
        for (int i = 0; i < edgeClasses.length; i++) {
            checkStructure(edgeClasses[i]);
        }
    }

    private void checkStructure(Class edgeClass) {
        edgeConstructorChecker.check(edgeClass);
        edgeFieldChecker.check(edgeClass);
        edgeClassChecker.check(edgeClass);
        edgeEdgifierChecker.check(edgeClass);
        edgeParameterChecker.check(edgeClass);
        edgePackageChecker.check(edgeClass);
    }

    private Class[] getClasses(String regex) {
        RegexPattern pattern = new TestRegexPattern(regex);
        return classLocator.locate(EdgeException.class, pattern);
    }
}
// } OK ClassDataAbstractionCoupling