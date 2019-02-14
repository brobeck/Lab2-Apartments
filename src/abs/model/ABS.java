package abs.model;

import abs.ABSTestData;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*

        The Apartment Booking System (ABS)

 */
public class ABS {

    private final List<Apartment> apartments;
    private final List<Person> persons;
    private final List<Booking> bookings;

    public ABS() {
        apartments = new ArrayList<>();
        persons = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public ABS(ABSTestData testData) {
        this.apartments = testData.apartments;
        this.bookings = testData.bookings;
        this.persons = testData.persons;
    }

    // TODO a lot...

    public boolean add(Person p) {
        return !persons.contains(p) && persons.add(p);
        //!persons.contains(p) ? persons.add(p) : false
    }

    public boolean add(Apartment a) {
        boolean validAddition = persons.contains(a.getOwner())
                && !apartments.contains(a);
        return validAddition && apartments.add(a);
    }

    public boolean add(Booking b) {
        boolean validAddition = persons.contains(b.getGuest())
                && apartments.contains(b.getApartment())
                && !bookings.contains(b)
                && b.getApartment().getMaxGuests() >= b.getnPersons()
                && b.getApartment().bookPeriod(b.getPeriod());

        return  validAddition && bookings.add(b);
    }

    public Person find(Person p) {
        for (Person person : persons) {
            if (person.getId().equals(p.getId())) {
                return person;
            }
        }
        return null;
    }

    public Apartment find(Apartment a) {
        for (Apartment apartment : apartments) {
            if (apartment.getId().equals(a.getId())) {
                return apartment;
            }
        }
        return null;
    }

    public Booking find(Booking b) {
        for (Booking booking : bookings) {
            if (booking.getId().equals(b.getId())) {
                return booking;
            }
        }
        return null;
    }

    public boolean remove(Person p) {
        for (Booking booking : bookings) {
            if (booking.getGuest().equals(p)) {
                return false;
            }
        }

        for (Apartment apartment : apartments) {
            if (apartment.getOwner().equals(p)) {
                return false;
            }
        }

        return persons.remove(p);
    }

    public boolean remove(Apartment a) {
        for (Booking booking : bookings) {
            if (booking.getApartment().equals(a)) {
                return false;
            }
        }

        return apartments.remove(a);
    }

    public boolean remove(Booking b) {
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.equals(b)) {
                bookingToRemove = booking;
            }
        }

        if (bookingToRemove == null) {
            return false;
        }

        bookingToRemove.getApartment().unbookPeriod(bookingToRemove.getPeriod());
        return bookings.remove(bookingToRemove);
    }

    // ---- For UI -----------------

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Booking> getBookings() {
        return bookings;
    }


}
