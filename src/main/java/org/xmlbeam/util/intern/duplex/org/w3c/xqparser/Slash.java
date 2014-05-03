package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xmlbeam.util.intern.duplex.DuplexNodeTest;
import org.xmlbeam.util.intern.duplex.Step;

public class Slash extends XBDuplexNode {
    private final Step SLASH_STEP = new Step(new DuplexNodeTest() {
        @Override
        public Node apply(final Document doc, final Node target) {
            return doc;
        }
    });

    public Slash(final int id) {
        super(id);
    }

    public Slash(final XParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final XParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void apply(final List<? super Step> steplist) {
        steplist.add(SLASH_STEP);
    }
}
