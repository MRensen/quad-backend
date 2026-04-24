package nl.rensen.quaddemo.services;

import nl.rensen.quaddemo.exceptions.TriviaApiMapperException;
import nl.rensen.quaddemo.models.QuestionModel;
import nl.rensen.quaddemo.models.QuestionOutputDto;
import nl.rensen.quaddemo.models.TriviaResponse;
import nl.rensen.quaddemo.repositories.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Service
public class TriviaAPIMapper {
    private final RestClient client;
    private final QuestionRepository repos;

    public TriviaAPIMapper(QuestionRepository repos){
        this.repos = repos;
        client = RestClient.builder().baseUrl("https://opentdb.com/").build();
    }

    public List<QuestionModel> getQuestions(Integer amount){
        TriviaResponse response = client
                .get()
                .uri(uri -> uri
                        .path("api.php")
                        .queryParam("amount", amount)
                        .build())
                .attribute("amount", amount)
                .retrieve()
                .body(TriviaResponse.class);
        if(response == null){
            throw new TriviaApiMapperException("Er is ging iets mis bij de API");
        }
        List<QuestionModel> results = response.getResults();
        results.forEach(repos::saveQuestion);
//                q -> {
//            UUID uuid = repos.saveQuestion(q);
//            q.setId(uuid);
//        });
        return results;
    }
}
