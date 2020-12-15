package structural_pattern.composite_pattern.composite.yang_family;

import structural_pattern.composite_pattern.component.Family;

import java.util.ArrayList;
import java.util.List;

public class YangParents implements Family {

    private List<Family> childList = new ArrayList<>();

    @Override
    public String getName() {
        return "YangParents";
    }

    @Override
    public String getDateOfBirth() {
        return "0000-00-00";
    }

    public void addChild(Family child) {
        childList.add(child);
    }

    public void removeChild(Family child) {
        childList.remove(child);
    }

    public List<Family> getChildList() {
        return this.childList;
    }
}
