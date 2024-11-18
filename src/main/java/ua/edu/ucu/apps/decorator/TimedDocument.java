package ua.edu.ucu.apps.decorator;

import java.time.Duration;
import java.time.LocalTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimedDocument implements Document {
    private Document document;

    @Override
    public String parse() {
        LocalTime starTime = LocalTime.now();
        String result = document.parse();
        LocalTime endTime = LocalTime.now();
        System.out.println(Duration.between(starTime, endTime).getSeconds());

        return result;
    }

    public String getGcsPath() {
        return document.getGcsPath();
    }
}
