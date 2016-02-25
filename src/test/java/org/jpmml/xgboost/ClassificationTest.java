/*
 * Copyright (c) 2016 Villu Ruusmann
 *
 * This file is part of JPMML-XGBoost
 *
 * JPMML-XGBoost is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-XGBoost is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-XGBoost.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.xgboost;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Batch;
import org.junit.Test;

public class ClassificationTest extends XGBoostTest {

	@Test
	public void evaluateAudit() throws Exception {
		evaluateAudit("Audit");
	}

	@Test
	public void evaluateAuditNA() throws Exception {
		evaluateAudit("AuditNA");
	}

	private void evaluateAudit(String dataset) throws Exception {

		try(Batch batch = createBatch("LogisticRegression", dataset)){
			Set<FieldName> ignoredFields = ImmutableSet.of(FieldName.create("_target"), FieldName.create("xgbValue"));

			evaluate(batch, ignoredFields);
		}
	}
}