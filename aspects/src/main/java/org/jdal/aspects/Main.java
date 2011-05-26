/*
 * Copyright 2009-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdal.aspects;

import info.joseluismartin.beans.AppCtx;
import info.joseluismartin.dao.Dao;
import lazy.Cat;
import lazy.Dog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 *
 */
public class Main {
	
	private static final Log log = LogFactory.getLog(Main.class);
	public static void main (String[] arg) {
		AppCtx.getInstance();
		Dao<Dog, Long> dogDao = (Dao<Dog, Long>) AppCtx.getInstance().getBean("dogDao");
		Dog dog = dogDao.get(1l);
		
		for (Cat cat : dog.getCats()) 
			log.info(cat.getName());
	}

}
