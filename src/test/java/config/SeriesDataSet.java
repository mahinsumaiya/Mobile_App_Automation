package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDataSet {
    @DataProvider(name="SeriesDataSet")
    public Object[][] getCSVData() throws IOException {
        String filePath="./src/test/resources/data.csv";
        List<Object[]>data=new ArrayList<>();
        CSVParser csvParser=new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord csvRecord:csvParser){
            String expression=csvRecord.get("expression");
            String result=csvRecord.get("expected_result");
            data.add(new Object[]{expression,result});
        }
        return data.toArray(new Object[0][]);
    }
}
