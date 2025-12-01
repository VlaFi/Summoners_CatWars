package src.entities;

import src.abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public class CreatureInstance {
    private final CreatureTemplate template;
    private final List<Rune> runes = new ArrayList<>();
    private double currentHp;

    public CreatureInstance(CreatureTemplate template) {
        this.template = template;
        this.currentHp = template.getBaseHp();
    }

    public CreatureTemplate getTemplate() { return template; }

    public void addRune(Rune r) {
        if (runes.size() < 6) runes.add(r);
    }
    public List<Rune> getRunes() { return List.copyOf(runes); }

    public double getMaxHp() {
        return template.getBaseHp() * (1.0 + runeBonusPercent(Rune.Type.HP));
    }
    public double getAtk() {
        return template.getBaseAtk() * (1.0 + runeBonusPercent(Rune.Type.ATTACK));
    }
    public double getDef() {
        return template.getBaseDef() * (1.0 + runeBonusPercent(Rune.Type.DEFENSE));
    }
    public double getSpeed() {
        return (double)Math.round(template.getBaseSpeed() * (1.0 + runeBonusPercent(Rune.Type.SPEED)));
    }

    private double runeBonusPercent(Rune.Type type) {
        long count = runes.stream().filter(r -> r.getType() == type).count();
        return switch (type) {
            case HP -> count >= 2 ? 0.10 : 0.0;
            case DEFENSE -> count >= 4 ? 0.20 : 0.0;
            case ATTACK -> count >= 4 ? 0.15 : 0.0;
            case SPEED -> count >= 4 ? 0.20 : 0.0;
        };
    }

    public double getCurrentHp() { return currentHp; }
    public void setCurrentHp(double hp) { this.currentHp = Math.max(0, Math.min(hp, getMaxHp())); }

    public boolean isAlive() { return currentHp > 0; }

    public double takeDamage(double rawAttack) {
        double real = rawAttack * (100.0 / (100.0 + getDef()));
        setCurrentHp(currentHp - real);
        return real;
    }

    public Ability[] getAbilities() {
        return template.getAbilities();
    }

    @Override
    public String toString() {
        return String.format("%s (экземпляр) HP: %.1f/%.1f ATK: %.1f DEF: %.1f SPD: %d Runes:%d", template.getName(), getCurrentHp(), getMaxHp(), getAtk(), getDef(), getSpeed(), runes.size());
    }
}
