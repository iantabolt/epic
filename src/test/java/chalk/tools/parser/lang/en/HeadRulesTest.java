/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package chalk.tools.parser.lang.en;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

import chalk.tools.parser.lang.en.HeadRules;

public class HeadRulesTest {

  @Test
  public void testSerialization() throws IOException {
    InputStream headRulesIn = 
        HeadRulesTest.class.getResourceAsStream("/chalk/tools/parser/en_head_rules");
    
    HeadRules headRulesOrginal = new HeadRules(new InputStreamReader(headRulesIn, "UTF-8"));
    
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    headRulesOrginal.serialize(new OutputStreamWriter(out, "UTF-8"));
    out.close();
    
    HeadRules headRulesRecreated = new HeadRules(new InputStreamReader(
        new ByteArrayInputStream(out.toByteArray()), "UTF-8"));
    
    assertEquals(headRulesOrginal, headRulesRecreated);
  }
}