public class StatisticResult {
    private final String columnName;
    private final double average;
    private final double min;
    private final double max;
    private final int count;

    public StatisticResult(String columnName, double average, double min, double max, int count) {
        this.columnName = columnName;
        this.average = average;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public String getColumnName() {
        return columnName;
    }

    public double getAverage() {
        return average;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Colonne: " + columnName
                + " | Moyenne: " + String.format("%.2f", average)
                + " | Min: " + String.format("%.2f", min)
                + " | Max: " + String.format("%.2f", max)
                + " | Valeurs utilisees: " + count;
    }
}
