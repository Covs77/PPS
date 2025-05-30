/* Copyright [yyyy] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package bmicalc;

public interface MetabolicMetrics {
	
	/**
	 * Determine whether a person has abdominal obesity.
	 * A woman has abdominal obesity if her waist circumference is greater than 80 cm.
	 * A man has abdominal obesity if his waist circumference is greater than 90 cm.
	 * 
	 * @param waistCircumference	Waist circumference.
	 * @param gender				Male ('M') or Female ('F').
	 * @return						True if the person has abdominal obesity, false otherwise.
	 */
	public boolean abdominalObesity(double waistCircumference, Gender gender);

}
