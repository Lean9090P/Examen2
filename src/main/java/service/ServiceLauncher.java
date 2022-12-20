package service;

import Interface.TerremotoInterfaz;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import model.Terremoto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ServiceLauncher implements TerremotoInterfaz {
    String path = "src/main/resources/terremotos.csv";
    @Override
    public void create(Terremoto terremoto) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path));
            writer.writeNext(new String[]{terremoto.toString()});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Terremoto> read() {
        ArrayList<Terremoto> productos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReader(filereader, CSVParser.DEFAULT_SEPARATOR,
                    CSVParser.DEFAULT_QUOTE_CHARACTER,1);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                LocalDate fecha = LocalDate.parse(nextRecord[3]);
                LocalTime hora = LocalTime.parse(nextRecord[4]);
                productos.add(new Terremoto(Integer.parseInt(nextRecord[0]), Double.parseDouble(nextRecord[1]), nextRecord[2],
                        fecha,hora));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public void update(ArrayList<Terremoto> terremotos) {
        try {
            for (Terremoto t:terremotos) {
            CSVWriter writer = new CSVWriter(new FileWriter(path));
                writer.writeNext(new String[]{t.toString()});
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete() {

    }
}
