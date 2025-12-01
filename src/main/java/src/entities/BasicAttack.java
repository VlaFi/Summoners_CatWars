package src.entities;

import src.abilities.Ability;

public class BasicAttack extends Ability {
    public BasicAttack() {
        super("Обычная атака");
    }

    @Override
    public void use(Creature user, Creature target) {
        double rawDamage = user.getAttack();
        double reduced = rawDamage * (100/(100 + target.getDefense()));

        target.takeDamage(reduced);
        System.out.printf("%s атакует %s на %.1f урона (защита: %.1f)! Осталось HP: %.1f%n", user.getName(), target.getName(), reduced, target.getDefense(), target.getHp());
    }
}