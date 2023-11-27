import lt.techin.municipality.Municipality;
import lt.techin.municipality.TaxCalculator;
import lt.techin.municipality.TaxRateProvider;
import lt.techin.municipality.test.AbstractMunicipalityTest;

public class MyTest extends AbstractMunicipalityTest {
    @Override
    public Municipality getMunicipality(TaxCalculator taxCalculator) {
        return new NewMun();
    }

    @Override
    public TaxCalculator getTaxCalculator(TaxRateProvider taxRateProvider) {
        return null;
    }
}
