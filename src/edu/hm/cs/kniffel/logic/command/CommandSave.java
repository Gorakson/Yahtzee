package edu.hm.cs.kniffel.logic.command;

import edu.hm.cs.kniffel.interfaces.Saveable;
import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.full.WriteableGame;

/**
 * This command will save an object upon execution.
 * 
 * @author Thomas Pfaffinger
 * @version 1.0
 *
 */
public class CommandSave implements Command {
    
    /** The object that will be saved. */
    private final Saveable saveable;
    /** The path for the output file. */
    private final String path;
    
    /**
     * Ctor with Saveable.
     * @param saveable the object to be saved.
     * @param path the path for the output file
     */
    public CommandSave(Saveable saveable, String path) {
        this.saveable = saveable;
        this.path = path;
    }
    
    @Override
    public CommandResult test(WriteableGame game, Player player) {
        final CommandResult result;
        
        if (game.getState() != GameState.GameOver) {
            result = new CommandResult(false, "The game is not over yet.");
        } else {
            result = new CommandResult();
        }
        
        return result;
    }

    @Override
    public CommandResult execute(WriteableGame game, Player player) {
        final CommandResult result = test(game, player);
        
        if (result.getResult()) {
            saveable.save(path);
        } else {
            throw new IllegalStateException(result.getDescription());
        }
        
        return result;
    }
}
