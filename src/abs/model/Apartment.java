package abs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;


/*
        An apartment owned by someone and hired by a lodger
 */
public class Apartment {
    private final String id;
    private final Person owner;
    private final int maxGuests;
    private final List<Period> occupied = new ArrayList<>();

    public Apartment(String id, Person owner, int maxGuests) {
        this.id = id;
        this.owner = owner;
        this.maxGuests = maxGuests;
    }

    public Apartment(String id) {
        this(id, null, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(id, apartment.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + id + '\'' +

                ", owner=" + owner +
                ", maxGuests=" + maxGuests +
                ", occupied=" + occupied +
                '}';
    }
// TODO a lot

    public boolean isFree(Period pd) {
        boolean free = true;
        for (Period period : occupied) {
            free &= !pd.overlaps(period);
        }

        return free;
    }

    public boolean bookPeriod(Period pd) {
        return isFree(pd) && occupied.add(pd);
    }

    public void unbookPeriod(Period pd) {
        occupied.remove(pd);
    }

    public Person getOwner() {
        return owner;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public List<Period> getOccupied() {
        return occupied;
    }

    public String getId() {
        return id;
    }
}
