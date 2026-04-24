package nl.rensen.quaddemo.repositories;

import nl.rensen.quaddemo.exceptions.TriviaDatabaseException;
import nl.rensen.quaddemo.models.QuestionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestionRepositoryTest {
    QuestionModel question;
    QuestionRepository questionRepository;

    @BeforeEach
    void setup(){
        questionRepository = new QuestionRepository();
        question = new QuestionModel(
                "type",
                "difficulty",
                "category",
                "question",
                "correct_answer",
                List.of("incorrect_answer")
        );
    }

    @Test
    void saveQuestion() {
        // arrange
        // act
        UUID uuid = questionRepository.saveQuestion(question);
        // assert
        assertNotNull(uuid);
    }

    @Test
    void getQuestion() {
        // arrange
        UUID uuid = questionRepository.saveQuestion(question);
        // act
        QuestionModel result = questionRepository.getQuestion(uuid);
        // assert
        assertEquals(question, result);
    }

    @Test
    void getNonExistingQuestionResultsInException(){
        // arrange
        UUID uuid = UUID.randomUUID(); // random uuid dat niet bestaat in de bd
        // act
        // assert
        assertThrows(TriviaDatabaseException.class, ()->questionRepository.getQuestion(uuid));

    }
}