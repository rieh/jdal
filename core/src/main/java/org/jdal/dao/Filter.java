/*
 * Copyright 2008-2011 the original author or authors.
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
package org.jdal.dao;

import java.util.Map;

/**
 * Filter to use with PageableDatasource
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public interface Filter {
	
	/**
	 * Gets the filter name
	 * @return the filter name
	 */
	public String getFilterName();
	
	/**
	 * Get filter values as map
	 * @return map with filter values.
	 */
	public Map<String, Object> getParameterMap();
	
	/**
	 * Clear filter values 
	 */
	public void clear();
}
