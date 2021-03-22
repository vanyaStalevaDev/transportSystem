package org.javaSchool.model.sailIndustry;

import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;

abstract class Ship implements Vehicle {
    protected Route travelRoute;

    public void travel() {
        System.out.printf("Sailing from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    public void setRoute(Route route) {
        this.travelRoute = route;
    }
}
