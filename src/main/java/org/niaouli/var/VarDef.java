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
import java.util.List;
import org.niaouli.exception.AppError;

/**
 * Variable definition. Used to validate variable values.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public abstract class VarDef implements Serializable {

    /**
     * Variable name.
     */
    private final String name;
    /**
     * Variable definition.
     */
    private final String description;
    /**
     * Minimum number of values.
     */
    private final int minCardinality;
    /**
     * Maximum number of values.
     */
    private final Integer maxCardinality;

    /**
     * Constructs a VarDef from a builder.
     *
     * @param pBuilder Builder to get the values from.
     */
    protected VarDef(final VarDefBuilder pBuilder) {
        name = pBuilder.getName();
        description = pBuilder.getDescription();
        minCardinality = pBuilder.getMinCardinality();
        maxCardinality = pBuilder.getMaxCardinality();
    }

    /**
     * Validate a variable value(s).
     *
     * @param pVarRun Variable to validate.
     * @param pErrors To append found errors to.
     */
    public final void validate(final VarRun pVarRun,
            final List<AppError> pErrors) {
        int occurs = pVarRun.getValues().size();
        if (occurs < minCardinality) {
            pErrors.add(new AppError("minCardinality", new Serializable[]{
                minCardinality, occurs}, name));
        }
        if (occurs > maxCardinality) {
            pErrors.add(new AppError("maxCardinality", new Serializable[]{
                maxCardinality, occurs}, name));
        }
        for (String value : pVarRun.getValues()) {
            validateValue(value, pErrors);
        }
    }

    /**
     * Gets the variable name.
     *
     * @return Variable name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets the variable definition.
     *
     * @return Variable definition.
     */
    public final String getDescription() {
        return description;
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
     * Gets the maximum number of values.
     *
     * @return Maximum number of values.
     */
    public final Integer getMaxCardinality() {
        return maxCardinality;
    }

    /**
     * Validate a value.
     *
     * @param pValue Value to validate.
     * @param pErrors To append found errors to.
     */
    protected abstract void validateValue(String pValue,
            List<AppError> pErrors);

}
