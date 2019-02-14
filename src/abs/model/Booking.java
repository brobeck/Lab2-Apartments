package abs.model;


import java.util.Objects;

/*
    A Booking of an apartment for some period by some lodger
 */
public class Booking {

    private final String id;
    private final Period period;
    private final Apartment apartment;
    private final Person guest;
    private final int nPersons;

    public Booking(String id, Person guest, Apartment apartment, int nPersons, Period period) {
        this.id = id;
        this.period = period;
        this.apartment = apartment;
        this.guest = guest;
        this.nPersons = nPersons;
    }

    public Booking(String id) {
        this(id, null, null, 0, null);
    }

    public String getId() {
        return id;
    }

    public Period getPeriod() {
        return period;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Person getGuest() {
        return guest;
    }

    public int getnPersons() {
        return nPersons;
    }
// TODO a lot

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", period=" + period +
                ", apartment=" + apartment +
                ", guest=" + guest +
                ", nPersons=" + nPersons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
