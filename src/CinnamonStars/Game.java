package CinnamonStars;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private int red;
    private int black;
    private int table;
    private int numberOfMoves;
    private int numberOfMovesBlockedInARow;

    @AllArgsConstructor
    private static class State {
        int red;
        int black;

        boolean equals(State state) {
            return state.black == this.black && state.red == this.red;
        }
    }

    List<State> pastStates;

    public Game() {
        red = 0;
        black = 0;
        table = 16;
        numberOfMoves = 0;
        numberOfMovesBlockedInARow = 0;

        pastStates = new ArrayList<>();
        pastStates.add(new State(0, 0));
    }

    public void table2Red() {
        if (table > 0 && pastStates.stream().noneMatch(state -> state.equals(new State(red + 1, black)))) {
            red++;
            table--;
            numberOfMoves++;
            pastStates.add(new State(red, black));
            numberOfMovesBlockedInARow = 0;
        } else {
            numberOfMovesBlockedInARow++;
        }
    }

    public void table2Black() {
        if (table > 0 && pastStates.stream().noneMatch(state -> state.equals(new State(red + 1, black)))) {
            black++;
            table--;
            numberOfMoves++;
            pastStates.add(new State(red, black));
            numberOfMovesBlockedInARow = 0;
        } else {
            numberOfMovesBlockedInARow++;
        }
    }

    public void red2Table() {
        if (red > 0 && pastStates.stream().noneMatch(state -> state.equals(new State(red + 1, black)))) {
            red--;
            table++;
            numberOfMoves++;
            pastStates.add(new State(red, black));
            numberOfMovesBlockedInARow = 0;
        } else {
            numberOfMovesBlockedInARow++;
        }
    }

    public void black2Table() {
        if (black > 0 && pastStates.stream().noneMatch(state -> state.equals(new State(red + 1, black)))) {
            black--;
            table++;
            numberOfMoves++;
            pastStates.add(new State(red, black));
            numberOfMovesBlockedInARow = 0;
        } else {
            numberOfMovesBlockedInARow++;
        }
    }
}
