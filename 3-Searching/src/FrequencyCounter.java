import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {

    private FrequencyCounter() {
    }

    ;

    public static void main(String[] args) {

        int minLength = Integer.parseInt(args[0]);
        int words = 0;
        int distinct = 0;

        ST<String, Integer> st = new SequentialSearchST<>();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minLength) continue;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
            words++;

        }

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        System.out.println("max:"+st.get(max));
        System.out.println("words = "+words);
        System.out.println("distinct = "+distinct);
        System.out.println(st);

    }
}
