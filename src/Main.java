import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Let> lets= new ArrayList<>();

        lets.add(new Treadmill(100));
        lets.add(new Wall(10));
        lets.add(new Wall(15));

        List<Rival> rivals= new ArrayList<>();

        rivals.add(new Human("Евстигней",150,12,State_competition.NOT_START));
        rivals.add(new Robot("T1000",1500,25,2));
        rivals.add(new Cat("Компот",15,3,2));

        for (Rival rival:rivals){
            rival.setS_c(State_competition.START);
            System.out.println("***************************************");

            for(Let let:lets){
                if (!let.rival_test(rival)) {
                    System.out.println(rival.toString()+" покидает соревнование");
                    rival.setS_c(State_competition.LOSE);
                    break;
                }
            }

            if (!rival.getS_c().equals(State_competition.LOSE)) rival.setS_c(State_competition.WIN);
        }

        System.out.println("Итог:");

        for (Rival rival:rivals){
            System.out.println(rival.toString()+" "+rival.getS_c());
        }

    }
}
//

enum State_competition {
    LOSE(1), NOT_START(2), START(3), WIN(4);
    private int number;

    State_competition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}


//Препятствия
interface Let{
    boolean rival_test(Rival rival);
}

class Treadmill implements Let {
    public int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean rival_test(Rival rival) {
        if (rival.run(length)){
            //System.out.println(rival.toString()+" пробежал дистанцию!");
            return true;
        } else {
            //System.out.println(rival.toString()+" не смог пробежать дистанцию!");
            return false;
        }
    }
}

class Wall implements Let{
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean rival_test(Rival rival) {
        if (rival.jump(height)){
           // System.out.println(rival.toString()+" перепрыгнул препятствие!");
            return true;
        } else {
            //System.out.println(rival.toString()+" не смог перепрыгнуть препятствие!");
            return false;
        }
    }
}

//Участники
interface Rival{
    boolean run(int distance);
    boolean jump(int height);
    State_competition getS_c();
    void setS_c(State_competition s_c);
}


class Robot implements Rival{
    private String name;

    public State_competition getS_c() {
        return s_c;
    }

    public void setS_c(State_competition s_c) {
        this.s_c = s_c;
    }

    private State_competition s_c;
    private int max_run_dist;
    private int max_jump_height;

    public Robot(String name, int max_run_dist, int max_jump_height, int s_c) {
        this.name = name;
        this.max_run_dist = max_run_dist;
        this.max_jump_height = max_jump_height;
    }

    public boolean run(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет бегать.");
            return false;
        } else if (distance>=max_run_dist) {
            System.out.println(this.toString()+" не смог пробежать дистанцию.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно пробежал дистанцию");
            return true;
        }
    }

    public boolean jump(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет рыть землю.");
            return false;
        } else if (distance>=max_jump_height) {
            System.out.println(this.toString()+" не смог перепрыгнуть препятствие.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно перепрыгнул препятствие");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Robot "+this.name;
    }
}

class Human implements Rival{
    private String name;

    public State_competition getS_c() {
        return s_c;
    }

    public void setS_c(State_competition s_c) {
        this.s_c = s_c;
    }

    private State_competition s_c;
    private int max_run_dist;
    private int max_jump_height;

    public Human(String name, int max_run_dist, int max_jump_height, State_competition s_c) {
        this.name = name;
        this.max_run_dist = max_run_dist;
        this.max_jump_height = max_jump_height;
    }

    public boolean run(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет бегать.");
            return false;
        } else if (distance>=max_run_dist) {
            System.out.println(this.toString()+" не смог пробежать дистанцию.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно пробежал дистанцию");
            return true;
        }
    }

    public boolean jump(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет рыть землю.");
            return false;
        } else if (distance>=max_jump_height) {
            System.out.println(this.toString()+" не смог перепрыгнуть препятствие.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно перепрыгнул препятствие");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Human "+this.name;
    }
}
class Cat implements Rival{
    private String name;

    public State_competition getS_c() {
        return s_c;
    }

    public void setS_c(State_competition s_c) {
        this.s_c = s_c;
    }

    private State_competition s_c;
    private int max_run_dist;
    private int max_jump_height;

    public Cat(String name, int max_run_dist, int max_jump_height, int s_c) {
        this.name = name;
        this.max_run_dist = max_run_dist;
        this.max_jump_height = max_jump_height;
    }

    public boolean run(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет бегать.");
            return false;
        } else if (distance>=max_run_dist) {
            System.out.println(this.toString()+" не смог пробежать дистанцию.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно пробежал дистанцию");
            return true;
        }
    }

    public boolean jump(int distance){
        if (distance<=0){
            System.out.println(this.toString()+" не умеет рыть землю.");
            return false;
        } else if (distance>=max_jump_height) {
            System.out.println(this.toString()+" не смог перепрыгнуть препятствие.");
            return false;
        } else {
            System.out.println(this.toString()+" успешно перепрыгнул препятствие");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cat "+this.name;
    }
}

