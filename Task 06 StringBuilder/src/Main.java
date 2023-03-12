public class Main {

    public static void main(String[] args) {
        int N = 100000;

        long startTime1 = System.currentTimeMillis();
        String result1 = buildStringWithStringBuilder(N);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Execution time for StringBuilder: " + (endTime1 - startTime1) + " ms.");

        long startTime2 = System.currentTimeMillis();
        String result2 = buildStringWithConcatenation(N);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Execution time for Concatenation: " + (endTime2 - startTime2) + " ms.");


    }

    public static String buildStringWithStringBuilder (int N) {
        StringBuilder sb = new StringBuilder();
        sb.append("The numbers from 0-").append(N).append(" are ");
        for (int i=0; i<=N; i++) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static String buildStringWithConcatenation(int N) {
        String result = "The numbers from 0-" + N + " are ";
        for (int i=0; i<=N; i++) {
            result += i+" ";
        }
        return result;
    }

}