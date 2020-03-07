package com.example.database;

public class Course {
    private Integer ID;
    private String Title;
    private String Code;
  //  private String Assititle;
  //  private Double Assigrade;

    public Course(Integer ID, String title, String code){ //String assititle, Double assigrade) {
        this.ID = ID;
        Title = title;
        Code = code;
     //   Assititle = assititle;
     //   Assigrade = assigrade;
    }

    public Course(String title, String code){// String assititle, Double assigrade) {
        Title = title;
        Code = code;
     //   Assititle = assititle;
      //  Assigrade = assigrade;
    }
//    public Course( String title, String code) {
//        this.ID = ID;
//        Title = title;
//        Code = code;
//
//    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

   // public String getAssititle() {
   //     return Assititle;
  //  }

   // public void setAssititle(String assititle) {
  //      Assititle = assititle;
   // }

   // public Double getAssigrade() {
    //    return Assigrade;
   // }

  //  public void setAssigrade(Double assigrade) {
     //   Assigrade = assigrade;
   // }
}
