package studyReact.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import studyReact.exceptions.FilmNotFoundException;
import studyReact.models.Film;
import studyReact.models.FilmType;
import studyReact.services.FilmService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions extends CommonStep {


    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl = "http://localhost";

    private Long filmId = null;

    @Autowired
    private FilmService filmService;

    @DataTableType
    public Film defineFilm(Map<String, String> entry) {
        Film film = new Film();
        film.setDuration(Long.valueOf(entry.get("duration")));
        film.setName(entry.get("name"));
        return film;
    }

    @Given("existing Film")
    public void putUserIntoDB(DataTable dataTable) {
        List<Film> films = new ArrayList<>(dataTable.asList(Film.class));
        films.forEach(film -> {
            filmService.save(film);
        });
    }

    @Given("Application started")
    @Transactional
    @Modifying
    public void applicationStarted() {
        filmService.deleteAll();
        filmService.deleteSequence();
    }

    @When("called POST method for {string} for create new Film  with request content {string}")
    public void saveFilm(String url, String film) {
        executePost("http://localhost:" + port + url, film);
    }

    @Then("response contains status code {int}")
    public void response_contains_status_code(Integer statusCode) throws IOException {
        int currentStatusCode = response.getResponse().getStatusCode().value();
        assertThat("status code is incorrect : " + response.getBody(), currentStatusCode, is(statusCode));
    }

    @Then("assert that the database contains Film")
    public void assert_that_Film_has(DataTable dataTable) throws FilmNotFoundException {
        List<Film> films = new ArrayList<>(dataTable.asList(Film.class));
        for (Film film : films) {
            Film actualFilm = filmService.findFilmByName(film.getName());
            if (actualFilm != null) {
                compareFilm(actualFilm, film);
            } else {
                Assertions.assertThat(false)
                        .overridingErrorMessage("Expected Configuration with Name %s does not exist", film.getName())
                        .isTrue();
            }
        }
    }

    @And("assert that Film not exists")
    public void configurationNotExists(DataTable dataTable) {
        List<Film> films = new ArrayList<>(dataTable.asList(Film.class));
        for (Film film : films) {
            Film actualFilm = null;
            try {
                actualFilm = filmService.findFilmByName(film.getName());
            } catch (FilmNotFoundException e) {
                actualFilm=null;
            }
            if (actualFilm != null) {
                Assertions.assertThat(false)
                        .overridingErrorMessage("Expected Film with name %s does not exist", film.getName())
                        .isTrue();
            }
        }
    }

    @When("called GET method for {string} for find Film")
    public void called_GET_method_for_for_find_Film(String url) {
        executeGet("http://localhost:" + port + url);
    }

    @When("called DELETE method for {string} for delete Film")
    @Transactional
    @Modifying
    public void alled_DELETE_method_for_for_find_Film(String url) {
        executeDelete("http://localhost:" + port + url);
    }


    private void compareFilm(Film actualFilm, Film expectedFilm) {
        Assertions.assertThat(expectedFilm.getDuration())
                .overridingErrorMessage("Expected Film with Duration %s but had %s",
                        expectedFilm.getDuration(), expectedFilm.getName())
                .isEqualTo(actualFilm.getDuration());
        Assertions.assertThat(expectedFilm.getDuration())
                .overridingErrorMessage("Expected Film with Duration %s but had %s",
                        expectedFilm.getDuration(), expectedFilm.getName())
                .isEqualTo(actualFilm.getDuration());
    }

}
