package PizzaCalories_04;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {

        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {

        double calDough = 0;
        double cal = 0;

        if (this.flourType.equals("White")) {
            calDough = 1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            calDough = 1;
        }

//        switch (this.bakingTechnique) {
//            case "Crispy":
//                cal = 0.9;
//                break;
//            case "Chewy":
//                cal = 1.1;
//                break;
//            case "Homemade":
//                cal = 1;
//                break;
//        }

        if(bakingTechnique.equals("Crispy")) {
            cal = 0.9;
        } else if (bakingTechnique.equals("Chewy")) {
            cal = 1.1;
        } else if (bakingTechnique.equals("Homemade")) {
            cal = 1;
        }

        return 2 * this.weight * cal * calDough;
    }
}
