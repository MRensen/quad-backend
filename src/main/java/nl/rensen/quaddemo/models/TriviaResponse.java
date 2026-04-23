package nl.rensen.quaddemo.models;

import java.util.List;

public class TriviaResponse {
    private Integer response_code;
    private List<QuestionModel> results;

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public List<QuestionModel> getResults() {
        return results;
    }

    public void setResults(List<QuestionModel> results) {
        this.results = results;
    }
}
