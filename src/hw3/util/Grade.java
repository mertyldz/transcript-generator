package hw3.util;

public enum Grade {
    F("F", 0),
    D("D", 1),
    C("C", 2),
    B("B", 3),
    A("A", 4);

    final String stringValue;
    final double numericValue;

    Grade(String stringValue, double numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }


    public String getStringValue() {
        return stringValue;
    }

    public double getNumericValue() {
        return numericValue;
    }

    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + numericValue;
    }
}
