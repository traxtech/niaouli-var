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
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarRun implements Serializable {

    private final String def;
    private final List<String> values;

    public VarRun(final VarRunBuilder pBuilder) {
        def = pBuilder.getDef().getName();
        values = new ArrayList<String>(pBuilder.getValues());
    }

    public final String getDef() {
        return def;
    }

    public final List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

}
