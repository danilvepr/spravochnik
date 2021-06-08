import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.vsu.Manager;
import ru.vsu.config.Config;
import ru.vsu.controller.AbonentController;
import ru.vsu.model.abonent;

import java.util.Arrays;

import static javafx.beans.binding.Bindings.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
//@WebMvcMock
//@WebMvcTest(AbonentController.class)
@EnableTransactionManagement
public class test {

    private MockMvc mockMvc;

    @Autowired
    private AbonentController abonentController;
    @Autowired
    private Manager manager;

    @Autowired
    public test() {

    }

    @Test
    public void createabon() throws Exception {
        abonent abon1 = new abonent("dada", "swaq", "2", "1", "4");
        abon1.setId(1);
        when(abonentController.showAbonen()).thenReturn(Arrays.asList(abon1));

        mockMvc.perform(get("/abonent"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].surname", is("dada")))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("swaq")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon1", is("2")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon2", is("1")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon3", is("4")));
    }
    @Test
    public void updateabon() throws Exception {
        abonent abon1 = new abonent("dada", "swaq", "2", "1", "4");
        abon1.setId(1);
        abonentController.updateAbon(1,"d","a","3","2","1");
        when(abonentController.showAbonen()).thenReturn(Arrays.asList(abon1));

        mockMvc.perform(put("/abonent"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].surname", is("d")))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("a")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon1", is("3")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon2", is("2")))
                .andExpect((ResultMatcher) jsonPath("$[0].telefon3", is("1")));
    }

}