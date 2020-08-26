public class Roommate {

    private String name;
    private double expenses;
    private double overage = 0;
    //private double overageCoefficient = 1;
    private double overageCoefficient = 0;

    public Roommate(String name, double expenses){

        this.name = name;
        this.expenses = expenses;

    }

    public void calculateOverUnder(double tempTarget){
        overage = expenses - tempTarget;
    }

    public String getName() {
        return name;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getOverage(){
        return overage;
    }

    public double getOverageCoefficient(){
            return overageCoefficient;
    }

    public void setOverageCoefficient(double tempTotalOverage){

        if(overage > 0){
            overageCoefficient = overage / tempTotalOverage;
        }

    }

}
