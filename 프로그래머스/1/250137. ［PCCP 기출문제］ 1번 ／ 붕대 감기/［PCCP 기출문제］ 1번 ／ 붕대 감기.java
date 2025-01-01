class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = 0;
        int maxHealth = health;
        for(int i=0;i<attacks.length;i++) {
            if (attacks[i][0] - time > bandage[0]) {
                health+=((attacks[i][0]-time-1) / bandage[0]) * bandage[2];
                health+=(attacks[i][0]-time-1) * bandage[1];
            } else {
                health+=(attacks[i][0]-time-1) * bandage[1];
            }
            health = health > maxHealth ? maxHealth : health;
            time = attacks[i][0];
            health-=attacks[i][1];
            if (health <= 0)
                return -1;
        }
        return health;
    }
}