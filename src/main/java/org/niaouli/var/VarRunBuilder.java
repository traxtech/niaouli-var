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
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarRunBuilder implements Serializable {

    private VarDef def;
    private List<String> values = new ArrayList<String>();

    public final VarRun build() throws AppException {
        if (def == null) {
            throw new AppException("nullDef");
        }
        List<AppError> errors = new ArrayList<AppError>();
        return new VarRun(this);
    }

    public VarRunBuilder() {

    }

    public VarRunBuilder(final VarDef pDef, final String pValue) {
        def = pDef;
        values = new ArrayList<String>();
        values.add(pValue);
    }

    public VarRunBuilder(final VarDef pDef, final List<String> pValues) {
        def = pDef;
        values = new ArrayList<String>(pValues);
    }

    public VarRunBuilder(final VarDef pDef) {
        def = pDef;
        values = new ArrayList<String>();
    }

    public final VarDef getDef() {
        return def;
    }

    public final void setDef(final VarDef pDef) {
        def = pDef;
    }

    public final List<String> getValues() {
        return values;
    }

    public final void setValues(final List<String> pValues) {
        if (pValues == null) {
            values.clear();
        } else {
            values = new ArrayList<String>(pValues);
        }
    }

    public final VarRunBuilder addValue(final String pValue) {
        values.add(pValue);
        return this;
    }

}
