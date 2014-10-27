/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTBlockStatement.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTBlockStatement extends AbstractJavaNode {
    public ASTBlockStatement(int id) {
        super(id);
    }

    public ASTBlockStatement(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    /**
     * Tells if this BlockStatement is an allocation statement.
     * This is done by
     *
     * @return the result of containsDescendantOfType(ASTAllocationExpression.class)
     */
    public final boolean isAllocation() {
        return hasDescendantOfType(ASTAllocationExpression.class);
    }
}
