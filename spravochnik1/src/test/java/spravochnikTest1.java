//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import ru.vsu.model.*;
//import ru.vsu.config.Config;
//import ru.vsu.controller.AbonentController;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@ContextConfiguration(classes = Config.class)
//@WebAppConfiguration
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class spravochnikTest1 {
//    @Autowired
//    private AbonentController abonentController;
//    private final abonent chelovec = new abonent("Вепринцев","Даниил","79622762011","79622762012","79622762013");
//
//    @Test
//    @Order(1)
//    public void createAbonTest() {
//        int id = abonentController.createAbon(chelovec.gsurname(), chelovec.gname(), chelovec.gtelefon1(), chelovec.gtelefon2(),chelovec.gtelefon3());
//        abonent ab = abonentController.show(id).getBody();
//        Assertions.assertEquals(chelovec, ab);
//    }
//
//    @Order(2)
//    @Test
//    public void deleteTest(){
//        int id = abonentController.createAbon(chelovec.gsurname(), chelovec.gname(), chelovec.gtelefon1(), chelovec.gtelefon2(),chelovec.gtelefon3());
//        abonentController.delete(id);
//        abonent ab = abonentController.show(id).getBody();
//        Assertions.assertNull(ab);
//    }
//    @Order(3)
//    @Test
//    public void showAllTest(){
//        List<abonent> excpectedList = new ArrayList<>();
//        excpectedList.add(chelovec);
//        Assertions.assertEquals(excpectedList, abonentController.showAbonen().getBody());
//    }
//
//    @Order(4)
//    @Test
//    public void editAbonTest(){
//        int id = abonentController.createAbon(chelovec.gsurname(), chelovec.gname(), chelovec.gtelefon1(), chelovec.gtelefon2(),chelovec.gtelefon3());
//        chelovec.setsurname("Даниил");
//        chelovec.setname("Вепринцев");
//        chelovec.settelefon1("79622762016");
//        chelovec.settelefon2("79622762017");
//        chelovec.settelefon3("79622762018");
//        abonentController.updateAbon(id, chelovec.gsurname(), chelovec.gname(), chelovec.gtelefon1(), chelovec.gtelefon2(),chelovec.gtelefon3());
//        Assertions.assertEquals(chelovec, abonentController.show(id).getBody());
//    }
//}
