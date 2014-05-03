package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xmlbeam.util.intern.duplex.DuplexNodeTest;
import org.xmlbeam.util.intern.duplex.Step;
import org.xmlbeam.util.intern.duplex.Step.AXIS;

public class StepExpr extends XBDuplexNode {
    public StepExpr(final int id) {
        super(id);
    }

    public StepExpr(final XParser p, final int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    @Override
    public Object jjtAccept(final XParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void apply(final List<? super Step> steplist) {
        Step.AXIS axis = findAxis();

        DuplexNodeTest filter = findNodeTest();

        steplist.add(new Step(axis, filter, predicates));
    }

    private AXIS findAxis() {
        XBDuplexNode axisNode = getChildWithID(XParserTreeConstants.JJTFORWARDAXIS, XParserTreeConstants.JJTREVERSEAXIS);
        if (axisNode == null) {
            return AXIS.CHILD;
        }
        String axisName = axisNode.getValue();
        return AXIS.valueOf(axisName.toUpperCase().replace('-', '_'));
    }

    private DuplexNodeTest findNodeTest() {
        XBDuplexNode nodeTestNode = getChildWithID(XParserTreeConstants.JJTNODETEST);
        XBDuplexNode nameTest = nodeTestNode.getChildWithID(XParserTreeConstants.JJTNAMETEST);
        if (nameTest != null) {
            final String name = nameTest.getChildWithID(XParserTreeConstants.JJTQNAME).getValue();
            return new DuplexNodeTest() {

                @Override
                public Node apply(final Document doc, final Node target) {
                    if (target.getNodeName().equals(name)) {
                        return name;
                    }
                    return null;
                }

            };

        }
        return null;
    }
}
