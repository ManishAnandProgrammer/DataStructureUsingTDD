package datastructure.hashmap_working.overriding_hashcode_equals;

import java.util.Objects;

public class Profile {
    private final String email;
    private final String address;

    public Profile(final String email,
                   final String address) {
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return email.equals(profile.email) && address.equals(profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, address);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
