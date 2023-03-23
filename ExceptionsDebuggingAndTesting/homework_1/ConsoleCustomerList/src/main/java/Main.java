import org.apache.logging.log4j.*;


import java.util.Scanner;


public class Main {
    private static Logger logger;
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        logger = LogManager.getRootLogger();
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                    setLogger(tokens[0], tokens[1]);
                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                    setLogger(tokens[0]);
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                    setLogger(tokens[0], tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                    setLogger(tokens[0]);
                } else if (tokens[0].equals("help")) {
                    System.out.println(HELP_TEXT);
                    setLogger(tokens[0]);
                } else {
                    logger.error("Не корректная команда: " + tokens[0]);
                    System.out.println(COMMAND_ERROR);

                }
            } catch (IllegalArgumentException ex) {
                logger.error(ex.getMessage());
                System.out.println(ex.getMessage());
            } catch (ArrayIndexOutOfBoundsException ex) {
                logger.error("Не корректный ввод Имени Отчетсва");
                System.out.println("Не корректный ввод Имени Отчетсва");
            }
        }
    }
    private static void setLogger (String command) {
        logger.info("Выполнена куманда " + command);
    }

    private static void setLogger (String command, String text) {
        logger.info("Выполнена куманда " + command + " передано значение: " + text);
    }
}
