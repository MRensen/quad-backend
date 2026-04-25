package nl.rensen.quaddemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.UUID;

/*
Gemodelleerd naar:
   {
      "type": "multiple",
      "difficulty": "medium",
      "category": "Entertainment: Comics",
      "question": "Which of the following superheros did Wonder Woman NOT have a love interest in?",
      "correct_answer": "Green Arrow",
      "incorrect_answers": [
        "Superman",
        "Batman",
        "Steve Trevor"
      ]
    }
 */
public class QuestionOutputDto {
    private UUID id;
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private List<String> answers;

    public QuestionOutputDto(UUID id, String type, String difficulty, String category, String question, List<String> answers) {
        this.id = id;
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.answers = answers;
    }

    public QuestionOutputDto() {
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
