import lt.techin.municipality.IllegalCitizenException;
import lt.techin.municipality.Municipality;
import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;

import java.util.*;
import java.util.stream.Collectors;

public class NewMun implements Municipality {

    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public void registerCitizen(Person person) throws IllegalCitizenException {

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

//    public static int calculateAge(LocalDate birthDate, Lo) {
//
//    }

    @Override
    public Person findOldestPerson() {


//        persons.stream().map(Person::getDateOfBirth).max(Date::compareTo).get();
//        Person oldestPerson = persons.stream().map(Person::getDateOfBirth).max(Comparator.naturalOrder()).get();


//        Person oldestPerson = persons.stream().filter(a -> a.g)
//        return oldestPerson;

        return null;
    }

    @Override
    public int countAdultCitizens() {

//        int adultCitizens = persons.stream().filter(a -> a.getDateOfBirth());
        return 0;
    }

    @Override
    public double totalIncomeInTaxes() {

//        If (getYearly)
        return 0;
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

        Map<Integer,Person> groupPersonsByDate = persons.sort(a -> );
        return groupPersonsByDate;
    }
}
