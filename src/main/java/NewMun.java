import lt.techin.municipality.IllegalCitizenException;
import lt.techin.municipality.Municipality;
import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;
import org.opentest4j.AssertionFailedError;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class NewMun implements Municipality {

    private ArrayList<Person> persons = new ArrayList<>();

    public Person findPersonByName(String name) {

        Person person = persons.stream().filter(a -> a.getFirstName().equals(name)).findFirst().orElse(null);

        return person;
    }

    public boolean isThisPerson(String name) {

        return persons.stream().map(a -> a.getFirstName().equals(name)).findAny().get();

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

//    public static int calculateAge(LocalDate birthDate, Lo) {
//
//    }

    @Override
    public Person findOldestPerson() {


        Person oldestPerson = persons.stream().max(Comparator.comparing(Person::getDateOfBirth)).get();
//        Person oldestPerson = persons.stream().map(Person::getDateOfBirth).max(Comparator.naturalOrder()).get();


//        Person oldestPerson = persons.stream().filter(a -> a.g)
//        return oldestPerson;

        return oldestPerson;
    }

    @Override
    public int countAdultCitizens() {

        LocalDate now = LocalDate.now();
//        Period period = Period.between()

        LocalDate date18yearsAgo = LocalDate.now().minusYears(18);

//        int count = persons.stream().mapToInt(a -> a.getDateOfBirth() <= date18yearsAgo).count();


//        LocalDate date = persons.getDateOfBirth();
//        LocalDate date18yearsAgo = LocalDate.now().minusYears(18);


//        long age = new Date().getTime() - getBirthDate().getTime();

//        Date age1 = new Date(age);

//        int adultCitizens =

//        int adultCitizens = persons.stream().filter(a -> a.getDateOfBirth());
        return 0;
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

//        Map<Integer,Person> groupPersonsByDate = persons.sort(a -> );
//        return groupPersonsByDate;
        return null;
    }
}
