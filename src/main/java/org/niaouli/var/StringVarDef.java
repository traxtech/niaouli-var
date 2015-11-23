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
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class StringVarDef extends VarDef implements Serializable {

    private final Integer minLength;
    private final Integer maxLength;

    public StringVarDef(final StringVarDefBuilder pBuilder) {
        super(pBuilder);
        minLength = pBuilder.getMinLength();
        maxLength = pBuilder.getMaxLength();
    }

    @Override
    protected final void validateValue(final String pValue,
            final List<AppError> pErrors) {
        int currLength = pValue.length();
        if (minLength != null && currLength < minLength) {
            pErrors.add(new AppError("minLength", new Serializable[]{minLength,
                currLength, pValue}, getName()));
        }
        if (maxLength != null && currLength > maxLength) {
            pErrors.add(new AppError("maxLength", new Serializable[]{maxLength,
                currLength, pValue}, getName()));
        }
    }

    public final Integer getMinLength() {
        return minLength;
    }

    public final Integer getMaxLength() {
        return maxLength;
    }

}
