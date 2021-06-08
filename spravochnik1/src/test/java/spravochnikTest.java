import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.controller.AbonentController;
import ru.vsu.model.abonent;

class spravochnikTest {

    private AbonentController controller;

    public spravochnikTest(AbonentController controller) {
        this.controller = controller;
    }

    @Test
    void getAll() {
        Assertions.assertTrue(controller.showAbonen().isEmpty());
    }

    @Test
    void createAbon() {
        String surname = "Вепринцев";
        String name = "Даниил";
        String telefon1 = "79622762016";
        String telefon2 = "79622762026";
        String telefon3 = "79622762036";
        controller.createAbon(surname,name,telefon1,telefon2,telefon3);
        Assertions.assertEquals(1,controller.showAbonen().size());
    }

    @Test
    void delete() {
        String surname = "Вепринцев";
        String name = "Даниил";
        String telefon1 = "79622762016";
        String telefon2 = "79622762026";
        String telefon3 = "79622762036";
        controller.createAbon(surname,name,telefon1,telefon2,telefon3);
        controller.delete(1);
        Assertions.assertEquals(0,controller.showAbonen().size());
    }

    @Test
    void updateAbon() {
        abonent abon1 = new abonent("dada","swaq","2","1","4");
        abonent abon = controller.updateAbon(2,"ghoul","sss","1","2","3");
        Assertions.assertEquals(abon1,abon);
    }
}
