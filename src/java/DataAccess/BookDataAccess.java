/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Book;
import Entities.BookHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wateva
 */
public class BookDataAccess {
    private PreparedStatement searchStt;
    private PreparedStatement insertStt;
    private PreparedStatement updateStt;
    
    private PreparedStatement getSearchAllStt() throws ClassNotFoundException, SQLException{
        if(searchStt == null){
            Connection con = new DBConnection().getConnection();
            searchStt = 
                    con.prepareStatement(
                            "SELECT * from BOOKSTORE");
            
        }
        return searchStt;
    }
    
    private PreparedStatement getSearchStt() throws ClassNotFoundException, SQLException{
        if(searchStt == null){
            Connection con = new DBConnection().getConnection();
            searchStt = 
                    con.prepareStatement(
                            "SELECT * from BOOKSTORE where Code like ? or Name like ?");
            
        }
        return searchStt;
    }
    
    private int GetMaxID()throws ClassNotFoundException, SQLException{
        Connection con = new DBConnection().getConnection();
        Statement stt = con.createStatement();
        ResultSet rs= stt.executeQuery("select max(Id) as Id from BookHistory");
        while(rs.next()){
            return rs.getInt("Id");
        }
        
        return -1;
    }
    
    private PreparedStatement getInsertStatement() throws ClassNotFoundException, SQLException{
        if(insertStt == null){
            Connection con = new DBConnection().getConnection();
            insertStt = 
                    con.prepareStatement(
                            "Insert into BookHistory (Id, code, CreatedDTG, Status)"
                                    + " values (?, ?, ?, ?)");
        }
        return insertStt;
    }
    
    private PreparedStatement getUpdateStt() throws ClassNotFoundException, SQLException{
        if(updateStt == null){
            Connection con = new DBConnection().getConnection();
            updateStt = 
                    con.prepareStatement(
                            "Update BOOKSTORE set Status = ? where Id = ?");
        }
        return updateStt;
    }
    
    private PreparedStatement getSearchHisStt() throws ClassNotFoundException, SQLException{
        if(searchStt == null){
            Connection con = new DBConnection().getConnection();
            searchStt = 
                    con.prepareStatement(
                            "SELECT his.*, bk.Name "
                                    + " from BookHistory his"
                                    + " join BookStore bk on bk.Id = his.BookId "
                                    + " where his.BookId = ?"
                                    + " order by his.CreatedDTG desc");
            
        }
        return searchStt;
    }
    
    public List<Book> getBookByKeyword(String keyword){
        try{
            PreparedStatement stt;
            if (keyword.trim().equals("")){
            stt = getSearchAllStt();
            }else
            {
            stt = getSearchStt();
            stt.setString(1, "%" + keyword + "%");
            stt.setString(2, "%" + keyword + "%");
            }
            ResultSet rs = stt.executeQuery();
            List<Book> books = new LinkedList<Book>();
            while(rs.next()){
                books.add(new Book(rs.getInt("Id"),
                        rs.getString("Code"), 
                        rs.getString("Name"), 
                        rs.getString("Author"),
                        rs.getString("Status")));
            }
            return books;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public List<BookHistory> getBookHistoriesByID(int id){
        try{
            PreparedStatement stt = getSearchHisStt();
            stt.setInt(1, id);
            ResultSet rs = stt.executeQuery();
            List<BookHistory> his = new LinkedList<BookHistory>();
            
            int index = 1;
            while(rs.next()){
                BookHistory item = new BookHistory(rs.getString("Name"),
                        rs.getDate("CreatedDTG"),
                        rs.getString("Status"));
                item.setOrderNo(index);
                his.add(item);
                index++;
            }
            return his;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void InsertBorrowHistory(int id, String newStt){
    try{
            PreparedStatement stt = getInsertStatement();
            int maxId = GetMaxID();
            if (maxId == -1){
            throw new Exception("Can't select max Id");
                    }
            
            stt.setInt(1, (maxId + 1));
            stt.setInt(2, id);
            stt.setDate(3, new java.sql.Date(new Date().getTime()));
            stt.setString(4, newStt);
            int rs = stt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void UpdateBookStatus(int id, String newStt){
        try{
            PreparedStatement stt = getUpdateStt();
            stt.setString(1, newStt);
            stt.setInt(2, id);
            int rs = stt.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
