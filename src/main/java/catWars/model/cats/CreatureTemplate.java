package catWars.model.cats;

import catWars.logic.abilities.Ability;
import java.util.List;

public class CreatureTemplate {
    private final int id;
    private final String name;
    private final int stars;
    private final double baseHp;
    private final double baseAtk;
    private final double baseDef;
    private final double baseSpeed;
    private Ability[] abilities;

    public CreatureTemplate(int id, String name, int stars, double baseHp, double baseAtk, double baseDef, double baseSpeed, Ability[] abilities) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpeed = baseSpeed;
        this.abilities = abilities != null ? abilities : new Ability[0];
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getStars() { return stars; }
    public double getBaseHp() { return baseHp; }
    public double getBaseAtk() { return baseAtk; }
    public double getBaseDef() { return baseDef; }
    public double getBaseSpeed() { return baseSpeed; }

    public Ability[] getAbilities() { return abilities; }

    public void setAbilities(List<Ability> list) {
        this.abilities = list == null ? new Ability[0] : list.toArray(new Ability[0]);
    }

    @Override
    public String toString() {
        return String.format("%s (★%d) HP: %.1f ATK: %.1f DEF: %.1f SPD: %.1f",
                name, stars, baseHp, baseAtk, baseDef, baseSpeed);
    }
}
