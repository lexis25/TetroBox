public class Player {

    private static int counterRotation = 1;


    public static int[] rotationFigure (int[] array) {
        int loop = array.length / 4;
        int[] copyArray = new int[4];
        if (loop == counterRotation) {
            counterRotation = 0;
        }else {
            System.arraycopy(array, (4 * counterRotation), copyArray, 0, 4);
            counterRotation++;
        }
        return copyArray;
    }
}
