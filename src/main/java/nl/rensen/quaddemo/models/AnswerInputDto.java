package nl.rensen.quaddemo.models;

import java.util.UUID;

public class AnswerInputDto {
    private UUID id;
    private String answer;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
