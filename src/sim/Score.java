/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim;


public class Score {
     private Integer scoreId,st_id,full_marks,score_written,score_evedence,Score_Total;
    String c_label, batch_N, ex_id, ex_date,remarks,course_ID;
  
    double parcentage;

//  byte[] person_image;String f_name,String l_name,
    public Score(int scoreId,int st_id,
            String c_label,String batch_N,String ex_id,
            String ex_date,int full_marks,
            int score_written,int score_evedence,
            int Score_Total,double parcentage,String remarks,String course_ID
    ) {
        this.scoreId = scoreId;
        this.st_id = st_id;
//        this.f_name = f_name;
//        this.l_name = l_name;
        this.c_label = c_label;
        this.batch_N = batch_N;
        this.ex_id = ex_id;
        this.ex_date = ex_date;
        this.full_marks = full_marks;
        this.score_written = score_written;
        this.score_evedence = score_evedence;
        this.Score_Total = Score_Total;
        this.parcentage = parcentage;
        this.remarks = remarks;
        this.course_ID = course_ID;
  
    }

    public int getScoreId() {
        return scoreId;

    }
    public int getst_id() {
        return st_id;

    }

//    public String getf_name() {
//        return f_name;
//
//    }
//
//    public String getl_name() {
//        return l_name;
//
//    }

    public String getc_label() {
        return c_label;

    }

    public String getbatch_N() {
        return batch_N;

    }

    public String getex_id() {
        return ex_id;

    }

    public String getex_date() {
        return ex_date;

    }

    public int getfull_marks() {
        return full_marks;

    }
    public int getscore_written() {
        return score_written;

    }
    public int getscore_evedence() {
        return score_evedence;

    }
    public int getScore_Total() {
        return Score_Total;

    }

  

    public Double getparcentage() {
        return parcentage;

    }

    public String getremarks() {
        return remarks;

    }
    public String getcourse_ID() {
        return course_ID;

    }

 
      
    
  
    
    


  
    
    
}
