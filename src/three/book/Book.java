/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.book;

import java.sql.Date;

public class Book {

    private Integer Id;
    private String bookName;
    private String authorName;
    private String publisher;
    private Date publishingDate;

    public Book(Integer Id, String bookName, String authorName, String publisher, Date publishingDate) {
        this.Id = Id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
    }

    public Integer getId() {
        return Id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

}
