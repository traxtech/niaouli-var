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

/**
 * VarDef builder.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarDefBuilder implements Serializable {

    /**
     * Variable name.
     */
    private String name;
    /**
     * Variable definition.
     */
    private String description;
    /**
     * Minimum number of values.
     */
    private int minCardinality = 1;
    /**
     * Maximum number of values.
     */
    private Integer maxCardinality = 1;

    /**
     * Gets the variable name.
     *
     * @return Variable name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the variable name.
     *
     * @param pName New variable name.
     */
    public final void setName(final String pName) {
        name = pName;
    }

    /**
     * Gets the variable description.
     *
     * @return Variable description.
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Sets the variable description.
     *
     * @param pDescription New variable description.
     */
    public final void setDescription(final String pDescription) {
        description = pDescription;
    }

    /**
     * Gets the minimum number of values.
     *
     * @return Minimum number of values.
     */
    public final int getMinCardinality() {
        return minCardinality;
    }

    /**
     * Sets the minimum number of values.
     *
     * @param pMinCardinality New minimum number of values.
     */
    public final void setMinCardinality(final int pMinCardinality) {
        minCardinality = pMinCardinality;
    }

    /**
     * Gets the maximum number of values.
     *
     * @return Maximum number of values.
     */
    public final Integer getMaxCardinality() {
        return maxCardinality;
    }

    /**
     * Sets the maximum number of values.
     *
     * @param pMaxCardinality New maximum number of values.
     */
    public final void setMaxCardinality(final Integer pMaxCardinality) {
        maxCardinality = pMaxCardinality;
    }

}
