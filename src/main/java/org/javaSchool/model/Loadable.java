package org.javaSchool.model;

public interface Loadable {

    public void load(int weight);
    public void unload();
    public void unload(int weight);
    public int getLoadWeight();
    public int getLoadCapacity();
}
