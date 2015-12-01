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

import org.niaouli.exception.AppException;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class StringVarDefBuilder extends VarDefBuilder {

    /**
     * Build error message if the minimum value is greater than the maximum
     * value.
     *
     * Parameter 1 : Minimum value. Parameter 2 : maximum value.
     */
    public static final String MSG_MINMAX
            = "org.niaouli.var.string.minmax";
    /**
     * Minimum allowed length of the string value.
     */
    private Integer minLength;
    /**
     * Maximum allowed length of the string value.
     */
    private Integer maxLength;

    /**
     * Buils a string variable definition.
     *
     * @return New string variable definition.
     * @throws AppException On error.
     */
    public final StringVarDef build() throws AppException {
        if (minLength != null && maxLength != null && minLength > maxLength) {
            throw new AppException(MSG_MINMAX);
        }
        return new StringVarDef(this);
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
     * Sets the Minimum allowed length of the string value.
     *
     * @param pMinLength New minimum allowed length of the string value.
     */
    public final void setMinLength(final Integer pMinLength) {
        minLength = pMinLength;
    }

    /**
     * Gets the maximum allowed length of the string value.
     *
     * @return Maximum allowed length of the string value.
     */
    public final Integer getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the maximum allowed length of the string value.
     *
     * @param pMaxLength New maximum allowed length of the string value.
     */
    public final void setMaxLength(final Integer pMaxLength) {
        maxLength = pMaxLength;
    }

}
