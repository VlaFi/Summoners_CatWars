package catWars.logic.abilities;

import catWars.logic.effects.EffectInstance;
import catWars.model.cats.CreatureInstance;

public class BuffAbility extends Ability {
    public BuffAbility() { super(); }
    public BuffAbility(double power) { super(power); }

    @Override
    protected void apply(CreatureInstance caster, CreatureInstance target) {
        EffectInstance e = new EffectInstance("atk", this.power, 1);
        target.addEffect(e);
        System.out.printf("%s применил %s -> %s : баф atk x%.2f%n", caster.getName(), getName(), target.getName(), this.power);
    }

    @Override
    public Ability copy() {
        BuffAbility a = new BuffAbility(this.power);
        a.setId(this.id);
        a.setName(this.name);
        a.setCooldown(this.cooldown);
        return a;
    }
}
