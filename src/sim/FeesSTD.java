
package sim;


public class FeesSTD {
     private Integer fees_id,st_id,total_fees,payment_amount,total_pay,payment_due;
    String st_name, reg_date,payment_Date;

    public FeesSTD(int fees_id,int st_id,
            String st_name,String reg_date,int total_fees,
            int payment_amount,int total_pay,int payment_due,
            String payment_Date) 
    {
        this.fees_id = fees_id;
        this.st_id = st_id;
        this.total_fees = total_fees;
        this.payment_amount = payment_amount;
        this.payment_due = payment_due;
        this.st_name = st_name;
        this.reg_date = reg_date;
        this.payment_Date = payment_Date;
        this.total_pay = total_pay;
        
  
    }

    public int getFees_id() {
        return fees_id;
    }

    public int getSt_id() {
        return st_id;
    }
    public int gettotal_pay() {
        return total_pay;
    }

    public int getTotal_fees() {
        return total_fees;
    }

    public int getPayment_amount() {
        return payment_amount;
    }

    public int getPayment_due() {
        return payment_due;
    }

    public String getSt_name() {
        return st_name;
    }

    public String getReg_date() {
        return reg_date;
    }

    public String getCurrent_date() {
        return payment_Date;
    }

 

   

 
      
    
  
    
    


  
    
    
}
