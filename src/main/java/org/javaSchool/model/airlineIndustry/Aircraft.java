package org.javaSchool.model.airlineIndustry;

import org.javaSchool.model.Route;
import org.javaSchool.model.Vehicle;

abstract class Aircraft implements Vehicle {
    protected Route travelRoute;

    @Override
    public void travel() {
        System.out.printf("Flying from %s to %s.%n", travelRoute.getStartPoint(), travelRoute.getEndPoint());
    }

    public void setRoute(Route route) {
        this.travelRoute = route;
    }
}
