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
 * Tests for the string variable definition.
 *
 * @author Arnaud Rolly <github@niaouli.org>
 */
public class StringTest {

    private static final String OS_NAME = "Operating System (OS)";
    private static final String OS_DESCR = "Your preferred OS";

    @Test
    public void testBuilder() throws AppException {
        StringVarDef os = buildOsVarDef(2, 6);
        assertThat(os).isNotNull();
        assertThat(os.getMinLength()).isEqualTo(2);
        assertThat(os.getMaxLength()).isEqualTo(6);
    }

    @Test
    public void testMinLength() throws AppException {
        StringVarDef os = buildOsVarDef(5, null);
        List<AppError> errors = new ArrayList<AppError>();

        // Also test various builder constructions for test coverage
        List<String> linuxesNames = new ArrayList<String>();
        linuxesNames.add("Debian");
        VarRunBuilder linuxesBuilder = new VarRunBuilder();
        linuxesBuilder.setDef(os);
        linuxesBuilder.setValues(linuxesNames);
        VarRun linuxes = linuxesBuilder.build();

        errors.clear();
        os.validate(linuxes, errors);
        assertThat(errors.isEmpty());

        linuxesBuilder.setValues(null);
        linuxesBuilder.addValue("Win");
        linuxes = linuxesBuilder.build();
        errors.clear();
        os.validate(linuxes, errors);
        assertThat(errors).containsExactly(new AppError(StringVarDef.MSG_MIN_LENGTH, new Serializable[]{5, 3, "Win"}, OS_NAME));
    }

    @Test
    public void testMaxLength() throws AppException {
        StringVarDef os = buildOsVarDef(1, 6);
        List<AppError> errors = new ArrayList<AppError>();

        VarRun linuxes = new VarRunBuilder(os, "Debian").build();
        errors.clear();
        os.validate(linuxes, errors);
        assertThat(errors).isEmpty();

        linuxes = new VarRunBuilder(os, "Windows").build();
        errors.clear();
        os.validate(linuxes, errors);
        assertThat(errors).containsExactly(new AppError(StringVarDef.MSG_MAX_LENGTH, new Serializable[]{6, 7, "Windows"}, OS_NAME));
    }

    private StringVarDef buildOsVarDef(Integer minLength, Integer maxLength) throws AppException {
        StringVarDefBuilder builder = new StringVarDefBuilder();
        builder.setName(OS_NAME);
        builder.setDescription(OS_DESCR);
        builder.setMinLength(minLength);
        builder.setMaxLength(maxLength);
        return builder.build();
    }
}
