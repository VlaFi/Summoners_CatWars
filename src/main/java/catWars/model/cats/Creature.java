package catWars.model.cats;

import java.util.ArrayList;
import java.util.List;

import catWars.model.runes.Rune;
import catWars.logic.abilities.Ability;

public class Creature {
    private final String name;
    private double baseHp;
    private final double baseAttack;
    private final double baseDefense;
    private final double baseSpeed;
    private final List<Ability> abilities = new ArrayList<>();
    private final List<Rune> runes = new ArrayList<>();

    public Creature(String name, double hp, double attack, double defense, double speed) {
        this.name = name;
        this.baseHp = hp;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.baseSpeed = speed;
    }

    public String getName() {
        return name;
    }

    public void  takeDamage(double dmg) {
        baseHp = Math.max(0, baseHp - dmg);
    }

    public boolean isAlive() {
        return baseHp > 0;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void addRune(Rune rune) {
        if (runes.size() < 6) {
            runes.add(rune);
        } else {
            System.out.println(name + " не может носить более 6 рун!");
        }
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public double getHp() {
        return baseHp * (1 + getRuneBonus(Rune.Type.HP));
    }

    public double getAttack() {
        return baseAttack * (1 + getRuneBonus(Rune.Type.ATTACK));
    }

    public double getDefense() {
        return baseDefense * (1 + getRuneBonus(Rune.Type.DEFENSE));
    }

    public double getSpeed() {
        return baseSpeed * (1 + getRuneBonus(Rune.Type.SPEED));
    }

    private double getRuneBonus(Rune.Type type) {
        long count = runes.stream().filter(r -> r.getType() == type).count();
        return switch (type) {
            case HP -> count >= 2 ? 0.10 : 0.0;
            case DEFENSE -> count >= 4 ? 0.20 : 0.0;
            case ATTACK -> count >= 4 ? 0.15 : 0.0;
            case SPEED -> count >= 4 ? 0.20 : 0.0;
        };
    }
}