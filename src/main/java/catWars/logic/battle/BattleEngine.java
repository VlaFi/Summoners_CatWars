package catWars.logic.battle;

import catWars.model.cats.CreatureInstance;
import catWars.logic.abilities.Ability;

import java.util.Scanner;

public class BattleEngine {
    private final CreatureInstance player;
    private final CreatureInstance enemy;

    public BattleEngine(CreatureInstance player, CreatureInstance enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Битва начинается!");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Новый ход ---");
            System.out.printf("%s HP: %.1f | %s HP: %.1f%n", player.getName(), player.getCurrentHp(), enemy.getName(), enemy.getCurrentHp());

            System.out.println("\nВыберите действие:");
            Ability[] pAbilities = player.getAbilities();
            for (int i = 0; i < pAbilities.length; i++) {
                System.out.println((i + 1) + ". " + (pAbilities[i] == null ? "----" : pAbilities[i].getName()));
            }

            int choice = scanner.nextInt() - 1;
            if (choice < 0 || choice >= pAbilities.length || pAbilities[choice] == null) {
                System.out.println("Неверный выбор! Пропуск хода.");
            } else {
                Ability ability = pAbilities[choice];
                ability.use(player, enemy);
            }

            if (!enemy.isAlive()) break;

            Ability[] eAbilities = enemy.getAbilities();
            Ability enemyAbility = eAbilities.length > 0 && eAbilities[0] != null ? eAbilities[0] : null;
            if (enemyAbility != null) enemyAbility.use(enemy, player);
        }
        if (player.isAlive()) System.out.println("\nПобеда!");
        else System.out.println("\nПоражение...");
    }
}
