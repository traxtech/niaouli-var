/**
 * This file is part of Niaouli Var.
 *
 * Niaouli Var is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Niaouli Var is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Niaouli Var. If not, see <http://www.gnu.org/licenses/>.
 */
package org.niaouli.var;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Variable instance.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarRun implements Serializable {

    /**
     * Variable definition name.
     */
    private final String def;
    /**
     * Variable values.
     */
    private final List<String> values;

    /**
     * Constructs a variable instance.
     *
     * @param pBuilder Builder to get the values from.
     */
    public VarRun(final VarRunBuilder pBuilder) {
        def = pBuilder.getDef().getName();
        values = new ArrayList<String>(pBuilder.getValues());
    }

    /**
     * Gets the variable definition name.
     *
     * @return Variable definition name.
     */
    public final String getDef() {
        return def;
    }

    /**
     * Gets the variable values.
     *
     * @return Variable values.
     */
    public final List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

}
