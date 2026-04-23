package nl.rensen.quaddemo.services;

import nl.rensen.quaddemo.models.QuestionModel;
import nl.rensen.quaddemo.models.QuestionOutputDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapper {

    public QuestionOutputDto questionModelToDto(QuestionModel model){
        if(model == null){
            return null;
        }
        return new QuestionOutputDto(
                model.getId(),
                model.getType(),
                model.getDifficulty(),
                model.getCategory(),
                model.getQuestion()
        );
    }

    public List<QuestionOutputDto> questionModelToDto(List<QuestionModel> models){
        return models.stream().map(this::questionModelToDto).toList();
    }
}
