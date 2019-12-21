package ru.unn.agile.quadraticequation.infrastructure;

import ru.unn.agile.quadraticequation.viewmodel.QuadraticEquationILogger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class QuadraticEquationTxtLogger implements QuadraticEquationILogger {

    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String LOG_FORMAT = "%s > %s";
    private final BufferedWriter writer;
    private final String logFilename;

    private static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW, Locale.ENGLISH);
        return sdf.format(cal.getTime());
    }

    public QuadraticEquationTxtLogger(final String logFilename) {
        this.logFilename = logFilename;

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(logFilename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.writer = writer;
    }

    @Override
    public void log(final String s) {
        try {
            writer.write(String.format(LOG_FORMAT, now(), s));
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<String> getLog() {
        BufferedReader reader;
        ArrayList<String> log = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(logFilename));
            String line = reader.readLine();

            while (line != null) {
                log.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return log;
    }
}
