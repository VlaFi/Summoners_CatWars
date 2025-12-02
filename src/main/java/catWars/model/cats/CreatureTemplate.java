package catWars.model.cats;

import catWars.logic.abilities.Ability;

public class CreatureTemplate {
    private final String name;
    private final int stars;
    private final double baseHp;
    private final double baseAtk;
    private final double baseDef;
    private final double baseSpeed;
    private final Ability[] abilities;


    public CreatureTemplate(String name, int stars, double baseHp, double baseAtk, double baseDef, double baseSpeed, Ability[] abilities) {
        this.name = name;
        this.stars = stars;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpeed = baseSpeed;
        this.abilities = abilities != null ? abilities : new Ability[3];
    }

    public String getName() {
        return name;
    }
    public int getStars() {
        return stars;
    }
    public double getBaseHp() {
        return baseHp;
    }
    public double getBaseAtk() {
        return baseAtk; }
    public double getBaseDef() { return baseDef;
    }
    public double getBaseSpeed() {
        return baseSpeed;
    }
    public Ability[] getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return String.format("%s (★%d) HP: %.1f ATK: %.1f DEF: %.1f SPD: %d", name, stars, baseHp, baseAtk, baseDef, baseSpeed);
    }
}
