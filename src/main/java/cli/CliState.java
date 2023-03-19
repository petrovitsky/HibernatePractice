package cli;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CliState {
    protected final CliFsm fsm;

    public void init() {
    }

    public void newTickedRequested() {

    }

    public void ticketOrdered() {

    }

    public void planetStatsRequested() {

    }

    public void planetStatsPrinted() {

    }

    public void unknownCommand(String cmd) {
    }
}
