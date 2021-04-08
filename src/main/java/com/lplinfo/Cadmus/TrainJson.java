package com.lplinfo.Cadmus;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainJson {
    public String name;
    public String station;
    public String city;


    public List<TrainJson> getTrainJsonList() throws IOException, ParseException {

        List<TrainJson> trainJsonList = new ArrayList<TrainJson>();

        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(".\\dataFiles\\trainStations.json");

        Object obj = jsonparser.parse(reader);
        JSONArray jsonArray = (JSONArray)obj;

        return jsonArray;
    }
}
