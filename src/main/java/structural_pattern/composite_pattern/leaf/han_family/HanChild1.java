package structural_pattern.composite_pattern.leaf.han_family;

import structural_pattern.composite_pattern.component.Family;

public class HanChild1 implements Family {
    @Override
    public String getName() {
        return "HanChild1";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }
}
