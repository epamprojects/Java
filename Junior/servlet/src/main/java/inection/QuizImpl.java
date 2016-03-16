package inection;

import interfaces.Quiz;

/**
 * Created by Mykolai_Lytvyn on 02.03.2016.
 */
public class QuizImpl implements Quiz {
    private String name;

    public QuizImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
