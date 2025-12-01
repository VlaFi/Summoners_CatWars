package src.abilities;

import src.entities.Creature;

public class ToyAttack extends Ability {
    public ToyAttack() {
        super("Атака игрушкой");
    }

    @Override
    public void use(Creature user, Creature target) {
        double damage = (user.getAttack() * 1.20) * (100.0 / (100.0 + target.getDefense()));
        target.takeDamage(damage);
        System.out.printf("%s бьёт игрушкой %s и наносит %.1f урона! (HP: %.1f)%n", user.getName(), target.getName(), damage, target.getHp());
    }
}


