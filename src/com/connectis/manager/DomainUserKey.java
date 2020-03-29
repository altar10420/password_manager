package com.connectis.manager;

import java.util.Objects;

public class DomainUserKey implements Comparable<DomainUserKey> {

    private Domain domain;
    private User user;

    public DomainUserKey(Domain domain, User user) {
        this.domain = domain;
        this.user = user;
    }

    public Domain getDomain() {
        return domain;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainUserKey that = (DomainUserKey) o;
        return Objects.equals(domain, that.domain) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(domain, user);
    }

    @Override
    public String toString() {
        return domain + ", " + user;
    }


    @Override
    public int compareTo(DomainUserKey domainUserKey) {
        if (this.getDomain().getAddress().equals(domainUserKey.getDomain().getAddress())) {

            return this.getUser().getLogin().compareTo(domainUserKey.getUser().getLogin());
        }
        return this.getDomain().getAddress().compareTo(domainUserKey.getDomain().getAddress());
    }
}
