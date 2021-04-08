package com.lplinfo.Cadmus;

import ch.qos.logback.core.util.StringCollectionUtil;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.yaml.snakeyaml.util.ArrayUtils;

@Getter
@ToString
@AllArgsConstructor
public class TripJson {

    public String trip;
    public String origin;
    public String destiny;
    public String departureDate;
    public String departure;
    public String arrival;
    public String value;

    public TripJson() {
    }

    //public TripJson(String s, String s1, String s2, String s3, String s4, String s5, String s6) { }

    public List<TripJson> loadTripCSVList() throws IOException {

        String path = ".\\dataFiles\\iTrain.csv";

        List<TripJson> csvToClass = new ArrayList<TripJson>();

        lines(Paths.get(path))
                .skip(1)
                .map(line -> line.split(","))
                .map(col -> new TripJson(col[0], col[1], col[2], col[3], col[4], col[5], col[6]))
                .forEach(e -> csvToClass.add(e));

        return csvToClass;

    }

    public List<TripJson> loadTripJsonList() throws IOException, ParseException {

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(".\\dataFiles\\uberOnRails.json");

        Object obj = jsonparser.parse(reader);
        JSONArray jsonArray = (JSONArray)obj;

        List<TripJson> jsonToArray = new ArrayList<TripJson>();

        jsonArray.forEach(e -> value = value.toString());

        return jsonToArray;
    }

    public List<TripJson> getTripList()
            throws IOException, ParseException {
        List<TripJson> tripJsonList = new ArrayList<TripJson>();
        loadTripCSVList().forEach(e -> tripJsonList.add(e));
       // loadTripJsonList().forEach(e -> tripJsonList.add(e));

        return tripJsonList;
    }
}
