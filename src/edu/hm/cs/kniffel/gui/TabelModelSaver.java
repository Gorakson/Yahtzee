package edu.hm.cs.kniffel.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.table.TableModel;

import edu.hm.cs.kniffel.interfaces.Saveable;

/**
 * Saves a ScoreBoard.
 * @author Thomas Pfaffinger, thomas.paffinger@hm.edu
 * @version 1.0
 *
 */
public class TabelModelSaver implements Saveable {
    /** The model of the ScoreBoard to save. */
    private final TableModel model;
    
    /** 
     * Ctor.
     * @param scoreBoard The model of the ScoreBoard to save. 
     */
    public TabelModelSaver(TableModel scoreBoard) {
        this.model = scoreBoard;
    }

    @Override
    public void save(String path) {
        BufferedWriter writer = null;
        try {
            final String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            final File logFile = new File(timeLog + ".txt");
            logFile.createNewFile();
            writer = new BufferedWriter(new FileWriter(logFile));
            
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.write(String.format("%20s\t", model.getColumnName(col)));
            }
            
            writer.write(System.lineSeparator());
            
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(String.format("%20s\t", model.getValueAt(row, col).toString()));
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException exception) {
            }
        }
    }
}
