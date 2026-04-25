package nl.rensen.quaddemo.controller;

import nl.rensen.quaddemo.models.QuestionModel;
import nl.rensen.quaddemo.repositories.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TriviaControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    QuestionRepository repos;

    @Test
    void getQuestion() throws Exception {
        mvc.perform(get("/api/questions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10));
    }

    @Test
    void getAnswersTrue() throws Exception {
        // arrange
        UUID uuid = repos.saveQuestion(new QuestionModel("test", "easy", "test", "Wat is een test?", "Een test", List.of("Geen test", "Een banaan")));
        // act
        mvc.perform(post("/api/checkanswers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[\n{\n\t\"id\":\""+uuid+"\",\n\"answer\":\"Een test\"\n}\n]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$."+uuid).value(true));

    }

    @Test
    void getAnswersFalse() throws Exception {
        // arrange
        UUID uuid = repos.saveQuestion(new QuestionModel("test", "easy", "test", "Wat is een test?", "Een test", List.of("Geen test", "Een banaan")));
        // act
        mvc.perform(post("/api/checkanswers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[\n{\n\t\"id\":\""+uuid+"\",\n\"answer\":\"Een banaan\"\n}\n]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$."+uuid).value(false));

    }

}