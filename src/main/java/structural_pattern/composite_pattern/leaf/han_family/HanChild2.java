package structural_pattern.composite_pattern.leaf.han_family;

import structural_pattern.composite_pattern.component.Family;

public class HanChild2 implements Family {
    @Override
    public String getName() {
        return "HanChild2";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }
}
