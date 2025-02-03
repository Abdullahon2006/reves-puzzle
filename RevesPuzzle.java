public class RevesPuzzle {

    // Helper function to calculate the optimal k
    private static int calculateK(int n) {
        return (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
    }

    // Recursive function to solve Reve's puzzle
    private static void revesPuzzle(int n, int startDisc, String start, String dest, String aux1, String aux2) {
        if (n == 0) return;

        int k = calculateK(n);

        // Step 1: Move the k smallest discs (startDisc to startDisc + k - 1) from start to aux1
        revesPuzzle(k, startDisc, start, aux1, dest, aux2);

        // Step 2: Move the remaining n - k discs (startDisc + k to startDisc + n - 1) from start to dest
        hanoi(n - k, startDisc + k, start, dest, aux2);

        // Step 3: Move the k smallest discs (startDisc to startDisc + k - 1) from aux1 to dest
        revesPuzzle(k, startDisc, aux1, dest, start, aux2);
    }

    // Recursive function to solve the 3-pole Towers of Hanoi problem
    private static void hanoi(int n, int startDisc, String start, String dest, String aux) {
        if (n == 0) return;

        hanoi(n - 1, startDisc, start, aux, dest);
        System.out.println("Move disc " + (startDisc + n - 1) + " from " + start + " to " + dest);
        hanoi(n - 1, startDisc, aux, dest, start);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesPuzzle(n, 1, "A", "D", "B", "C");
    }
}