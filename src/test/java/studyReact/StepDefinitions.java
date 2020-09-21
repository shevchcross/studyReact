package studyReact;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;
import studyReact.models.Film;
import studyReact.models.FilmType;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {


    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl = "http://localhost";

    private Long filmId = null;


    @Given("I can create a new Film")
    public void i_can_create_a_new_Film() {
        String url = postUrl + ":" + port + "/films";
        List<Film> allPost = restTemplate.getForObject(url, List.class);
        log.info(allPost);
        assertTrue(!allPost.isEmpty());
    }

    @Given("I sending post to be created film with duration {int}, name New film and filmType T_3D")
    public void i_sending_post_to_be_created_film(Long duration, String name, FilmType filmType) {
        String url = postUrl + ":" + port + "/post";
        Film newFilm = new Film();
        newFilm.setDuration(duration);
        newFilm.setName(name);
        newFilm.setFilmType(filmType);
        Film film = restTemplate.postForObject(url, newFilm, Film.class);
        filmId = film.getId();
        log.info(film);
        assertNotNull(film);
    }

    @Then("I should be able to see my newly created film")
    public void i_should_be_able_to_see_my_newly_created_film() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
