/*
 * Copyright 2009-2011 original author or authors.
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
package info.joseluismartin.gui;


/**
 * Binder interface define methods common to model based
 * representation of data like Views.
 *  
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 * @since 1.0
 * @param <T> model type
 */
public interface Binder<T> extends ModelHolder<T> {

	/**
	 * Update Model from Component
	 */
	void update();
	
	/**
	 * Update Component from model
	 */
	void refresh();
}
