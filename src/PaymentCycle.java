import java.util.ArrayList;
import java.util.Scanner;


public class PaymentCycle {

    Scanner sc = new Scanner(System.in);

    /*
    Instance variables
     */
    private ArrayList<Roommate> people = new ArrayList<>();
    private double totalCost;
    private double totalOverage;
    private double target;
    private int numPeople;

    /*
    Constructor statement
     */
    public PaymentCycle() {

        System.out.println("How many people are involved in the transaction?");
        numPeople = sc.nextInt();

        //takes in all user's name and costs
        for(int i = 0; i < numPeople; i++){
            String tempName;
            double tempAmount;

            if(i == 0){
                System.out.println("What is the first person's name?");
            }else{
                System.out.println("What is the next person's name?");
            }

            tempName = sc.next();
            System.out.println("How much did they spend?");
            tempAmount = sc.nextDouble();

            people.add(new Roommate(tempName, tempAmount));


        }


        totalCost = calculateTotal();
        target = totalCost / numPeople;

        for(int i = 0; i < people.size(); i++){

            people.get(i).calculateOverUnder(target);

        }

        totalOverage = calculateTotalOverage();

        for(int i = 0; i < people.size(); i++){

            people.get(i).setOverageCoefficient(totalOverage);

        }

        System.out.println("Finished constructing PaymentCycle");
    }

    protected void calculatePayments(){



    }

    protected void getStats(){
        System.out.println("Number of people: " + numPeople);
        System.out.println("Total cost: " + totalCost);
        System.out.println("Total overage: " + totalOverage);
        System.out.println("Target: " + target);
    }

    protected void findTargets(){

        for (Roommate person : people) {

            person.calculateOverUnder(target);

        }

    }

    private double calculateTotal(){
        double total = 0;

        for (Roommate person : people) {
            total += person.getExpenses();
        }

        return total;
    }

    private double calculateTotalOverage(){

        double temp = 0;

        for(int i = 0; i < people.size(); i++){

            if(people.get(i).getOverage() > 0) {
               temp += people.get(i).getOverage();
            }

        }
         return temp;
        
    }

    public void findPayments(){
        String str;
        double tempAmountOwed = 0;

        for(int i = 0; i < people.size(); i++){

            if(people.get(i).getOverage() < 0){
                for (int j = 0; j < people.size(); j++){
                    tempAmountOwed = people.get(i).getOverage() * people.get(j).getOverageCoefficient();
                    if(tempAmountOwed != 0){
                        tempAmountOwed  *= -1;
                        str = String.format("%.2f", tempAmountOwed);
                        System.out.println(people.get(i).getName() + " owes " + people.get(j).getName() + " $" + (str));
                    }
                }
            }

        }

    }

}