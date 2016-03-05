import java.util.List;

/**
 * Created by Mykolai_Lytvyn on 01.03.2016.
 */
public interface QuizDao {
    Quiz selectByID(int id);

    List<Quiz> selectAll();
}
