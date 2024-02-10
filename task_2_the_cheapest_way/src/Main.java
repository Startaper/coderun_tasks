import java.io.*;

public class Main {

    private static final StringBuilder way = new StringBuilder();

    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int[] size = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        int[][] data = new int[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            line = reader.readLine().split(" ");
            for (int j = 0; j < size[1]; j++) {
                data[i][j] = Integer.parseInt(line[j]);
            }
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(maxCost(data) + "\n");
//        writer.write(way.substring(0, way.length() - 1) + "\n");
        writer.close();
    }

    public static int maxCost(int[][] cost) {
        int m = cost.length, n = cost[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = cost[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }
//        printRoute(cost, 0, 0);
//        System.out.println();
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
//                if (cost[i - 1][j] > cost[i][j - 1]) {
//                    way.append("D ");
//                    printRoute(cost, i - 1, j);
//                } else {
//                    way.append("R ");
//                    printRoute(cost, i, j - 1);
//                }
            }
        }
//        System.out.println();
//        printRoute(cost, m - 1, n - 1);
//        System.out.println();
        return dp[m - 1][n - 1];
    }

    public static void printRoute(int[][] cost, int i, int j){
        System.out.print(cost[i][j] + " ");
    }
}
