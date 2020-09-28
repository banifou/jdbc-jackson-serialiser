/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.banifou.quarkus;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 *
 * @author fouad
 */
@Entity
@Table(name = "basket", catalog = "quarkus_test", schema = "public")
public class Basket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer basketid;

    private String status;

    private Set<Book> bookList = new HashSet(0);

    public Basket() {
    }

    public Basket(Integer basketid) {
        this.basketid = basketid;
    }

    public Basket(Integer basketid, String status) {
        this.basketid = basketid;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketid", unique = true, nullable = false)
    public Integer getBasketid() {
        return this.basketid;
    }

    public void setBasketid(Integer basketid) {
        this.basketid = basketid;
    }

    @Column(name = "status", nullable = false, length = 3)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "basketid", orphanRemoval = true)
    @OrderBy("bookid DESC")
    @Where(clause = "status = 'ON'")
    public Set<Book> getBookList() {
        return this.bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

}
