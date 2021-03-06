/*
If the x and y attributes of the Tile class are not used by the end of the game,
remove them and edit all code (especially Board.mergeRow) accordingly.
*/

package terminal2048;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;

import terminal2048.Board;


public class Game {

    public static void main(String[] args) throws IOException, InterruptedException {
        // create small animation to test graphics capabilities

        Logger logger = Game.createLoggger();

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen stdscr = new TerminalScreen(terminal);
        // stdscr.startScreen();

        TerminalSize terminal_size = terminal.getTerminalSize();
        TextGraphics graphics = stdscr.newTextGraphics();

        // update virtual screen
        Board board = new Board();
        System.out.println(board.display());
        board.makeMove("right", stdscr, graphics);
        System.out.println(board.display());
        board.makeMove("left", stdscr, graphics);
        System.out.println(board.display());
        board.makeMove("up", stdscr, graphics);
        System.out.println(board.display());
        board.makeMove("down", stdscr, graphics);
        System.out.println(board.display());


        // update real screen
        // while (true) {
        //     stdscr.clear();
        //     String[] canvas_rows = canvas.get_rows();
        //     for ( int i = 0; i < canvas.grid.length; i++) {
        //         graphics.putString(new TerminalPosition(0, i), canvas_rows[i]);
        //     }
        //     stdscr.refresh();

        //     Thread.sleep(100);
        // }
        // stdscr.close();
    }

    private static Logger createLoggger() throws IOException {
        /*
        Creates a Logger and has it write to terminal-2048.log, but not to console.
        */

        FileHandler handler = new FileHandler("terminal-2048.log", true);
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);

        return logger;
    }
}