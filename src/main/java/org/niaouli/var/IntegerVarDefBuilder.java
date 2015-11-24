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

    public final IntegerVarDef build() throws AppException {
        return new IntegerVarDef(this);
    }

    public final Integer getMinValue() {
        return minValue;
    }

    public final void setMinValue(final Integer pMinValue) {
        minValue = pMinValue;
    }

    public final Integer getMaxValue() {
        return maxValue;
    }

    public final void setMaxValue(final Integer pMaxValue) {
        maxValue = pMaxValue;
    }

}
