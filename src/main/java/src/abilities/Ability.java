package src.abilities;

import src.entities.Creature;

public abstract class Ability {
    private final String name;

    public Ability(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public abstract void use(Creature user, Creature target);
}