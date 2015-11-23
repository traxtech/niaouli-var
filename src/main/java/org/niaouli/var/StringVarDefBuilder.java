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

    private Integer minLength;
    private Integer maxLength;

    public final StringVarDef build() throws AppException {
        return new StringVarDef(this);
    }

    public final Integer getMinLength() {
        return minLength;
    }

    public final void setMinLength(final Integer pMinLength) {
        minLength = pMinLength;
    }

    public final Integer getMaxLength() {
        return maxLength;
    }

    public final void setMaxLength(final Integer pMaxLength) {
        maxLength = pMaxLength;
    }

}
