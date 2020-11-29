package Compititions;

import Links.interfaceSuccesCourse;
import Links.interfaceTeamateBehavior;

public class Lake implements interfaceSuccesCourse {

    private int progress;

    public Lake(int progress){
        this.progress = progress;
    }

    @Override
    public boolean succesCourse(interfaceTeamateBehavior teamateBehavior) {
        return teamateBehavior.swim(this.progress);
    }
}
