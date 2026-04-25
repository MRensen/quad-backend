package nl.rensen.quaddemo.controller;

import nl.rensen.quaddemo.models.AnswerInputDto;
import nl.rensen.quaddemo.models.QuestionOutputDto;
import nl.rensen.quaddemo.services.ModelMapper;
import nl.rensen.quaddemo.services.TriviaAPIMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TriviaController {

    private final TriviaAPIMapper triviaAPIMapper;
    private final ModelMapper modelMapper;

    public TriviaController(TriviaAPIMapper triviaAPIMapper, ModelMapper modelMapper) {
        this.triviaAPIMapper = triviaAPIMapper;
        this.modelMapper = modelMapper;
    }

    /**
     * Haal de vragen van de API op
     * @param amount (Optioneel) hoeveel vragen. Default = 10
     * @return Vragenlijst zonder antwoorden
     */
    @GetMapping("/questions")
    public ResponseEntity<List<QuestionOutputDto>> getQuestions(@RequestParam(required = false) Integer amount){
        return ResponseEntity.ok(modelMapper.questionModelToDto(triviaAPIMapper.getQuestions(amount != null ? amount : 10)));
    }

    @PostMapping("/checkanswers")
    public ResponseEntity<Map<UUID, Boolean>> checkAnswers (@RequestBody List<AnswerInputDto> dtos){
        Map<UUID, Boolean> result = triviaAPIMapper.checkAnswers(dtos);
        return ResponseEntity.ok(result);
    }
}
