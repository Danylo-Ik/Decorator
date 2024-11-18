package ua.edu.ucu.apps;
import ua.edu.ucu.apps.decorator.*;


public class Main {
    public static void main(String[] args) {
        MockedDocument mockedDocument = new MockedDocument("");
        System.out.println(mockedDocument.parse());

        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());
    }
}