package org.javaSchool.model.trainIndustry;

import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;

abstract class Train implements Vehicle {
    protected Route travelRoute;

    @Override
    public void travel() {
        System.out.printf("Travelling on the railroad from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    public void setRoute(Route route) {
        this.travelRoute = route;
    }
}
