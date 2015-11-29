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
import static org.junit.Assert.fail;
import org.junit.Test;
import org.niaouli.exception.AppError;
import org.niaouli.exception.AppException;
import org.niaouli.var.IntegerVarDef;
import org.niaouli.var.IntegerVarDefBuilder;
import org.niaouli.var.VarRunBuilder;

/**
 * Tests for the integer variable definition.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class IntegerTest {

    private static final String AGE_NAME = "Age";
    private static final String AGE_DESCR = "Your current age";

    @Test
    public void testBuilder() throws AppException {
        // Min and max values copy
        IntegerVarDef age = buildAgeVarDef(1, 100);
        assertThat(age).isNotNull();
        assertThat(age.getMinValue()).isEqualTo(1);
        assertThat(age.getMaxValue()).isEqualTo(100);
        // Nominal cases
        buildAgeVarDef(null, 100);
        buildAgeVarDef(21, null);
        buildAgeVarDef(null, null);
        // Min value > max value
        try {
            buildAgeVarDef(100, 21);
            fail();
        } catch (AppException ex) {
            assertThat(ex.getErrors()).containsExactly(new AppError(IntegerVarDefBuilder.MSG_MINMAX));
        }
    }

    @Test
    public void testBadFormat() throws AppException {
        IntegerVarDef age = buildAgeVarDef(18, 120);
        List<AppError> errors = new ArrayList<AppError>();
        age.validate(new VarRunBuilder(age, "not-an-integer").build(), errors);
        assertThat(errors).containsExactly(new AppError(IntegerVarDef.MSG_FORMAT, new Serializable[]{"not-an-integer"}, AGE_NAME));
    }

    @Test
    public void testMinValue() throws AppException {
        IntegerVarDef age = buildAgeVarDef(18, 120);
        List<AppError> errors = new ArrayList<AppError>();

        age.validate(new VarRunBuilder(age, "25").build(), errors);
        age.validate(new VarRunBuilder(age, "18").build(), errors);
        assertThat(errors).isEmpty();

        age.validate(new VarRunBuilder(age, "12").build(), errors);
        assertThat(errors).containsExactly(new AppError(IntegerVarDef.MSG_MIN_VALUE, new Serializable[]{18, 12}, AGE_NAME));

        // No min value
        age = buildAgeVarDef(null, 120);
        errors.clear();
        age.validate(new VarRunBuilder(age, "25").build(), errors);
        assertThat(errors).isEmpty();
    }

    @Test
    public void testMaxValue() throws AppException {
        IntegerVarDef age = buildAgeVarDef(18, 120);
        List<AppError> errors = new ArrayList<AppError>();

        age.validate(new VarRunBuilder(age, "32").build(), errors);
        age.validate(new VarRunBuilder(age, "120").build(), errors);
        assertThat(errors).isEmpty();

        age.validate(new VarRunBuilder(age, "256").build(), errors);
        assertThat(errors).containsExactly(new AppError(IntegerVarDef.MSG_MAX_VALUE, new Serializable[]{120, 256}, AGE_NAME));

        // No max values
        age = buildAgeVarDef(18, null);
        errors.clear();
        age.validate(new VarRunBuilder(age, "25").build(), errors);
        assertThat(errors).isEmpty();

    }

    private IntegerVarDef buildAgeVarDef(Integer minValue, Integer maxValue) throws AppException {
        IntegerVarDefBuilder builder = new IntegerVarDefBuilder();
        builder.setName(AGE_NAME);
        builder.setDescription(AGE_DESCR);
        builder.setMinValue(minValue);
        builder.setMaxValue(maxValue);
        return builder.build();
    }
}
