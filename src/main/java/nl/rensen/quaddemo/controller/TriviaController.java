package nl.rensen.quaddemo.controller;

import nl.rensen.quaddemo.models.QuestionOutputDto;
import nl.rensen.quaddemo.services.ModelMapper;
import nl.rensen.quaddemo.services.TriviaAPIMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
