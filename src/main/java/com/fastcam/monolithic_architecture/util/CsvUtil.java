package com.fastcam.monolithic_architecture.util;

import com.fastcam.monolithic_architecture.model.Feedback;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtil {
    public static File createCsvFile(List<Feedback> feedbackList, String fileName) throws IOException {
        File csvFile = new File(System.getProperty("java.io.tmpdir"), fileName);
        try (FileWriter writer = new FileWriter(csvFile);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(
                     "Responder", "Satisfaction", "Convenience", "Usefulness", "Stability", "CreatedAt"
             ))) {

            for (Feedback feedback : feedbackList) {
                csvPrinter.printRecord(
                        feedback.getResponder(),
                        feedback.getSatisfaction(),
                        feedback.getConvenience(),
                        feedback.getUsefulness(),
                        feedback.getStability(),
                        feedback.getCreatedAt()
                );
            }
        }
        return csvFile;
    }
}
