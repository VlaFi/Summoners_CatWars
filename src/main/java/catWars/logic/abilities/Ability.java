package catWars.logic.abilities;

import catWars.model.cats.CreatureInstance;

public abstract class Ability {
    protected int id;
    protected String name;
    protected double power;
    protected int cooldown; // базовый кулдаун

    public Ability() {}

    public Ability(double power) { this.power = power; }

    public final void use(CreatureInstance caster, CreatureInstance target) {
        apply(caster, target);
    }

    protected abstract void apply(CreatureInstance caster, CreatureInstance target);

    public abstract Ability copy();

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setPower(double power) { this.power = power; }
    public double getPower() { return power; }

    public void setCooldown(int cooldown) { this.cooldown = cooldown; }
    public int getCooldown() { return cooldown; }
}
