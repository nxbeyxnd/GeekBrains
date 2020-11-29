package Command;

import Links.interfaceTeamateBehavior;

public class Team {

    private String teamName;
    private interfaceTeamateBehavior[] teamate;

    public Team(String teamName, interfaceTeamateBehavior[] teamate) {
        this.teamName = teamName;
        this.teamate = teamate;
    }

    public void showResults() {
        System.out.println("Result: ");
        for (interfaceTeamateBehavior teamate : teamate){
            if (teamate.isSuccesCourse()) System.out.println(teamate.toString() + " finished.");
        }
    }

    public interfaceTeamateBehavior[] getTeamate() {
        return teamate;
    }
}
