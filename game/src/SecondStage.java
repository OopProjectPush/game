public class SecondStage {

    private static Hero hero;

    static StageEnemies stageB[] = { new StageEnemies(2, 0, 50F, -50F, 0),
            new StageEnemies(2, 1, 340F, -50F, 1),
            new StageEnemies(0, 2, 80F, -50F, 2),
            new StageEnemies(0, 2, 100F, -50F, 1),
            new StageEnemies(0, 2, 200F, -50F, 3),
            new StageEnemies(0, 2, 300F, -50F, 2),
            new StageEnemies(1, 4, 100F, -50F, 0),
            new StageEnemies(1, 4, 300F, -50F, 0),
            new StageEnemies(0, 5, 80F, -50F, 0),
            new StageEnemies(0, 5, 340F, -50F, 1),
            new StageEnemies(0, 7, 320F, -50F, 3),
            new StageEnemies(0, 7, 260F, -50F, 2),
            new StageEnemies(0, 8, 230F, -50F, 3),
            new StageEnemies(0, 8, 180F, -50F, 1),
            new StageEnemies(3, 9, 100F, -50F, 0),
            new StageEnemies(0, 12, 90F, -50F, 2),
            new StageEnemies(0, 12, 70F, -50F, 1),
            new StageEnemies(0, 13, 100F, -50F, 2),
            new StageEnemies(0, 13, 140F, -50F, 3),
            new StageEnemies(0, 13, 200F, -50F, 0),
            new StageEnemies(2, 14, 320F, -50F, 1),
            new StageEnemies(1, 16, 340F, -50F, 0),
            new StageEnemies(2, 17, 120F, -50F, 0),
            new StageEnemies(0, 19, 90F, -50F, 3),
            new StageEnemies(0, 19, 120F, -50F, 1),
            new StageEnemies(0, 20, 160F, -50F, 3),
            new StageEnemies(0, 20, 200F, -50F, 3),
            new StageEnemies(0, 21, 280F, -50F, 4),
            new StageEnemies(0, 21, 300F, -50F, 4),
            new StageEnemies(0, 21, 330F, -50F, 4),
            new StageEnemies(0, 23, -20F, 450F, 5),
            new StageEnemies(0, 23, -20F, 450F, 6),
            new StageEnemies(0, 24, 70F, -50F, 0),
            new StageEnemies(0, 24, 100F, -50F, 0),
            new StageEnemies(3, 26, 80F, -50F, 0),
            new StageEnemies(3, 26, 320F, -50F, 1),
            new StageEnemies(0, 27, 260F, -50F, 2),
            new StageEnemies(1, 29, 100F, -50F, 0),
            new StageEnemies(1, 29, 300F, -50F, 0),
            new StageEnemies(0, 30, 70F, -50F, 5),
            new StageEnemies(2, 32, 100F, -50F, 0),
            new StageEnemies(2, 32, 340F, -50F, 0),
            new StageEnemies(0, 33, 280F, -50F, 2),
            new StageEnemies(0, 35, 60F, -50F, 3),
            new StageEnemies(0, 35, 100F, -50F, 1),
            new StageEnemies(0, 36, 150F, -50F, 3),
            new StageEnemies(0, 36, 200F, -50F, 3),
            new StageEnemies(0, 37, 280F, -50F, 4),
            new StageEnemies(0, 37, 300F, -50F, 0),
            new StageEnemies(0, 37, 320F, -50F, 4),
            new StageEnemies(0, 38, -20F, 450F, 5),
            new StageEnemies(0, 38, -20F, 450F, 6),
            new StageEnemies(0, 39, 70F, -50F, 0),
            new StageEnemies(0, 39, 90F, -50F, 1),
            new StageEnemies(2, 41, 40F, -50F, 0),
            new StageEnemies(3, 41, 320F, -50F, 1),
            new StageEnemies(1, 43, 150F, -50F, 0),
            new StageEnemies(1, 43, 320F, -50F, 0),
            new StageEnemies(2, 45, -50F, 0.0F, 0),
            new StageEnemies(2, 45, 500F, 0.0F, 1),
            new StageEnemies(5, 49, 50F, -250F, 0) };

    public SecondStage(Hero hero) {
        this.hero = hero;
    }

    public static void start() {
        for (int i = 0; i < stageB.length; i++)
            if ((double) stageB[i].time == (double) BattlePanel.time / 50D)
                if (stageB[i].enemyKind == 0)
                    BattlePanel.addList(new FirstEnemy(stageB[i].x, stageB[i].y,
                            hero, stageB[i].pattern));
                else if (stageB[i].enemyKind == 1)
                    BattlePanel.addList(new SecondEnemy(stageB[i].x, stageB[i].y,
                            hero, stageB[i].pattern));
                else if (stageB[i].enemyKind == 2)
                    BattlePanel.addList(new ThirdEnemy(stageB[i].x, stageB[i].y,
                            hero, stageB[i].pattern));
                else if (stageB[i].enemyKind == 5) {
                    BattlePanel.addList(new BigBoss2(hero));
                }

    }

}
