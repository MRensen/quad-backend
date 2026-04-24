package nl.rensen.quaddemo.services;

import nl.rensen.quaddemo.models.QuestionModel;
import nl.rensen.quaddemo.repositories.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TriviaAPIMapperTest {

    @Mock
    QuestionRepository repos;
    @InjectMocks
    TriviaAPIMapper triviaAPIMapper;

    @Test
    void getQuestionsReturnsListQuestions() {
        // arrange
        UUID uuid = UUID.randomUUID();
        Mockito.when(repos.saveQuestion(any())).thenReturn(uuid);
        // act
        List<QuestionModel> result = triviaAPIMapper.getQuestions(10);
        // assert
        for(QuestionModel question : result) {
            assertNotNull(question.getQuestion());
            assertNotNull(question.getType());
            assertNotNull(question.getCategory());
            assertNotNull(question.getDifficulty());
            assertNotNull(question.getCorrect_answer());
            assertNotNull(question.getIncorrect_answers());
//            Het id wordt niet gezet in deze mock, maar wordt al wel in een andere unittest geverifieerd
//            assertEquals(uuid, question.getId());
        }

//        TODO test voor getAnswer
    }
}