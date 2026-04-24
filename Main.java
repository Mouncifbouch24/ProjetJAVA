import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "donnees_exemple.csv";
        String outputFile = "statistiques.txt";

        CSVReader reader = new CSVReader();
        StatisticCalculator calculator = new StatisticCalculator();
        ReportGenerator reportGenerator = new ReportGenerator();

        try {
            List<String[]> data = reader.readCSV(inputFile);
            List<StatisticResult> results = calculator.calculateStatistics(data);

            if (results.isEmpty()) {
                System.out.println("Aucune colonne numerique trouvee dans le fichier.");
                return;
            }

            System.out.println("Resultats de l'analyse :");
            for (StatisticResult result : results) {
                System.out.println(result);
            }

            reportGenerator.saveReport(outputFile, results);
            System.out.println("\nLe rapport a ete enregistre dans : " + outputFile);

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture ou de l'ecriture du fichier : " + e.getMessage());
        }
    }
}
