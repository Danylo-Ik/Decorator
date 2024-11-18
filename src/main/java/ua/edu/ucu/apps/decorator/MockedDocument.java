package ua.edu.ucu.apps.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockedDocument implements Document {
    public String gcsPath;

    @Override
    public String parse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        return "Mocked Parse Result";
    }

}
