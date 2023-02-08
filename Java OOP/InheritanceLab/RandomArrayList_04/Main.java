package RandomArrayList_04;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(1);
        randomArrayList.add(2);
        randomArrayList.add(3);
        randomArrayList.add(4);
        randomArrayList.add(5);
        randomArrayList.add(6);

        System.out.println(randomArrayList.getRandomElement());
    }
}
