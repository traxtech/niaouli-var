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
 * Integer variable definition. Used to define an integer subtype for values
 * validation.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class IntegerVarDef extends VarDef implements Serializable {

    /**
     * Error message if a given value is not an integer.
     *
     * Parameter 1 : Value as a string.
     */
    public static final String MSG_FORMAT
            = "org.niaouli.var.integer.format";

    /**
     * Error message if a given value is lower that its allowed minimum value.
     *
     * Parameter 1 : Minimum allowed value. Parameter 2 : Actual value.
     */
    public static final String MSG_MIN_VALUE
            = "org.niaouli.var.integer.minValue";

    /**
     * Error message if a given value is greater that its allowed maximum value.
     *
     * Parameter 1 : Maximum allowed value. Parameter 2 : Actual value.
     */
    public static final String MSG_MAX_VALUE
            = "org.niaouli.var.integer.maxValue";

    /**
     * Minimum allowed value of the integer value.
     */
    private final Integer minValue;
    /**
     * Maximum allowed value of the integer value.
     */
    private final Integer maxValue;

    /**
     * Constructs an IntegerVarDef from a builder.
     *
     * @param pBuilder Builder to get the fields from.
     */
    protected IntegerVarDef(final IntegerVarDefBuilder pBuilder) {
        super(pBuilder);
        minValue = pBuilder.getMinValue();
        maxValue = pBuilder.getMaxValue();
    }

    @Override
    protected final void validateValue(final String pValue,
            final List<AppError> pErrors) {
        final int value;
        try {
            value = Integer.parseInt(pValue);
        } catch (NumberFormatException ex) {
            pErrors.add(new AppError(MSG_FORMAT,
                    new Serializable[]{pValue}, getName()));
            return;
        }
        if (minValue != null && value < minValue) {
            pErrors.add(new AppError(MSG_MIN_VALUE,
                    new Serializable[]{minValue, value}, getName()));
        }
        if (maxValue != null && value > maxValue) {
            pErrors.add(new AppError(MSG_MAX_VALUE,
                    new Serializable[]{maxValue, value}, getName()));
        }
    }

    /**
     * Gets the minimum allowed value of the integer value.
     *
     * @return Minimum allowed value of the integer value
     */
    public final Integer getMinValue() {
        return minValue;
    }

    /**
     * Gets the maximum allowed value of the integer value.
     *
     * @return Maximum allowed value of the integer value
     */
    public final Integer getMaxValue() {
        return maxValue;
    }

}
