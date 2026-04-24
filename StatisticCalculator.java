import java.util.ArrayList;
import java.util.List;

public class StatisticCalculator {
    public List<StatisticResult> calculateStatistics(List<String[]> data) {
        List<StatisticResult> results = new ArrayList<>();

        if (data == null || data.size() < 2) {
            return results;
        }

        String[] headers = null;
        int headerIndex = -1;

        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i);
            if (row.length > 0 && row[0] != null && row[0].trim().equalsIgnoreCase("ID")) {
                headers = row;
                headerIndex = i;
                break;
            }
        }

        if (headers == null) {
            return results;
        }

        for (int col = 0; col < headers.length; col++) {
            List<Double> numbers = new ArrayList<>();

            for (int row = headerIndex + 1; row < data.size(); row++) {
                String[] currentRow = data.get(row);
                if (col < currentRow.length) {
                    String value = currentRow[col].trim();
                    if (!value.isEmpty()) {
                        try {
                            numbers.add(Double.parseDouble(value));
                        } catch (NumberFormatException e) {
                            // colonne non numerique, on ignore cette cellule
                        }
                    }
                }
            }

            if (!numbers.isEmpty()) {
                double sum = 0;
                double min = numbers.get(0);
                double max = numbers.get(0);

                for (double number : numbers) {
                    sum += number;
                    if (number < min) {
                        min = number;
                    }
                    if (number > max) {
                        max = number;
                    }
                }

                double average = sum / numbers.size();
                results.add(new StatisticResult(headers[col], average, min, max, numbers.size()));
            }
        }

        return results;
    }
}
