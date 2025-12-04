package catWars.logic.abilities;

import catWars.model.cats.CreatureInstance;

public class HealAbility extends Ability {
    public HealAbility() { super(); }
    public HealAbility(double power) { super(power); }

    @Override
    protected void apply(CreatureInstance caster, CreatureInstance target) {
        double heal = caster.getAtk() * this.power;
        target.heal(heal);
        System.out.printf("%s применил %s -> %s : восстановлено %.1f HP%n", caster.getName(), getName(), target.getName(), heal);
    }

    @Override
    public Ability copy() {
        HealAbility a = new HealAbility(this.power);
        a.setId(this.id);
        a.setName(this.name);
        a.setCooldown(this.cooldown);
        return a;
    }
}
