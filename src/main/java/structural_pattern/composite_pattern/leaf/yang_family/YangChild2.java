package structural_pattern.composite_pattern.leaf.yang_family;

import structural_pattern.composite_pattern.component.Family;

public class YangChild2 implements Family {
    @Override
    public String getName() {
        return "YangChild2";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
