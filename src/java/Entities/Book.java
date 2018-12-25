/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author wateva
 */
public class Book {
    private int Id;
    private String Code;
    private String Name;
    private String Author;
    private String Status;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Book(int Id, String Code, String Name,String Author, String Status) {
        this.Id= Id;
        this.Code = Code;
        this.Name = Name;
        this.Status = Status;
        this.Author = Author;
    }
    
    public Book(){}
}
