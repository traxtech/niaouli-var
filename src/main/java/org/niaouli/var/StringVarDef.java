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
 * String variable definition. Used to define an string subtype for values
 * validation.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class StringVarDef extends VarDef implements Serializable {

    /**
     * Error message if a string length is lower that its allowed minimum
     * length.
     *
     * Parameter 1 : Minimum allowed length. Parameter 2 : Actual length.
     * Parameter 3 : Actual value.
     */
    public static final String MSG_MIN_LENGTH
            = "org.niaouli.var.string.minLength";

    /**
     * Error message if a string length is greater that its allowed maximum
     * length.
     *
     * Parameter 1 : Maximum allowed length. Parameter 2 : Actual length.
     * Parameter 3 : Actual value.
     */
    public static final String MSG_MAX_LENGTH
            = "org.niaouli.var.string.maxLength";

    /**
     * Minimum allowed length of the string value.
     */
    private final Integer minLength;
    /**
     * Maximum allowed length of the string value.
     */
    private final Integer maxLength;

    /**
     * Constructs a StringVarDef from a builder.
     *
     * @param pBuilder Builder to get the fields from.
     */
    protected StringVarDef(final StringVarDefBuilder pBuilder) {
        super(pBuilder);
        minLength = pBuilder.getMinLength();
        maxLength = pBuilder.getMaxLength();
    }

    @Override
    protected final void validateValue(final String pValue,
            final List<AppError> pErrors) {
        int currLength = pValue.length();
        if (minLength != null && currLength < minLength) {
            pErrors.add(new AppError(MSG_MIN_LENGTH,
                    new Serializable[]{minLength, currLength, pValue},
                    getName()));
        }
        if (maxLength != null && currLength > maxLength) {
            pErrors.add(new AppError(MSG_MAX_LENGTH,
                    new Serializable[]{maxLength, currLength, pValue},
                    getName()));
        }
    }

    /**
     * Gets the minimum allowed length of the string value.
     *
     * @return Minimum allowed length of the string value.
     */
    public final Integer getMinLength() {
        return minLength;
    }

    /**
     * Gets the maximum allowed length of the string value.
     *
     * @return Maximum allowed length of the string value.
     */
    public final Integer getMaxLength() {
        return maxLength;
    }

}
