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

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class VarDefBuilder implements Serializable {

    private String name;
    private String description;
    private int minCardinality = 1;
    private Integer maxCardinality = 1;

    public final String getName() {
        return name;
    }

    public final void setName(final String pName) {
        name = pName;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String pDescription) {
        description = pDescription;
    }

    public final int getMinCardinality() {
        return minCardinality;
    }

    public final void setMinCardinality(final int pMinCardinality) {
        minCardinality = pMinCardinality;
    }

    public final Integer getMaxCardinality() {
        return maxCardinality;
    }

    public final void setMaxCardinality(final Integer pMaxCardinality) {
        maxCardinality = pMaxCardinality;
    }

}
