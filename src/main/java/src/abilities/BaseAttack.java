package src.abilities;

import src.entities.Creature;

public class BaseAttack extends Ability {
    public BaseAttack() {
        super("Атака");
    }

    @Override
    public void use(Creature user, Creature target) {
        double damage = user.getAttack() * (100.0 / (100.0 + target.getDefense()));
        target.takeDamage(damage);
        System.out.printf("%s бьёт %s и наносит %.1f урона! (HP: %.1f)%n", user.getName(), target.getName(), damage, target.getHp());
    }
}


