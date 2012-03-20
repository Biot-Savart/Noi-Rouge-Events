/**
 * 
 */
package com.noirougeevents.com.server.datastore;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


/**
 * @author RynoM
 *
 */
@PersistenceCapable
public class DataTest
{
	 @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String author;

    @Persistent
    private String content;

    @Persistent
    private Date date;

    /**
    * @param author
    * @param content
    * @param date
    */
   public DataTest(String author, String content, Date date) {
        this.author = author;
        this.content = content;
        this.date = date;
    }

    /**
    * @return Key
    */
   public Key getKey() {
        return key;
    }

    /**
    * @return User
    */
   public String getAuthor() {
        return author;
    }

    /**
    * @return String
    */
   public String getContent() {
        return content;
    }

    /**
    * @return Date
    */
   public Date getDate() {
        return date;
    }

    /**
    * @param author
    */
   public void setAuthor(String author) {
        this.author = author;
    }

    /**
    * @param content
    */
   public void setContent(String content) {
        this.content = content;
    }

    /**
    * @param date
    */
   public void setDate(Date date) {
        this.date = date;
    }


}
