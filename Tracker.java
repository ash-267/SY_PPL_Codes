Package asn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Expense
{
  String category;
  double amount;
  String date;
   Expense(String category, double amount, String date)
  {
      this.category = category;
      this.amount = amount;
      this.date = date;
  }
   public String toString()
  {
      return date + " | " + amount + " | " + category;
  }
}
class ExpTrack
{
  private ArrayList<Expense> expenses = new ArrayList<>();
  HashMap<String, Double> CatTotal= new HashMap<>();
  HashMap<String, Double> DateTotal= new HashMap<>();
  HashMap<String, Double> MonthTotal= new HashMap<>();
  double totalexp=0.0;

  public void addExp(String category, double amount, String date)
  {
      expenses.add(new Expense(category, amount, date));
      System.out.println("Expense added: " + category);
  }
  public void displayExpenses()
  {
      for (int i=0;i<expenses.size();i++)
      {
          System.out.println((i+1) + " | " + expenses.get(i));
      }
  }
   public void deleteExp(int index)
  {
      if (index > 0 && index <= expenses.size())
      {
          Expense removed = expenses.remove(index-1);
          System.out.println("\nDeleted: "+removed);
      }
      else
      {
          System.out.println("Invalid index! Cannot delete.");
      }
  }
 
  public void generateSummary()
  {
       totalexp=0.0;
       CatTotal.clear();
       DateTotal.clear();
       MonthTotal.clear();

       for(int i=0;i<expenses.size();i++)
       {
           Expense e = expenses.get(i);
           totalexp += e.amount;

           CatTotal.put(e.category,CatTotal.getOrDefault(e.category, 0.0) + e.amount);
           DateTotal.put(e.date,DateTotal.getOrDefault(e.date, 0.0) + e.amount);

           String parts[] = e.date.split("/");
           if(parts.length==3)
           {
               String mthyr = parts[1] + "/" + parts[2];
               MonthTotal.put(mthyr,MonthTotal.getOrDefault(mthyr, 0.0) + e.amount);
           }
       }

       System.out.println("\nTotal Expense: " + totalexp);

       System.out.println("\n--- Category Summary ---");
       ArrayList<String> categories = new ArrayList<>(CatTotal.keySet());
       for(int i=0;i<categories.size();i++)
       {
           String cat=categories.get(i);
           System.out.println(cat + ":" + CatTotal.get(cat));
       }

       System.out.println("\n--- Date Summary ---");
       ArrayList<String> dates = new ArrayList<>(DateTotal.keySet());
       for(int i=0;i<dates.size();i++)
       {
           String d=dates.get(i);
           System.out.println(d + ":" + DateTotal.get(d));
       }

       System.out.println("\n--- Month Summary ---");
       ArrayList<String> months = new ArrayList<>(MonthTotal.keySet());
       for(int i=0;i<months.size();i++)
       {
           String m=months.get(i);
           System.out.println(m + ":" + MonthTotal.get(m));
       }
  }
}
public class Tracker
{
  public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      ExpTrack obj = new ExpTrack();

      while(true)
      {
          System.out.println("\nEnter choice:");
          System.out.println("1) Add Expense");
          System.out.println("2) Delete Expense");
          System.out.println("3) View Expenses");
          System.out.println("4) Generate Summary");
          System.out.println("5) Exit");

          int ch = sc.nextInt();
          sc.nextLine();

          if(ch == 5)
          {
              break;
          }
          else if(ch == 1)
          {
              System.out.println("Enter Category:");
              String category = sc.nextLine();

              System.out.println("Enter Amount:");
              double amount = sc.nextDouble();
              sc.nextLine();

              System.out.println("Enter Date (dd/mm/yyyy):");
              String date = sc.nextLine();

              obj.addExp(category, amount, date);
          }
          else if(ch == 2)
          {
              obj.displayExpenses();
              System.out.println("Enter index to delete:");
              int index = sc.nextInt();
              sc.nextLine();

              obj.deleteExp(index);
          }
          else if(ch == 3)
          {
              obj.displayExpenses();
          }
          else if(ch == 4)
          {
              obj.generateSummary();
          }
          else
          {
              System.out.println("Invalid choice!");
          }
      }

      sc.close();
  }
}
