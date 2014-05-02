package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.List;

import org.xmlbeam.util.intern.duplex.Step;
import org.xmlbeam.util.intern.duplex.Step.AXIS;

public class StepExpr extends XBDuplexNode {
    public StepExpr(int id) {
        super(id);
    }

    public StepExpr(XParser p, int id) {
        super(p, id);
    }

    /** Accept the visitor. **/
    public Object jjtAccept(XParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void apply(List<? super Step> steplist) {
        Step.AXIS axis = findAxis();

        NodeTest nodeTest = findNodeTest();
                
        steplist.add(new Step(axis, nodeTest, predicates));
    }
   
    private AXIS findAxis() {
        XBDuplexNode axisNode = getChildWithID(XParser.JJTFORWARDAXIS,XParser.JJTREVERSEAXIS);
        if (axisNode==null) {
            return AXIS.CHILD;
        }
        String axisName = axisNode.getValue();        
        return AXIS.valueOf(axisName.toUpperCase().replace('-', '_'));
    }

    private NodeTest findNodeTest() {
        XBDuplexNode nodeTestNode = getChildWithID(XParser.JJTNODETEST);
        XBDuplexNode nameTest = nodeTestNode.getChildWithID(XParser.JJTNAMETEST);
        if (nameTest!=null) {
            return new NameTest(nameTest.getChildWithID(XParser.JJTQNAME).getValue());
        }
        return null;
    }
    
}
