package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Member;

import junit.framework.Assert;

public final class DefaultModifierTestChecker implements ModifierTestChecker {
    private final ClassMaster classMaster = new DefaultClassMaster();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();
    private static final String NOT_PUBLIC = "is not public";
    private static final String NOT_FINAL = "is not final";
    private static final String NOT_SYNCHRONIZED = "is not synchronized";
    private static final String NOT_CONCRETE = "is not concrete";
    private static final String NOT_STATIC = "is not static";

    public void checkPublic(Member member) {
        boolean isPublic = modifier.isPublic(member);
        check(member, NOT_PUBLIC, isPublic);
    }

    public void checkFinal(Member member) {
        boolean isFinal = modifier.isFinal(member);
        check(member, NOT_FINAL, isFinal);
    }

    public void checkSynchronized(Member member) {
        boolean isSynchronized = modifier.isSynchronized(member);
        check(member, NOT_SYNCHRONIZED, isSynchronized);
    }

    public void checkStatic(Member member) {
        boolean isStatic = modifier.isStatic(member);
        check(member, NOT_STATIC, isStatic);
    }

    public void checkPublic(Class cls) {
        boolean isPublic = modifier.isPublic(cls);
        check(cls, NOT_PUBLIC, isPublic);
    }

    public void checkFinal(Class cls) {
        boolean isFinal = modifier.isFinal(cls);
        check(cls, NOT_FINAL, isFinal);
    }

    public void checkConcrete(Class cls) {
        boolean isConcrete = modifier.isConcrete(cls);
        check(cls, NOT_CONCRETE, isConcrete);
    }

    private void check(Member member, String comment, boolean ok) {
        String name = getName(member);
        check(name, comment, ok);
    }

    private void check(Class cls, String comment, boolean ok) {
        String name = getName(cls);
        check(name, comment, ok);
    }

    private void check(String name, String comment, boolean ok) {
        String message = name + " " + comment;
        Assert.assertTrue(message, ok);
    }

    private String getName(Member member) {
        return "" + member;
    }

    private String getName(Class cls) {
        return classMaster.getShortName(cls);
    }
}
