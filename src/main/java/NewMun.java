import lt.techin.municipality.IllegalCitizenException;
import lt.techin.municipality.Municipality;
import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;
import org.opentest4j.AssertionFailedError;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;

public class NewMun implements Municipality {

    private ArrayList<Person> persons = new ArrayList<>();

    public Person findPersonByName(String name) {

        Person person = persons.stream().filter(a -> a.getFirstName().equals(name)).findFirst().orElse(null);

        return person;
    }

    public boolean isThisPerson(String name) {

        return persons.stream().map(a -> a.getFirstName().equals(name)).findAny().get();

    }

    public static int calc(LocalDate birthday, LocalDate currentDate) {
        if ((birthday != null) && (currentDate != null)) {
            return Period.between(birthday, currentDate).getYears();
        }
        return 0;
    }


    @Override
    public void registerCitizen(Person person) throws IllegalCitizenException {

        LocalDate now = LocalDate.now();

        if (person.getFirstName() == null || person.getLastName() == null || person.getDateOfBirth() == null || person.getYearlyIncome() < 0 || !now.isAfter(person.getDateOfBirth())) {
            throw new IllegalCitizenException(person);
        }

        if (!persons.contains(person)) {
            persons.add(person);
        }

    }

    @Override
    public int getCitizenCount() {

        return persons.size();
    }

    @Override
    public double getAverageCitizenIncome() {

        double averageIncome = persons.stream().mapToDouble(a -> a.getYearlyIncome()).average().orElse(0.0);
        return averageIncome;
    }

    @Override
    public boolean isRegisteredCitizen(Person person) {

        return persons.contains(person);

    }

    @Override
    public Person findOldestPerson() {

        Person oldestPerson = persons.stream().min(Comparator.comparing(Person::getDateOfBirth)).get();

        return oldestPerson;
    }

    @Override
    public int countAdultCitizens() {

        LocalDate now = LocalDate.now();

        int count = (int) persons.stream().filter(a -> calc(a.getDateOfBirth(), now) >= 18).count();

        return count;
    }

    @Override
    public double totalIncomeInTaxes() {

        double sum = 0;

        for (Person person : persons) {
            if (person.getYearlyIncome() < 14000) {
                continue;
            } else if (person.getYearlyIncome() > 1000000) {
                sum += person.getYearlyIncome() * 0.84;
            }
            sum += person.getYearlyIncome() * 0.85;
        }

        return sum;
    }

    @Override
    public Collection<Person> findCitizensBy(PersonPredicate personPredicate) {
        return persons.stream().filter(a -> personPredicate.test(a)).collect(Collectors.toList());
    }

    @Override
    public Collection<Person> getOrderedCitizens() {

        return persons.stream().sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName)).collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Person>> groupByYearOfBirth() {

//        SimpleDateFormat format = new SimpleDateFormat();
//        Data date = format.parse();
//        SimpleDateFormat echh = new SimpleDateFormat("yyyy");
//        String year = echh.format(date);
//
//        return persons.stream().collect(groupingBy(persons::));
//        Map<Integer, List<Person>> pp = persons.stream().collect(groupingBy(Person::getDateOfBirth));
//        return pp;
        return null;

    }
}
