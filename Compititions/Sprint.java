package Compititions;

import Links.interfaceSuccesCourse;
import Links.interfaceTeamateBehavior;

public class Sprint implements interfaceSuccesCourse {
    private int progress;

    public Sprint(int progress){
        this.progress = progress;
    }

    @Override
    public boolean succesCourse(interfaceTeamateBehavior teamateBehavior) {
        return teamateBehavior.run(this.progress);
    }
}
