public class Exercise1 {
        private int[] myStack;
        private int topStack;
        private int sizeStack;
        public Exercise1 (int sizeStack){
            this.sizeStack= sizeStack;
            myStack=new int [sizeStack];
            topStack=-1;
        }
        public void toAddElementToStack(int element) {
            myStack[++topStack] = element;
        }
        public int toDeleteElementFromStack() {
            return myStack[topStack--];
        }
        public int toDisplayTop() {
            return myStack[topStack];
        }
        public boolean isEmpty() {
            return (topStack == -1);
        }
        public boolean isFull() {
            return (topStack == sizeStack - 1);
        }
}
