package autowire;

import org.springframework.stereotype.Component;

@Component
public class ComponentCourse {

    private String title = "100";
    public ComponentCourse(String c){
        this.title = c;
    }
    public ComponentCourse() {}

    @Override
    public String toString (){
        return this.title;
    }
}
