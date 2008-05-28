package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.util.List;

public final class DefaultMemberInjector implements MemberInjector {
    private final List<MemberInjector> members;

    public DefaultMemberInjector(List<MemberInjector> members) {
        this.members = members;
    }

    public void inject(Object ref) {
        for (MemberInjector member : members) member.inject(ref);
    }
}
