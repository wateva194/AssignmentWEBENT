/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author wateva
 */
public class BookHistory {
    private int Id;
    private int BookId;
    private String Status;
    private Date CreatedDTG;
    private String Name;
    private int OrderNo;

    public String getName() {
        return Name;
    }

    public int getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(int OrderNo) {
        this.OrderNo = OrderNo;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getCreatedDTG() {
        return CreatedDTG;
    }

    public void setCreatedDTG(Date CreatedDTG) {
        this.CreatedDTG = CreatedDTG;
    }

    public BookHistory(String Name, Date CreatedDTG, String Status) {
        this.Name = Name;
        this.Status = Status;
        this.CreatedDTG = CreatedDTG;
    }
    
    public  BookHistory(){}
}
