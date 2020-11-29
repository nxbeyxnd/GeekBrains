package Compititions;

import Command.Team;
import Links.interfaceSuccesCourse;
import Links.interfaceTeamateBehavior;

public class Course {

    private interfaceSuccesCourse[] succesCourses;

    public Course(interfaceSuccesCourse[] succesCourse) {
        this.succesCourses = succesCourse;
    }

    public void doIt(Team team) {
        for (interfaceTeamateBehavior teamate : team.getTeamate()) {
            for (interfaceSuccesCourse succesCourse : this.succesCourses){
                if (succesCourse.succesCourse(teamate)) {
                    System.out.println(String.format("Finished - %s %n", succesCourse.getClass().getName()));
                } else {
                    System.out.println(String.format("Next teamate %n"));
                    break;
                }
            }
        }
    }
}
