package src.abilities;

import src.entities.Creature;

public class FurballAttack extends Ability {
    public FurballAttack() {
        super("Атака комком шерсти");
    }

    @Override
    public void use(Creature user, Creature target) {
        double damage = (user.getAttack() * 1.20) * (100.0 / (100.0 + target.getDefense()));
        target.takeDamage(damage);
        System.out.printf("%s плюёт комком шерсти в %s и наносит %.1f урона! (HP: %.1f)%n", user.getName(), target.getName(), damage, target.getHp());
    }
}


