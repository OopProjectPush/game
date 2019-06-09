public class FirstStage {

    static Hero hero;

    static StageEnemies stageA[] = {
            new StageEnemies(0, 0, 25F, 0F, 2),
            new StageEnemies(0, 1, 100F, 20F, 0),
            new StageEnemies(0, 2, 150F, 10F, 0),
            new StageEnemies(0, 2, 200F, 20F, 2),
            new StageEnemies(0, 2, 250F, -3F, 1),
            new StageEnemies(0, 2, 300F, -14F, 2),
            new StageEnemies(0, 2, 100F, -17F, 0),
            new StageEnemies(0, 0, 250F, -22F, 1),
            new StageEnemies(0, 1, 300F, -55F, 1),
            new StageEnemies(0, 2, 30F, -12F, 2),
            new StageEnemies(0, 5, 260F, 400F, 5),
            new StageEnemies(0, 7, 360F, 430F, 5),
            new StageEnemies(0, 8, 20F, -50F, 2),
            new StageEnemies(0, 8, 100F, -5F, 0),
            new StageEnemies(0, 8, 200F, -24F, 1),
            new StageEnemies(0, 8, 300F, -50F, 0),
            new StageEnemies(0, 11, 550F, 430F, 6),
            new StageEnemies(0, 12, 550F, 410F, 2),
            new StageEnemies(0, 12, 20F, -50F, 1),
            new StageEnemies(0, 12, 100F, -24F, 0),
            new StageEnemies(0, 12, 200F, -1F, 2),
            new StageEnemies(0, 12, 300F, -50F, 2),
            new StageEnemies(1, 5, 250F, -50F, 0),
            new StageEnemies(3, 16, 450F, -16F, 1),
            new StageEnemies(0, 18, 20F, -50F, 2),
            new StageEnemies(0, 18, 100F, -50F, 2),
            new StageEnemies(0, 18, 200F, -5F, 3),
            new StageEnemies(0, 18, 300F, -50F, 2),
            new StageEnemies(3, 21, 0.0F, -50F, 0),
            new StageEnemies(0, 23, 20F, -5F, 3),
            new StageEnemies(0, 23, 100F, -50F, 2),
            new StageEnemies(0, 23, 200F, -50F, 3),
            new StageEnemies(0, 23, 300F, -5F, 2),
            new StageEnemies(3, 25, 450F, -50F, 1),
            new StageEnemies(0, 27, 20F, -14F, 2),
            new StageEnemies(0, 27, 100F, -50F, 0),
            new StageEnemies(0, 27, 200F, -5F, 3),
            new StageEnemies(0, 27, 300F, -50F, 2),
            new StageEnemies(2, 2, 20F, -50F, 0),
            new StageEnemies(0, 31, 20F, -50F, 2),
            new StageEnemies(0, 31, 100F, -14F, 1),
            new StageEnemies(0, 31, 200F, -22F, 3),
            new StageEnemies(0, 31, 300F, -33F, 2),
            new StageEnemies(2, 34, 350F, -50F, 0),
            new StageEnemies(0, 35, 20F, -14F, 0),
            new StageEnemies(0, 35, 100F, -50F, 2),
            new StageEnemies(0, 35, 200F, -22F, 1),
            new StageEnemies(0, 35, 300F, -50F, 2),
            new StageEnemies(1, 37, 30F, -50F, 0),
            new StageEnemies(3, 38, 200F, -50F, 0),
            new StageEnemies(0, 39, -50F, -50F, 4),
            new StageEnemies(0, 40, 500F, -50F, 5),
            new StageEnemies(2, 42, 200F, -50F, 0),
            new StageEnemies(0, 43, 20F, -50F, 2),
            new StageEnemies(0, 43, 300F, -50F, 2),
            new StageEnemies(4, 47, 0.0F, 0.0F, 0) };

    public FirstStage(Hero hero) {
        FirstStage.hero = hero;
    }

    public static void start() {
        for (int i = 0; i < stageA.length; i++) {
            if ((double) stageA[i].time == (double) BattlePanel.time / 50D)
                if (stageA[i].enemyKind == 0)
                    BattlePanel.addList(new FirstEnemy(stageA[i].x, stageA[i].y,
                            hero, stageA[i].pattern));
                else if (stageA[i].enemyKind == 1)
                    BattlePanel.addList(new SecondEnemy(stageA[i].x, stageA[i].y,
                            hero, stageA[i].pattern));
                else if (stageA[i].enemyKind == 2)
                    BattlePanel.addList(new ThirdEnemy(stageA[i].x, stageA[i].y,
                            hero, stageA[i].pattern));
                else if (stageA[i].enemyKind == 4) {
                    BattlePanel.addList(new BigBoss1(hero));
            }

        }
    }

    public static Hero getHero() {
        return hero;
    }

}
