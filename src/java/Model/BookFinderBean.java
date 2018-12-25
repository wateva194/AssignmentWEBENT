/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Book;
import DataAccess.BookDataAccess;
import Entities.BookHistory;
import java.util.List;

/**
 *
 * @author wateva
 */
public class BookFinderBean {
    private String keyword;
    private int id;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        BookDataAccess da = new BookDataAccess();
        if(status.equals("Borrow")){
            da.InsertBorrowHistory(id, "Đang mượn");
            da.UpdateBookStatus(id, "Đang mượn");
        }else
        {
            da.InsertBorrowHistory(id, "Chưa mượn");
            da.UpdateBookStatus(id, "Chưa mượn");
        }
    }
    public String getKeyword() {
        return keyword;
    }
    
    public int getId() {
        return id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<Book> getBooks(){
        return new BookDataAccess().getBookByKeyword(keyword);
    }
    
    public List<BookHistory> getBookHistories(){
        return new BookDataAccess().getBookHistoriesByID(id);
    }
}
