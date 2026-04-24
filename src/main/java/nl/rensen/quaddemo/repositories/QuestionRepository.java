package nl.rensen.quaddemo.repositories;

import nl.rensen.quaddemo.exceptions.TriviaDatabaseException;
import nl.rensen.quaddemo.models.QuestionModel;
import nl.rensen.quaddemo.models.QuestionOutputDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * De opdracht gaf de suggestie om geen database te gebruiken, dus daarom deze mock-database.
 * Ik heb hierbij gekozen voor een map met UUID keys, om gemakkelijk unieke keys te kunnen genereren.
 */
@Component
public class QuestionRepository {
    private final Map<UUID, QuestionModel> db;

    public QuestionRepository(){
        db = new HashMap<>();
    }

    public UUID saveQuestion(QuestionModel question){
        UUID uuid = UUID.randomUUID();
        db.put(uuid, question);
        question.setId(uuid);
        return uuid;
    }

    public QuestionModel getQuestion(UUID uuid){
        QuestionModel question = db.get(uuid);
        if(question == null){
            throw new TriviaDatabaseException("Question met id " + uuid + " niet gevonden");
        }
        return question;
    }
}
