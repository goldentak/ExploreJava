import java.util.Scanner;

public class Main {
    public static void check(int a){
        String won;
        if(a == 1){
            won = "x";
        }
        else{
            won = "o";
        }
        System.out.print(won);
        System.out.print(" won, congrats, game over!");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        int queue = 0;
        int[] pos = new int[9];
        System.out.println();
        System.out.println("Enter pos from 1 to 9 (10 for quit): ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt();
            if (x >= 10) {
                break;
            }

            if (x >= 1 && x <= 9) {
                x %= 10;
                x -= 1;
            } else {
                break;
            }
            if (queue % 2 == 0) {
                pos[x] = 1;
            } else {
                pos[x] = 2;
            }
            queue++;
            int step = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (pos[step]) {

                        case 1:
                            System.out.print("X ");
                            break;
                        case 2:
                            System.out.print("O ");
                            break;
                        default:
                            System.out.print("– ");
                            break;
                    }
                    step++;
                }
                System.out.println("");

            }
            for (int i = 0; i < 3; i++) {
                i *= 3;
                if(pos[i] != 0 && pos[i] == pos[i+1] && pos[i+1] == pos[i+2]){
                    int a = pos[i];
                    check(a);
                }
            }
            for (int i = 0; i < 3; i++) {
                if(pos[i] != 0 && pos[i] == pos[i+3] && pos[i+3] == pos[i+6]){
                    int a = pos[i];
                    check(a);
                }
            }
            for (int i = 0; i < 3; i++) {
                if(pos[i] != 0 && pos[i] == pos[4] && pos[4] == pos[8 - i]){
                    int a = pos[i];
                    check(a);
                }
            }
        }
    }
}

