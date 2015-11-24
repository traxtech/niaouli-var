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
package org.niaouli.var.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.var.StringVarDef;
import org.niaouli.var.StringVarDefBuilder;
import org.niaouli.var.VarRun;
import org.niaouli.var.VarRunBuilder;

/**
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class CommonTest {

    private static final String CITY_NAME = "City";
    private static final String CITY_DESCR = "Where to ship";

    @Test
    public void testBuilder() throws AppException {
        StringVarDef city = buildCityVarDef(null, null);
        assertThat(city).isNotNull();
        assertThat(city.getName()).isEqualTo(CITY_NAME);
        assertThat(city.getDescription()).isEqualTo(CITY_DESCR);
        // Default min cardinality must be one
        assertThat(city.getMinCardinality()).isEqualTo(1);
        // Default max cardinality must be one
        assertThat(city.getMaxCardinality()).isEqualTo(1);
    }

    @Test
    public void testDefInRun() throws AppException {
        StringVarDef city = buildCityVarDef(1, 1);
        VarRun newYorkCity = new VarRunBuilder(city, "New York").build();
        assertThat(newYorkCity.getDef()).isEqualTo("New York");
    }

    @Test
    public void testMinCardinality() throws AppException {
        StringVarDef city = buildCityVarDef(1, 1);
        List<AppError> errors = new ArrayList<AppError>();

        VarRun newYorkCity = new VarRunBuilder(city, "New York").build();
        assertThat(newYorkCity.getDef()).isEqualTo("New York");
        errors.clear();
        city.validate(newYorkCity, errors);
        assertThat(errors.isEmpty());

        VarRun noCity = new VarRunBuilder(city, new ArrayList<String>()).build();
        errors.clear();
        city.validate(noCity, errors);
        assertThat(errors).containsExactly(new AppError("minCardinality", new Serializable[]{1, 0}, CITY_NAME));
    }

    @Test
    public void testMaxCardinality() throws AppException {
        StringVarDef city = buildCityVarDef(1, 2);
        List<AppError> errors = new ArrayList<AppError>();

        VarRun newYorkCity = new VarRunBuilder(city, "New York").build();
        errors.clear();
        city.validate(newYorkCity, errors);
        assertThat(errors.isEmpty());

        VarRun twoCities = new VarRunBuilder(city).addValue("New York").addValue("Atlanta").addValue("San Francisco").build();
        errors.clear();
        city.validate(twoCities, errors);
        assertThat(errors).containsExactly(new AppError("maxCardinality", new Serializable[]{2, 3}, CITY_NAME));
    }

    private StringVarDef buildCityVarDef(Integer minCardinality, Integer maxCardinality) throws AppException {
        StringVarDefBuilder builder = new StringVarDefBuilder();
        builder.setName(CITY_NAME);
        builder.setDescription(CITY_DESCR);
        if (minCardinality != null) {
            builder.setMinCardinality(minCardinality);
        }
        if (maxCardinality != null) {
            builder.setMaxCardinality(maxCardinality);
        }
        return builder.build();
    }
}
