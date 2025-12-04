package catWars.logic.abilities;

import catWars.model.cats.CreatureInstance;

public class DamageAbility extends Ability {
    public DamageAbility() { super(); }
    public DamageAbility(double power) { super(power); }

    @Override
    protected void apply(CreatureInstance caster, CreatureInstance target) {
        double damage = caster.getAtk() * this.power;
        target.takeDamage(damage);
        System.out.printf("%s применил %s -> %s : %.1f урона%n", caster.getName(), getName(), target.getName(), damage);
    }

    @Override
    public Ability copy() {
        DamageAbility a = new DamageAbility(this.power);
        a.setId(this.id);
        a.setName(this.name);
        a.setCooldown(this.cooldown);
        return a;
    }
}
