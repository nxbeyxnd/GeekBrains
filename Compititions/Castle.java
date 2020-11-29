package Compititions;

import Links.interfaceSuccesCourse;
import Links.interfaceTeamateBehavior;

public class Castle implements interfaceSuccesCourse {
    private int progress;

    public Castle(int progress){
        this.progress = progress;
    }

    @Override
    public boolean succesCourse(interfaceTeamateBehavior teamateBehavior) {
        return teamateBehavior.fly(this.progress);
    }
}
