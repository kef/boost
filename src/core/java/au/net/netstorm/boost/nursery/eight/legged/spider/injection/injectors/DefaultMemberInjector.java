package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

public final class DefaultMemberInjector implements MemberInjector {
    private final MemberInjector[] members;

    public DefaultMemberInjector(MemberInjector[] members) {
        this.members = members;
    }

    public void inject(Object ref) {
        for (MemberInjector member : members) member.inject(ref);
    }
}
