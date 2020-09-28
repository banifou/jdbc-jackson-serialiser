
package io.banifou.quarkus;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "public")
@JsonSerialize(using = BookSerializer.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookid")
public class Book implements Serializable {

    private Integer bookid;
    
    @JsonInclude(Include.NON_NULL)
    private String title;
    
    private String isbn;
    
    @JsonInclude(Include.NON_NULL)
    private String author;    
    
    private String status;
    
    @JsonIgnore
    private Basket basketid;

    public Book() {
    }

    public Book(int bookid, String status) {
        this.bookid = bookid;
        this.status = status;
    }

    public Book(int bookid, Basket basketid, String status) {
        this.bookid = bookid;
        this.basketid = basketid;
        this.status = status;
    }

    public Book(String title, String author, String isbn, String status, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid", unique = true, nullable = false)
    public Integer getBookid() {
        return this.bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basketid", referencedColumnName = "basketid", nullable = false)
    public Basket getBasketid() {
        return this.basketid;
    }

    public void setBasketid(Basket basketid) { 
        this.basketid = basketid;
    }

    @Column(name = "title", length = 100)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author", length = 120)
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "isbn", length = 10)
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "status", nullable = false, length = 3)
//    @Enumerated(EnumType.STRING)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
