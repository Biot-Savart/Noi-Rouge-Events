/**
 * 
 */
package com.noirougeevents.com.server.datastore;

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
public class Sp_Types
{
	 @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String name;

    @Persistent
    private String description;   
  
  
   /**
    * @param name
    * @param description
    */
   public Sp_Types(String name, String description) 
   {
        this.name = name;
        this.description = description;       
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
   
}
