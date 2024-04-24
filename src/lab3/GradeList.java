package lab3;

import java.util.ArrayList;

public class GradeList {
    private final ArrayList<Float> grades = new ArrayList<>();

    public void addGrade(float grade) throws IllegalArgumentException{
        if (grade > 0) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Podana ocena jest nieprawidłowa");
        }
    }
    public float getMean () {
        final float size = grades.size();
        if (size == 0) return 0;
        else {
        float sum = 0;
        for (float elem: this.grades) {
            sum += elem;
        }
        return  sum / size;
        }
    }

    public float getHighestGrade() {
        if (grades.isEmpty()) return 0;
        else {
            float highest = grades.getFirst();
            for (float grade : grades) {
                if (grade > highest) {
                    highest = grade;
                }
            }
            return  highest;
        }
    }

    public float getSmallestGrade() {
        if (grades.isEmpty()) return 0;
        else {
            float smallest = grades.getFirst();
            for (float grade: grades) {
                if (grade < smallest) {
                    smallest = grade;
                }
            }
            return  smallest;
        }
    }

}
