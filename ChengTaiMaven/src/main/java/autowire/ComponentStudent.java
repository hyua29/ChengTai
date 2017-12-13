package autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentStudent {

    @Autowired
    private ComponentCourse course;

    public ComponentCourse getCourse() {
        return course;
    }
}
