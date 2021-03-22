package org.javaSchool.model;

import java.util.List;

public class Route {
    private String startPoint;
    private String endPoint;

    private List<String> stops;
    private float lengthKilometers;


    public Route(List<String> stops, float kilometers) {
        this.stops = stops;
        this.lengthKilometers = kilometers;
        this.startPoint = stops.get(0);
        this.endPoint = stops.get((stops.size() - 1));
    }

    public float getLengthKilometers() {
        return this.lengthKilometers;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void printRoute() {
        System.out.printf("The route starts at: %s%n", startPoint);
        for (int i = 1; i < stops.size() - 1; i++) {
            System.out.println("Stop " + i + " " +
                    stops.get(i));
        }
        System.out.printf("The route ends at: %s%n", endPoint);
    }
}
