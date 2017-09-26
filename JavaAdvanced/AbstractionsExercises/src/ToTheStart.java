import java.util.Scanner;
public class ToTheStart {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] stars = new String [3][3];

        for (int i = 0; i <stars.length ; i++) {
            String[] star = scanner.nextLine().split(" ");
            for (int j = 0; j <stars[i].length ; j++) {
                stars[i][j] = star[j];
            }
        }

        String[] NormandyPos = scanner.nextLine().split(" ");
        int turns = Integer.parseInt(scanner.nextLine());

        double positionX = Double.parseDouble(NormandyPos[0]);
        double positionY = Double.parseDouble(NormandyPos[1]);


        for (int i = 0; i <=turns ; i++) {
            boolean isStar = false;
            for (int j = 0; j <stars.length ; j++) {
                double starPositionX = Double.parseDouble(stars[j][1]);
                double starPositionY = Double.parseDouble(stars[j][2]);

                if ( (positionY >= starPositionY-1) && (positionY <= starPositionY + 1) &&
                        (positionX >= starPositionX -1) && (positionX <= starPositionX +1 ) ) {
                    System.out.println(stars[j][0].toLowerCase());
                    isStar = true;
                    break;
                }

            }
            if (!isStar) {
                System.out.println("space");
            }

            positionY++;
        }


    }

}
