public class Die {

    public int n = 0;

    // getting input
    public Die(int sides) {
        this.n = sides;
    }

    // getting random number in range
    public int roll() {
        int number = (int) (Math.random() * this.n) + 1;
        return number;
    }


}