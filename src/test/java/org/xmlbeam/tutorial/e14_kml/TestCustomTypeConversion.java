/**
 *  Copyright 2013 Sven Ewald
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
package org.xmlbeam.tutorial.e14_kml;

import java.io.IOException;

import org.junit.Test;
import org.xmlbeam.XBProjector;
import org.xmlbeam.config.DefaultXMLFactoriesConfig;
import org.xmlbeam.config.DefaultXMLFactoriesConfig.NamespacePhilosophy;
import org.xmlbeam.types.DefaultTypeConverter;

@SuppressWarnings("serial")
public class TestCustomTypeConversion {
   
    private final class CoordinateListConversion extends DefaultTypeConverter.Conversion<CoordinateList> {
        private CoordinateListConversion() {
            super(new CoordinateList(""));
        }

        @Override
        public CoordinateList convert(String data) {
            return new CoordinateList(data);
        }
    }

    @Test
    public void testCoordinateAccess() throws IOException {
        XBProjector projector = new XBProjector(new DefaultXMLFactoriesConfig().setNamespacePhilosophy(NamespacePhilosophy.AGNOSTIC));
        DefaultTypeConverter converter = new DefaultTypeConverter().setConversionForType(CoordinateList.class, new CoordinateListConversion());
        projector.config().setTypeConverter(converter);
        KML kml = projector.io().fromURLAnnotation(KML.class);
        System.out.println(kml.getCoordinates().toString());
//        for (Coordinate xy : kml.getCoordinates()) {
//            System.out.println("x:" + xy.x + " y:" + xy.y);
//        }
    }

}