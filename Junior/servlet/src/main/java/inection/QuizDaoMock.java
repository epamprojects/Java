package inection;

import interfaces.Quiz;
import interfaces.QuizDao;

import java.util.*;

/**
 * Created by Mykolai_Lytvyn on 01.03.2016.
 */
public class QuizDaoMock implements QuizDao {
    private Map<Integer, Quiz> memory = new TreeMap<Integer, Quiz>();

    public QuizDaoMock(){
        this.memory.put(1, new QuizImpl("first"));
        this.memory.put(2, new QuizImpl("second"));
        this.memory.put(3, new QuizImpl("third"));
    }

    @Override
    public Quiz selectByID(int id) {
        return this.memory.get(id);
    }

    @Override
    public List<Quiz> selectAll() {
        return new ArrayList<Quiz>(this.memory.values());
    }
}
