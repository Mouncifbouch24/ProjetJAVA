import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportGenerator {
    public void saveReport(String filePath, List<StatisticResult> results) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Rapport statistique");
            writer.println("===================");
            for (StatisticResult result : results) {
                writer.println(result);
            }
        }
    }
}
