package ru.unn.agile.studentsperformance.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.StudentsPerformance.Model.PerformanceCalculator;
import ru.unn.agile.StudentsPerformance.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {

    private static final int EXCELLENT_MARK = 5;
    private static final int GOOD_MARK = 4;
    private static final int SATISFACTORY_MARK = 3;
    private static final int BAD_MARK = 2;

    private static final String MARKS_DELIMITER = " ";
    private static final String EMPTY = "";

    private ListProperty<Integer> marksProperty = new SimpleListProperty<>(
            FXCollections.observableArrayList(
                    BAD_MARK,
                    SATISFACTORY_MARK,
                    GOOD_MARK,
                    EXCELLENT_MARK
            )
    );

    private ObjectProperty<Integer> mathsMarkProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Integer> englishMarkProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Integer> historyMarkProperty = new SimpleObjectProperty<>();
    private ObjectProperty<Integer> programmingMarkProperty = new SimpleObjectProperty<>();
    private ListProperty<String> marksListProperty = new SimpleListProperty<>();

    private StringProperty averageProperty = new SimpleStringProperty();
    private StringProperty excellentCountProperty = new SimpleStringProperty();
    private StringProperty goodCountProperty = new SimpleStringProperty();
    private StringProperty satisfactoryCountProperty = new SimpleStringProperty();
    private StringProperty badCountProperty = new SimpleStringProperty();

    private List<Student> studentMarks = new ArrayList<>();

    public ViewModel() {
        mathsMarkProperty.setValue(BAD_MARK);
        englishMarkProperty.setValue(BAD_MARK);
        historyMarkProperty.setValue(BAD_MARK);
        programmingMarkProperty.setValue(BAD_MARK);
        marksListProperty.set(FXCollections.observableArrayList());
        averageProperty.set(EMPTY);
    }

    public ObservableList<Integer> marksProperty() {
        return marksProperty.get();
    }

    public Property<Integer> mathsMarkProperty() {
        return mathsMarkProperty;
    }

    public Property<Integer> englishMarkProperty() {
        return englishMarkProperty;
    }

    public Property<Integer> historyMarkProperty() {
        return historyMarkProperty;
    }

    public Property<Integer> programmingMarkProperty() {
        return programmingMarkProperty;
    }

    public ListProperty<String> marksListProperty() {
        return marksListProperty;
    }

    public StringProperty averageProperty() {
        return averageProperty;
    }

    public StringProperty excellentCountProperty() {
        return excellentCountProperty;
    }

    public StringProperty goodCountProperty() {
        return goodCountProperty;
    }

    public StringProperty satisfactoryCountProperty() {
        return satisfactoryCountProperty;
    }

    public StringProperty badCountProperty() {
        return badCountProperty;
    }

    public void addStudent() {
        var marks = new ArrayList<Integer>() {{
            add(mathsMarkProperty.get());
            add(englishMarkProperty.get());
            add(historyMarkProperty.get());
            add(programmingMarkProperty.get());
        }};
        studentMarks.add(new Student(marks));
        marksListProperty.add(
                String.join(
                        MARKS_DELIMITER, marks.stream().map(String::valueOf).toArray(String[]::new)
                )
        );
        calculateAll();
    }

    public void clearEnteredMarks() {
        studentMarks.clear();
        marksListProperty.clear();
        calculateAll();
    }

    private void calculateAll() {
        calculateAverage();
        calculateExcellentStudentsCount();
        calculateGoodStudentsCount();
        calculateSatisfactoryStudentsCount();
        calculateBadStudentsCount();
    }

    private void calculateAverage() {
        if (studentMarks.isEmpty()) {
            averageProperty.set(EMPTY);
            return;
        }
        averageProperty.set(
                String.valueOf(new PerformanceCalculator(studentMarks).getAverageRating())
        );
    }

    private void calculateExcellentStudentsCount() {
        if (studentMarks.isEmpty()) {
            excellentCountProperty.set(EMPTY);
            return;
        }
        excellentCountProperty.set(
                String.valueOf(new PerformanceCalculator(studentMarks).getExcellentStudentsCount())
        );
    }

    private void calculateGoodStudentsCount() {
        if (studentMarks.isEmpty()) {
            goodCountProperty.set(EMPTY);
            return;
        }
        goodCountProperty.set(
                String.valueOf(new PerformanceCalculator(studentMarks).getGoodStudentsCount())
        );
    }

    private void calculateSatisfactoryStudentsCount() {
        if (studentMarks.isEmpty()) {
            satisfactoryCountProperty.set(EMPTY);
            return;
        }
        satisfactoryCountProperty.set(String.valueOf(
                new PerformanceCalculator(studentMarks).getSatisfactoryStudentsCount()
                )
        );
    }

    private void calculateBadStudentsCount() {
        if (studentMarks.isEmpty()) {
            badCountProperty.set(EMPTY);
            return;
        }
        badCountProperty.set(
                String.valueOf(new PerformanceCalculator(studentMarks).getBadStudentsCount())
        );
    }
}
