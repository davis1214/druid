/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.query.groupby.having;

import org.junit.Assert;
import org.junit.Test;

/**
 */
public class HavingSpecMetricComparatorTest
{
  @Test
  public void testLongRegex()
  {
    Assert.assertTrue(HavingSpecMetricComparator.LONG_PAT.matcher("1").matches());
    Assert.assertTrue(HavingSpecMetricComparator.LONG_PAT.matcher("12").matches());

    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("1.").matches());
    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("1.2").matches());
    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("1.23").matches());
    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("1E5").matches());
    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("1.23E5").matches());

    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("").matches());
    Assert.assertFalse(HavingSpecMetricComparator.LONG_PAT.matcher("xyz").matches());
  }
}
