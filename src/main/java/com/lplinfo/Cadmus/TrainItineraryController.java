package com.lplinfo.Cadmus;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainItineraryController {

    /*@GetMapping("/train/trips/{origin}/{destiny}/{date}")
    public List<TripJson> getTripJsonListFilterBy(
            @RequestParam String origin,
            @RequestParam String destiny,
            @RequestParam Optional<LocalDate> localDate) throws IOException, ParseException {
        return new TripJson().getTripList(origin, destiny, localDate);
    }*/

    @GetMapping("/train/trips/")
    public List<TripJson> getTripJsonListFilterBy() throws IOException, ParseException {
        return new TripJson().getTripList();
    }

    /*@GetMapping("/train/stations/{name}")
    public List<TrainJson> getTrainJsonListFilterBy(@RequestParam(required = true) String name) throws IOException, ParseException {
        return new TrainJson().getTrainJsonList(name);
    }*/

    @GetMapping("/train/stations/")
    public List<TrainJson> getTrainJsonListFilterBy() throws IOException, ParseException {
        return new TrainJson().getTrainJsonList();
    }

}
