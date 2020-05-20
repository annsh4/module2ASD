import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> values = new ArrayList<>();

    public void add(int value) {
        values.add(value);
    }

    public void remove() {
        if (count() == 0)
            return ;
        values.remove(count() - 1);

    }

    public int getBiggest() {
        if (count() == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (Integer value : values)
            if (value > max)
                max = value;
        return max;
    }

    public void print() {
        for (Integer value : values)
            System.out.print(value + " ");
        System.out.println();
    }

    public int count() {
        return values.size();
    }
}