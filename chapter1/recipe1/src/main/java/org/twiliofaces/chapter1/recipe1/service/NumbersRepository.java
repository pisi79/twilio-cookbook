/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.chapter1.recipe1.service;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class NumbersRepository implements Serializable
{
   private static final long serialVersionUID = 1L;

   Map<String, String> usernameNumberMap = new ConcurrentHashMap<String, String>();
   Map<String, String> numberPassowrdMap = new ConcurrentHashMap<String, String>();

   public NumbersRepository()
   {
   }

   public boolean containsNumber(String number)
   {
      return getNumberPassowrdMap().containsKey(number);
   }

   public boolean containsUsername(String username)
   {
      return getUsernameNumberMap().containsKey(username);
   }

   public void putUsernameNumber(String username, String number)
   {
      getUsernameNumberMap().put(username, number);
   }

   public void putNumberPassword(String number, String password)
   {
      getNumberPassowrdMap().put(number, password);
   }

   public void putUsernameNumberPassword(String username, String number,
            String password)
   {
      putUsernameNumber(username, number);
      putNumberPassword(number, password);
   }

   public void removeNumberPassword(String number)
   {
      getNumberPassowrdMap().remove(number);
   }

   public String getByNumber(String number)
   {
      return getNumberPassowrdMap().get(number);
   }

   public String getByUsername(String username)
   {
      return getUsernameNumberMap().get(username);
   }

   public Map<String, String> getUsernameNumberMap()
   {
      return this.usernameNumberMap;
   }

   public Map<String, String> getNumberPassowrdMap()
   {
      return this.numberPassowrdMap;
   }

}
