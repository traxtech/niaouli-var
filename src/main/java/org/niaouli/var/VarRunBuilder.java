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
import java.util.List;
import org.niaouli.exception.AppException;

/**
 * Variable instance builder.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarRunBuilder implements Serializable {

    /**
     * Error message if a variable instance build has no definition.
     */
    public static final String MSG_NODEF = "org.niaouli.var.run.noDef";

    /**
     * Variable definition.
     */
    private VarDef def;
    /**
     * Variable values.
     */
    private List<String> values = new ArrayList<String>();

    /**
     * Builds a variable instance.
     *
     * @return New variable instance.
     * @throws AppException On error. Messages: MSG_NODEF
     */
    public final VarRun build() throws AppException {
        if (def == null) {
            throw new AppException(MSG_NODEF);
        }
        return new VarRun(this);
    }

    /**
     * Empty constructor.
     */
    public VarRunBuilder() {

    }

    /**
     * Constructs a variable instance.
     *
     * @param pDef Variable definition.
     * @param pValue Value.
     */
    public VarRunBuilder(final VarDef pDef, final String pValue) {
        def = pDef;
        values = new ArrayList<String>();
        values.add(pValue);
    }

    /**
     * Constructs a variable instance.
     *
     * @param pDef Variable definition.
     * @param pValues Values.
     */
    public VarRunBuilder(final VarDef pDef, final List<String> pValues) {
        def = pDef;
        values = new ArrayList<String>(pValues);
    }

    /**
     * Constructs a variable instance.
     *
     * @param pDef Variable definition. F
     */
    public VarRunBuilder(final VarDef pDef) {
        def = pDef;
        values = new ArrayList<String>();
    }

    /**
     * Gets the variable definition.
     *
     * @return Variable definition.
     */
    public final VarDef getDef() {
        return def;
    }

    /**
     * Sets the variable definition.
     *
     * @param pDef New variable definition.
     */
    public final void setDef(final VarDef pDef) {
        def = pDef;
    }

    /**
     * Gets the values.
     *
     * @return Values.
     */
    public final List<String> getValues() {
        return values;
    }

    /**
     * Sets the values.
     *
     * @param pValues New values.
     */
    public final void setValues(final List<String> pValues) {
        if (pValues == null) {
            values.clear();
        } else {
            values = new ArrayList<String>(pValues);
        }
    }

    /**
     * Adds a value.
     *
     * @param pValue Value to add.
     * @return Reference to this (for method call chaining).
     */
    public final VarRunBuilder addValue(final String pValue) {
        values.add(pValue);
        return this;
    }

}
