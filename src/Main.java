// Interface
interface Training {
    void practice();
}

// Abstract Class
abstract class Player {

    // Encapsulation
    private String name;git
    private int jerseyNo;

    // Constructor
    Player(String name, int jerseyNo) {
        this.name = name;
        this.jerseyNo = jerseyNo;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    // Abstract Method
    abstract void play();

    // Concrete Method
    void details() {
        System.out.println("Player Name : " + name);
        System.out.println("Jersey No   : " + jerseyNo);
    }
}

// Inheritance
class Batsman extends Player implements Training {

    private int runs;

    Batsman(String name, int jerseyNo, int runs) {
        super(name, jerseyNo);
        this.runs = runs;
    }

    // Method Overriding (Runtime Polymorphism)
    @Override
    void play() {
        System.out.println(getName() + " is batting.");
    }

    @Override
    public void practice() {
        System.out.println(getName() + " is practicing batting.");
    }

    // Method Overloading (Compile-time Polymorphism)
    void scoreRuns() {
        System.out.println(getName() + " scored " + runs + " runs.");
    }

    void scoreRuns(int extraRuns) {
        System.out.println(getName() + " scored " + (runs + extraRuns) + " runs.");
    }
}

// Inheritance
class Bowler extends Player implements Training {

    private int wickets;

    Bowler(String name, int jerseyNo, int wickets) {
        super(name, jerseyNo);
        this.wickets = wickets;
    }

    // Method Overriding
    @Override
    void play() {
        System.out.println(getName() + " is bowling.");
    }

    @Override
    public void practice() {
        System.out.println(getName() + " is practicing bowling.");
    }

    void takeWickets() {
        System.out.println(getName() + " took " + wickets + " wickets.");
    }
}

public class Main {

    public static void main(String[] args) {

        Batsman batsman = new Batsman("Virat Kohli", 18, 120);
        Bowler bowler = new Bowler("Jasprit Bumrah", 93, 5);

        System.out.println("===== BATSMAN DETAILS =====");
        batsman.details();
        batsman.play();
        batsman.practice();
        batsman.scoreRuns();
        batsman.scoreRuns(20);

        System.out.println();

        System.out.println("===== BOWLER DETAILS =====");
        bowler.details();
        bowler.play();
        bowler.practice();
        bowler.takeWickets();

        System.out.println();

        // Runtime Polymorphism
        Player player;

        player = batsman;
        player.play();

        player = bowler;
        player.play();
    }
}