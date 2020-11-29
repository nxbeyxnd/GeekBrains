import Command.Team;
import Command.Teamate;
import Compititions.Castle;
import Compititions.Course;
import Compititions.Lake;
import Compititions.Sprint;
import Links.interfaceSuccesCourse;
import Links.interfaceTeamateBehavior;

public class Main {
    public static void main(String[] args) {
        interfaceSuccesCourse[] succesCourses = new interfaceSuccesCourse[]{
                new Sprint(101),
                new Lake(200),
                new Castle(400),
                new Lake(100),
                new Lake(40)
        };
        Team team = new Team("dream",
                new interfaceTeamateBehavior[]{
                        new Teamate("Harry", 1100, 1200, 1130),
                        new Teamate("Germiona", 100, 420, 30),
                        new Teamate("Ron", 50, 100, 30),
                        new Teamate("Draco", 500, 200, 330)
        }); // Создаем команду
        new Course(succesCourses).doIt(team);
        team.showResults(); // Показываем результаты
    }
}
