package cli;

import lombok.Getter;
import lombok.Setter;
import storage.ConnectionProvider;

import java.util.Scanner;

public class CliFsm {
    private CliState state;
    @Getter
    private Scanner scanner;
    @Getter
    private ConnectionProvider connectionProvider;

    public CliFsm(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;

        state = new IdleState(this);
        scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "exit":
                    System.exit(0);
                    break;
                case "addTicket":
                    newTickedRequested();
                    break;
                case "planetStats":
                        planetStatsRequested();
                    break;
                default:
                    unknownCommand(command);
            }
        }
    }

    public void setState(CliState state) {
        System.out.println( "Set state " + state.getClass());
        this.state = state;
        state.init();
    }

    public void newTickedRequested() {
        state.newTickedRequested();
    }

    public void ticketOrdered() {
        state.ticketOrdered();
    }

    public void planetStatsRequested() {
        state.planetStatsRequested();
    }

    public void planetStatsPrinted() {
        state.planetStatsPrinted();
    }

    public void unknownCommand(String cmd) {
        state.unknownCommand(cmd);
    }
}
