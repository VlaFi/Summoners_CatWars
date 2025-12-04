package catWars.model.cats;

import java.util.*;

public class Creature {
    private String name;
    private int health;
    private int attack;
    private List<String> abilities; // <--- просто имена

    public Creature(String name, int health, int attack, List<String> abilities) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.abilities = abilities;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }
    public List<String> getAbilities() { return abilities; }

    public void damage(int amount) {
        this.health = Math.max(0, this.health - amount);
    }
}
