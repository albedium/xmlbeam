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
package org.xmlbeam.util.intern.duplex;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Step {

    public enum AXIS {
        ROOT,CHILD,PARENT,SELF,ANCESTOR,ANCESTOR_OR_SELF,DESCENDANT,DESCENDANT_OR_SELF,FOLLOWING,FOLLOWING_SIBLIBNG,PRECEDING,PRECEDING_SIBLING,ATTRIBUTE,NAMESPACE
    }
    
    private final AXIS axis;
    private final NodeTest nodeTest;
    private final List<Predicate> predicates=new LinkedList<Predicate>();
    
    public Step(final AXIS axis,final NodeTest nodeTest,final Collection<? extends Predicate> predicates) {
        this.axis=axis;
        this.nodeTest=nodeTest;
        this.predicates.addAll(predicates);
    }

    /**
     * @param nodeTest2
     */
    public Step(final NodeTest nodeTest) {
        this.axis=AXIS.CHILD;
        this.nodeTest=nodeTest;
    }
}
