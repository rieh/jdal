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
package org.jdal.vaadin.ui.table;

import org.jdal.beans.MessageSourceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 *
 */
@Configurable
public abstract class TableButtonListener extends ButtonListener {
	
	private TableComponent<?> table;
	

	protected transient MessageSourceWrapper messageSource = new MessageSourceWrapper();
	
	
	public TableButtonListener() {
		this("");
	}

	public TableButtonListener(String caption, Resource icon) {
		super(caption, icon);
	}

	public TableButtonListener(String caption) {
		this(caption, null);
	}
	
	public void init() {
		
	}

	/**
	 * @return the table
	 */
	public TableComponent<?> getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(TableComponent<?> table) {
		this.table = table;
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void buttonClick(ClickEvent event);

	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource.getMessageSource();
	}

	/**
	 * @param messageSource the messageSource to set
	 */
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource.setMessageSource(messageSource);
	}
	
}
