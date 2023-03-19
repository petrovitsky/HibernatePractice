package cli;

public class IdleState extends CliState {
    public IdleState(CliFsm fsm) {
        super(fsm);
    }

    @Override
    public void newTickedRequested() {
        fsm.setState(new AddTicketState(fsm)) ;
    }

    @Override
    public void planetStatsRequested() {
        fsm.setState(new PlanetStatsState(fsm));
    }

    @Override
    public void unknownCommand(String cmd) {
        System.out.println(("Unknown command: " + cmd));
    }
}
