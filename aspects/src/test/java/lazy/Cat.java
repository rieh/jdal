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
package lazy;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
@Entity
public class Cat extends info.joseluismartin.model.Entity {
	
	@ManyToOne
	private Dog dog;

	/**
	 * @return the dog
	 */
	public Dog getDog() {
		return dog;
	}

	/**
	 * @param dog the dog to set
	 */
	public void setDog(Dog dog) {
		this.dog = dog;
	}

}
