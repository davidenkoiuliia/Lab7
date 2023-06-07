import client.ConsoleUI;
import server.commands.Invoker;
import server.exceptions.FileException;

/**
 * The type App.
 */
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            String myVar = System.getenv("DB");
            if (myVar != null) {
                ConsoleUI session = new ConsoleUI(new Invoker(myVar));
                session.start();
            } else {
                System.out.println("DB is not set. It is environment variable");
            }
        } catch (FileException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо ввести название файла базы данных при запуске программы.");
        }
    }
}
