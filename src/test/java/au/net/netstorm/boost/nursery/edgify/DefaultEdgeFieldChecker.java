package au.net.netstorm.boost.nursery.edgify;

import junit.framework.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public final class DefaultEdgeFieldChecker implements EdgeChecker {
    private static final String EDGE_DELEGATE_NAME = "delegate";
    private static final List FIELD_CHECK_EXCEPTIONS = new ArrayList();

    static {
        FIELD_CHECK_EXCEPTIONS.add(DefaultEdgifierHorizon.class);
    }

    public void check(Class edgeClass) {
        if (!FIELD_CHECK_EXCEPTIONS.contains(edgeClass)) {
            Field[] declaredFields = edgeClass.getDeclaredFields();
            if (declaredFields.length > 0) {
                String className = edgeClass.getName();
                checkNoExtraFields(declaredFields, className);
                checkDelegateField(declaredFields, className);
            }
        }
    }

    private void checkDelegateField(Field[] fields, String className) {
        if (hasDelegateField(fields)) {
            Field delegateField = getDelegateField(fields);
            String fieldName = delegateField.getName();
            checkDelegateFieldName(fieldName, className);
            int fieldModifiers = delegateField.getModifiers();
            Assert.assertTrue("The delegate field in " + className + " should be private and final.", isPrivateAndFinal(fieldModifiers));
        }
    }

    private void checkNoExtraFields(Field[] declaredFields, String className) {
        List nonSupplierFields = getNonSupplierFields(declaredFields);
        Assert.assertTrue(className + " should contain only one field that is not a supplier.", onlyContainsADelegate(nonSupplierFields));
    }

    private Field getDelegateField(Field[] fields) {
        List list = getNonSupplierFields(fields);
        return (Field) list.get(0);
    }

    private boolean hasDelegateField(Field[] fields) {
        List nonSupplierFields = getNonSupplierFields(fields);
        return nonSupplierFields.size() == 1;
    }

    private boolean onlyContainsADelegate(List nonSupplierFields) {
        return 1 >= nonSupplierFields.size();
    }

    private List getNonSupplierFields(Field[] declaredFields) {
        List nonSupplierFields = new ArrayList();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            if (!isAcceptableExtraEdgeField(declaredField)) {
                nonSupplierFields.add(declaredField);
            }
        }
        return nonSupplierFields;
    }

    private void checkDelegateFieldName(String fieldName, String className) {
        Assert.assertTrue(className + "." + fieldName + " should be called \"" + EDGE_DELEGATE_NAME + "\".", fieldName.equals(EDGE_DELEGATE_NAME));
    }

    private boolean isAcceptableExtraEdgeField(Field field) {
        Class fieldClass = field.getType();
        String name = fieldClass.getName();
        return name.endsWith("Supplier") || name.endsWith("Converter");
    }

    private boolean isPrivateAndFinal(int modifiers) {
        return Modifier.isPrivate(modifiers) && Modifier.isFinal(modifiers);
    }
}
