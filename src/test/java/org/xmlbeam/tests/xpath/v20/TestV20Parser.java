/**
 *  Copyright 2014 Sven Ewald
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.xmlbeam.tests.xpath.v20;

import org.junit.Test;
import org.xmlbeam.util.xqparser.ParseException;
import org.xmlbeam.util.xqparser.XParser;

/**
 * @author sven
 */
public class TestV20Parser {

    @Test
    public void testV20() throws ParseException {
        XParser parser = new XParser(System.in);
        parser.START();
    }
}
