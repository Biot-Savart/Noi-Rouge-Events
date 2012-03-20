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
public class Advert_Graphics
{
	 @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String url;

    @Persistent
    private int gtTypeId;   
    
    @Persistent
    private int advertisementId;

   
   
   /**
    * @param url
    * @param typeId
    * @param advertisementId
    */
   public Advert_Graphics(String url, int gtTypeId, int advertisementId) 
   {
        this.url = url;
        this.gtTypeId = gtTypeId;
        this.advertisementId = advertisementId;        
    }

    
   /**
    * @return Key
    */
   public Key getKey() {
        return key;
    }

 
   /**
    * @return Url
    */
   public String getUrl() {
        return url;
    }
   
    
   /**
    * @return typeId
    */
   public int getTypeId() {
        return gtTypeId;
    }
      
  
   /**
    * @return advertisementId
    */
   public int getAdvertisementId() {
      return advertisementId;
  }

   
   /**
    * @param url
    */
   public void setUrl(String url) {
        this.url = url;
    }

   
   /**
    * @param typeId
    */
   public void setTypeId(int gtTypeId) {
        this.gtTypeId = gtTypeId;
    }   
   
   
   /**
    * @param advertisementId
    */
   public void setAdvertisementId(int advertisementId) {
      this.advertisementId = advertisementId;
  }


}
