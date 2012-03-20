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
public class Advertisement
{
	 @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String heading;

    @Persistent
    private String text;

    @Persistent
    private Date addDate;
    
    @Persistent
    private int serviceProviderId;

   
   /**
    * @param heading
    * @param text
    * @param addDate
    * @param serviceProviderId
    */
   public Advertisement(String heading, String text, Date addDate, int serviceProviderId) 
   {
        this.heading = heading;
        this.text = text;
        this.addDate = addDate;
        this.serviceProviderId = serviceProviderId;
    }

    /**
    * @return Key
    */
   public Key getKey() {
        return key;
    }

    /**
    * @return Heading
    */
   public String getHeading() {
        return heading;
    }

    /**
    * @return String
    */
   public String getText() {
        return text;
    }

    /**
    * @return Date
    */
   public Date getAddDate() {
        return addDate;
    }
   
   /**
    * @return int
    */
   public int getServiceProviderId() {
      return serviceProviderId;
  }

    /**
    * @param heading
    */
   public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
    * @param text
    */
   public void setText(String text) {
        this.text = text;
    }

    /**
    * @param addDate
    */
   public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
   
   
   /**
    * @param serviceProviderId
    */
   public void setServiceProviderId(int serviceProviderId) {
      this.serviceProviderId = serviceProviderId;
  }


}
