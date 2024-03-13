public class Main {
    public static void main(String[] args) {

    }

    static class SortPrinter {
        Sort sort;

        public void insert() {

        }
        public void selection(Sort sort) {
            this.sort = sort;
        }
        public void run() {
            this.sort.run();
        }
        public void show() {

        }
    }
}

interface Sort {
    public void run();
    public void show();
}
class BubbleSort implements Sort {
    @Override
    public void run() {

    }

    @Override
    public void show() {

    }
}

class SelectionSort implements Sort {
    @Override
    public void run() {

    }

    @Override
    public void show() {

    }
}