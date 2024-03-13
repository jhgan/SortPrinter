import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("여러가지 숫자를 넣어 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lst = new ArrayList<Integer>();

        try {
            while (st.hasMoreElements()) {
                lst.add(Integer.parseInt(st.nextToken()));
            }
        } catch(Exception e) {
            System.err.println("숫자만 입력 가능합니다. 프로그램을 종료합니다.");
            return;
        }

        try {
            System.out.println("알고리즘을 선택해주세요. 1: 버블정렬, 2: 선택정렬");

            st = new StringTokenizer(br.readLine());

            int algorithm = Integer.parseInt(st.nextToken());
            
            if(algorithm != 1 && algorithm != 2) {
                System.err.println("1 또는 2만 입력해 주세요. 프로그램을 종료합니다.");
            }
        } catch(Exception e) {
            System.err.println("숫자만 입력 가능합니다. 프로그램을 종료합니다.");
            return;
        }

        SortPrinter sp = new SortPrinter();
        sp.selection(1);
        sp.insert(lst);
        sp.run();
        sp.show();
    }
}

interface Sort {
    public void run(ArrayList<Integer> lst);
}

class SortPrinter {
    ArrayList<Integer> lst;
    Sort sort;

    public void insert(ArrayList<Integer> lst) {
        this.lst = lst;
    }
    public void selection(int algorithm) {
        if(algorithm == 1)
            this.sort = new BubbleSort();
        else if(algorithm == 2)
            this.sort = new SelectionSort();
    }
    public void run() {
        this.sort.run(lst);
    }
    public void show() {
        System.out.println(lst.toString());
    }
}

class SelectionSort implements Sort {
    @Override
    public void run(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}

class BubbleSort implements Sort {
    @Override
    public void run(ArrayList<Integer> lst) {
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}