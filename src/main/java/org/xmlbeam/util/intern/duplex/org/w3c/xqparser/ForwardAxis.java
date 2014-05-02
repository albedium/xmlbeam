package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import org.xmlbeam.util.intern.duplex.Step;
import org.xmlbeam.util.intern.duplex.Step.AXIS;

public
class ForwardAxis extends AbstractAxisNode {
  public ForwardAxis(int id) {
    super(id);
  }

  public ForwardAxis(XParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(XParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  
  @Override
  public AXIS getAxis() {
      return Step.AXIS.CHILD;
  }
}
