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
public class Service_Provider
{
	 @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String name;

    @Persistent
    private String description;

    @Persistent
    private Date joinDate;
    
    @Persistent
    private int spTypeId;
    
    @Persistent
    private String userName;
    
    @Persistent
    private String password;

   
  
   /**
    * @param name
    * @param description
    * @param joinDate
    * @param spTypeId
    * @param userName 
    * @param password
    */
   public Service_Provider(String name, String description, Date joinDate, int spTypeId,String userName,String password) 
   {
        this.name = name;
        this.description = description;
        this.joinDate = joinDate;
        this.spTypeId = spTypeId;
        this.userName = userName;
        this.password = password;
    }

    /**
    * @return Key
    */
   public Key getKey() {
        return key;
    }

    /**
    * @return name
    */
   public String getName() {
        return name;
    }

    /**
    * @return description
    */
   public String getDescription() {
        return description;
    }

    /**
    * @return joinDate
    */
   public Date getJoinDate() {
        return joinDate;
    }
   
  
   /**
    * @return spTypeId
    */
   public int getSpTypeId() {
      return spTypeId;
  }
   
   
   /**
    * @return userName
    */
   public String getUserName() {
      return userName;
  }
   
   
   /**
    * @return password
    */
   public String getPassword() {
      return password;
  }

   
   /**
    * @param name
    */
   public void setName(String name) {
        this.name = name;
    }

   
   /**
    * @param description
    */
   public void setDescription(String description) {
        this.description = description;
    }

   
   /**
    * @param joinDate
    */
   public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
   
   
  
   /**
    * @param spTypeId
    */
   public void setSpTypeId(int spTypeId) {
      this.spTypeId = spTypeId;
  }
   
   
   /**
    * @param userName
    */
   public void setUserName(String userName) {
      this.userName = userName;
  }
   
   
   /**
    * @param password
    */
   public void setPassword(String password) {
      this.password = password;
  }


}
