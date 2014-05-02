package org.xmlbeam.util.intern.duplex.org.w3c.xqparser;

import java.util.List;

import org.xmlbeam.util.intern.duplex.Step;

public
class PathExpr extends XBDuplexNode {
  public PathExpr(int id) {
    super(id);
  }

  public PathExpr(XParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(XParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  
  @Override
  public void apply(List<? super Step> steplist) {
      for (XBDuplexNode child:getChildren()) {
          child.apply(steplist);
      }
  }
}
