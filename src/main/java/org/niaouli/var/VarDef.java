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
public abstract class VarDef implements Serializable {

    private final String name;
    private final String description;
    private final int minCardinality;
    private final Integer maxCardinality;

    protected VarDef(final VarDefBuilder pBuilder) {
        name = pBuilder.getName();
        description = pBuilder.getDescription();
        minCardinality = pBuilder.getMinCardinality();
        maxCardinality = pBuilder.getMaxCardinality();
    }

    public final void validate(final VarRun pVarRun,
            final List<AppError> pErrors) {
        if (pVarRun.getValues() == null) {
            pErrors.add(new AppError("nullValues"));
            return;
        }
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

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final int getMinCardinality() {
        return minCardinality;
    }

    public final Integer getMaxCardinality() {
        return maxCardinality;
    }

    protected abstract void validateValue(String pValue,
            List<AppError> pErrors);

}
