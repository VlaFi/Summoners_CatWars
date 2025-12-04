package catWars.logic.abilities;

import catWars.logic.effects.EffectInstance;
import catWars.model.cats.CreatureInstance;

public class DebuffAbility extends Ability {
    public DebuffAbility() { super(); }
    public DebuffAbility(double power) { super(power); }

    @Override
    protected void apply(CreatureInstance caster, CreatureInstance target) {
        EffectInstance e = new EffectInstance("def", this.power, 1);
        target.addEffect(e);
        System.out.printf("%s применил %s -> %s : дебаф def x%.2f%n", caster.getName(), getName(), target.getName(), this.power);
    }

    @Override
    public Ability copy() {
        DebuffAbility a = new DebuffAbility(this.power);
        a.setId(this.id);
        a.setName(this.name);
        a.setCooldown(this.cooldown);
        return a;
    }
}
