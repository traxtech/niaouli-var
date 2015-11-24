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
import org.niaouli.exception.AppException;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class IntegerVarDefBuilder extends VarDefBuilder
        implements Serializable {

    /**
     * Minimum allowed value of the integer value.
     */
    private Integer minValue;
    /**
     * Maximum allowed value of the integer value.
     */
    private Integer maxValue;

    /**
     * Builds an integer variable definition.
     *
     * @return New integer variable definition.
     * @throws AppException On error.
     */
    public final IntegerVarDef build() throws AppException {
        return new IntegerVarDef(this);
    }

    /**
     * Gets the minimum allowed value of the integer value.
     *
     * @return Minimum allowed value of the integer value.
     */
    public final Integer getMinValue() {
        return minValue;
    }

    /**
     * Sets the minimum allowed value of the integer value.
     *
     * @param pMinValue New minimum allowed value of the integer value.
     */
    public final void setMinValue(final Integer pMinValue) {
        minValue = pMinValue;
    }

    /**
     * Gets the maximum allowed value of the integer value.
     *
     * @return Maximum allowed value of the integer value.
     */
    public final Integer getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the maximum allowed value of the integer value.
     *
     * @param pMaxValue New maximum allowed value of the integer value.
     */
    public final void setMaxValue(final Integer pMaxValue) {
        maxValue = pMaxValue;
    }

}
