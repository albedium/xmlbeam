package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.List;

import org.xmlbeam.util.intern.duplex.DocumentRootNodeTest;
import org.xmlbeam.util.intern.duplex.NodeTest;
import org.xmlbeam.util.intern.duplex.Step;
import org.xmlbeam.util.intern.duplex.Step.AXIS;

public class Slash extends XBDuplexNode {
    private final Step SLASH_STEP = new Step(new DocumentRootNodeTest());
    public Slash(int id) {
        super(id);
    }

    public Slash(XParser p, int id) {
        super(p, id);
    }

    public Object jjtAccept(XParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void apply(List<? super Step> steplist) {
        steplist.add(SLASH_STEP);
    }
}
