package softuni.bg.jsoncardealer.constants;

import java.util.Random;

public enum DiscountPercentage {
    ;
    String ZERO = "0%";
    String FIVE = "5%";
    String THEN = "10%";
    String FIFTEEN = "15%";
    String TWENTY = "20%";
    String THIRTY = "30%";
    String FOURTY = "40%";
    String FIFTY = "50%";

    public String getRandomDiscountPercentage (DiscountPercentage discountPercentage) {

        Random random = new Random();

        int randomInt = random.nextInt(1, 9);

        String percentage = null;

        switch (randomInt){
            case 1 -> percentage = "0%";
            case 2 -> percentage = "5%";
            case 3 -> percentage = "10%";
            case 4 -> percentage = "15%";
            case 5 -> percentage = "20%";
            case 6 -> percentage = "30%";
            case 7 -> percentage = "40%";
            case 8 -> percentage = "50%";

        }

        return percentage;
    }


//   0%, 5%, 10%, 15%, 20%, 30%, 40%, 50%
}
