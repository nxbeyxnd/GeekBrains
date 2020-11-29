package Command;

import Links.interfaceTeamateBehavior;

public class Teamate implements interfaceTeamateBehavior {

    String succesContest = " contest is succeeded :)";
    String failContest = " contest is failed :(";

    private String teamateName;
    private int maxRunDistance, maxSwimDistance, maxFlyHeight;
    private boolean succesCourse = true;

    public Teamate(String teamateName, int maxRunDistance, int maxSwimDistance, int maxFlyHeight) {
        this.teamateName = teamateName;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxFlyHeight = maxFlyHeight;
    }

    @Override
    public boolean run(int value) {
        if(value > maxRunDistance) {
            System.out.println(this.teamateName + failContest);
            succesCourse = false;
            return false;
        } else{
            System.out.println(this.teamateName + succesContest);
            succesCourse = true;
            return true;
        }
    }

    @Override
    public boolean swim(int value) {
        if(value > maxFlyHeight) {
            System.out.println(this.teamateName + failContest);
            succesCourse = false;
            return false;
        } else{
            System.out.println(this.teamateName + succesContest);
            succesCourse = true;
            return true;
        }
    }

    @Override
    public boolean fly(int value) {
        if(value > maxSwimDistance) {
            System.out.println(this.teamateName + failContest);
            succesCourse = false;
            return false;
        } else{
            System.out.println(this.teamateName + succesContest);
            succesCourse = true;
            return true;
        }
    }

    public boolean isSuccesCourse(){
        return succesCourse;
    }

    @Override
    public String toString() {
        return "Command.Team member: " + teamateName;
    }
}
