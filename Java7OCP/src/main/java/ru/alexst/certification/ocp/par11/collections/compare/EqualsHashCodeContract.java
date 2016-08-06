/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.compare;

/*

EQUALS:
■ It is reflexive. For any reference value x, x.equals(x) should return true.
■ It is symmetric. For any reference values x and y, x.equals(y) should
return true if and only if y.equals(x) returns true.
■ It is transitive. For any reference values x, y, and z, if x.equals(y) returns
true and y.equals(z) returns true, then x.equals(z) must return true.
■ It is consistent. For any reference values x and y, multiple invocations of
x.equals(y) consistently return true or consistently return false, provided
no information used in equals() comparisons on the object is modified.
■ For any non-null reference value x, x.equals(null) should return false.

HASHCODE:
Your hashCode() implementation should use the same instance variables as in equals()
■ Whenever it is invoked on the same object more than once during an
execution of a Java application, the hashCode() method must consistently
return the same integer, provided that no information used in equals() 
comparisons on the object is modified. This integer need not remain consistent
from one execution of an application to another execution of the same
application.
■ If two objects are equal according to the equals(Object) method, then
calling the hashCode() method on each of the two objects must produce the
same integer result.
■ It is NOT required that if two objects are unequal according to the
equals(java.lang.Object) method, then calling the hashCode() method
on each of the two objects must produce distinct integer results. However,
the programmer should be aware that producing distinct integer results for
unequal objects may improve the performance of hashtables.
 */
public class EqualsHashCodeContract {

    private String s;

    private Integer i;

    /**
     * @return the s
     */
    public String getS() {
        return s;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((i == null) ? 0 : i.hashCode());
        result = prime * result + ((s == null) ? 0 : s.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EqualsHashCodeContract other = (EqualsHashCodeContract) obj;
        if (i == null) {
            if (other.i != null)
                return false;
        } else if (!i.equals(other.i))
            return false;
        if (s == null) {
            if (other.s != null)
                return false;
        } else if (!s.equals(other.s))
            return false;
        return true;
    }

    /**
     * @param s
     *            the s to set
     */
    public void setS(String s) {
        this.s = s;
    }

    /**
     * @return the i
     */
    public Integer getI() {
        return i;
    }

    /**
     * @param i
     *            the i to set
     */
    public void setI(Integer i) {
        this.i = i;
    }

}
