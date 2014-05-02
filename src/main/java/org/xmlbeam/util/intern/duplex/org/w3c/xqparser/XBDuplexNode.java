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
package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.Iterator;
import java.util.List;

import org.xmlbeam.XBException;
import org.xmlbeam.util.intern.duplex.Step;

/**
 *
 */
public class XBDuplexNode extends SimpleNode {

    public XBDuplexNode(int i) {
        super(i);
    }

    public XBDuplexNode(XParser p, int i) {
        super(p, i);
    }

    public Iterable<XBDuplexNode> getChildren() {
        return new Iterable<XBDuplexNode>() {

            @Override
            public Iterator<XBDuplexNode> iterator() {
                return new Iterator<XBDuplexNode>() {
                    int pos = 0;

                    @Override
                    public boolean hasNext() {
                        return pos < XBDuplexNode.this.jjtGetNumChildren();
                    }

                    @Override
                    public XBDuplexNode next() {
                        assert XBDuplexNode.this.jjtGetChild(pos) instanceof XBDuplexNode;
                        return (XBDuplexNode) XBDuplexNode.this.jjtGetChild(pos++);
                    }

                    @Override
                    public void remove() {
                        throw new IllegalStateException();
                    }
                };
            }
        };
    }

    public XBDuplexNode getChildWithID(int... ids) {
        for (XBDuplexNode child : getChildren()) {
            for (int id : ids) {
                if (child.id == id) {
                    return child;
                }
            }
        }
        return null;
    }

    public void apply(List<? super Step> steplist) {
        throw new PostParseException("Node " + m_value + " is not implemented.");
    }

}
