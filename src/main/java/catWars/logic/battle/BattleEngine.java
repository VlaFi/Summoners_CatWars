package catWars.logic.battle;

import catWars.model.cats.Creature;
import catWars.logic.abilities.Ability;
import java.util.Scanner;

public class BattleEngine {
    private final Creature player;
    private final Creature enemy;

    public BattleEngine(Creature player, Creature enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Битва начинается!");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Новый ход ---");
            System.out.printf("%s HP: %.1f | %s HP: %.1f%n", player.getName(), player.getHp(), enemy.getName(), enemy.getHp());

            System.out.println("\nВыберите действие:");
            for (int i = 0; i < player.getAbilities().size(); i++) {
                System.out.println((i + 1) + ". " + player.getAbilities().get(i).getName());
            }

            int choice = scanner.nextInt() - 1;
            if (choice < 0 || choice >= player.getAbilities().size()) {
                System.out.println("Неверный выбор! Пропуск хода.");
            } else {
                Ability ability = player.getAbilities().get(choice);
                ability.use(player, enemy);
            }

            if (!enemy.isAlive()) break;

            Ability enemyAbility = enemy.getAbilities().get(0);
            enemyAbility.use(enemy, player);
        }
        if (player.isAlive()) System.out.println("\nПобеда!");
        else System.out.println("\nПоражение...");
     }
}