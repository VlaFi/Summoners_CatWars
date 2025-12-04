package catWars.model.cats;

import catWars.logic.abilities.Ability;
import catWars.logic.effects.EffectInstance;
import catWars.model.runes.Rune;

import java.util.ArrayList;
import java.util.List;

public class CreatureInstance {
    private final CreatureTemplate template;
    private final List<Rune> runes = new ArrayList<>();
    private final List<EffectInstance> effects = new ArrayList<>();
    private final List<Ability> instanceAbilities = new ArrayList<>();
    private double currentHp;

    public CreatureInstance(CreatureTemplate template) {
        this.template = template;
        this.currentHp = template.getBaseHp();
        if (template.getAbilities() != null) {
            for (Ability a : template.getAbilities()) {
                if (a != null) instanceAbilities.add(a.copy());
            }
        }
    }

    public String getName() { return template.getName(); }
    public CreatureTemplate getTemplate() { return template; }

    public void addEffect(EffectInstance e) { effects.add(e); }
    public void tickEffects() {
        effects.forEach(EffectInstance::tick);
        effects.removeIf(e -> e.getRemainingTurns() <= 0);
    }

    private double effectMultiplier(String stat) {
        return effects.stream()
                .filter(e -> stat.equalsIgnoreCase(e.getTargetStat()))
                .mapToDouble(EffectInstance::getValue)
                .reduce(1.0, (a, b) -> a * b);
    }

    public double getMaxHp() {
        double base = template.getBaseHp() * (1.0 + runeBonusPercent(Rune.Type.HP));
        return base * effectMultiplier("hp");
    }

    public double getAtk() {
        double base = template.getBaseAtk() * (1.0 + runeBonusPercent(Rune.Type.ATTACK));
        return base * effectMultiplier("atk");
    }

    public double getDef() {
        double base = template.getBaseDef() * (1.0 + runeBonusPercent(Rune.Type.DEFENSE));
        return base * effectMultiplier("def");
    }

    public double getSpeed() {
        double base = template.getBaseSpeed() * (1.0 + runeBonusPercent(Rune.Type.SPEED));
        return Math.round(base * effectMultiplier("spd"));
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

    public void heal(double amount) {
        this.currentHp = Math.min(getMaxHp(), this.currentHp + amount);
    }

    public void takeDamage(double amount) {
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    public Ability[] getAbilities() {
        return instanceAbilities.toArray(new Ability[0]);
    }

    public void addRune(Rune r) {
        if (runes.size() < 6) runes.add(r);
        else System.out.println(getName() + " не может носить более 6 рун!");
    }

    @Override
    public String toString() {
        return String.format("%s HP: %.1f/%.1f ATK: %.1f DEF: %.1f SPD: %.1f Runes:%d",
                getName(), getCurrentHp(), getMaxHp(), getAtk(), getDef(), getSpeed(), runes.size());
    }
}
