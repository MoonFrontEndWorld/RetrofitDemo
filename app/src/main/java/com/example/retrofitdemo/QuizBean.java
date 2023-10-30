package com.example.retrofitdemo;

import java.util.List;

public class QuizBean {
    private int response_code;
    private List<QuizQuestion> results;

    public int getResponseCode() {
        return response_code;
    }

    public List<QuizQuestion> getResults() {
        return results;
    }

    public static class QuizQuestion{
        private String category;
        private String type;
        private String difficulty;
        private String question;
        private String correct_answer;
        private List<String> incorrect_answers;

        public String getCategory() {
            return category;
        }

        public String getType() {
            return type;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public String getQuestion() {
            return question;
        }

        public String getCorrectAnswer() {
            return correct_answer;
        }

        public List<String> getIncorrectAnswers() {
            return incorrect_answers;
        }
    }
}

