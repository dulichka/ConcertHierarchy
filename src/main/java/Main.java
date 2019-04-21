import controller.Controller;
import model.Concert;
import view.View;

/**
 * This is the starting point of the program
 *
 * @author dulichka
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Concert(), new View());
        controller.controlUser();
    }
}
