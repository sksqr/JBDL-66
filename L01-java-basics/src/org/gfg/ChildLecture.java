package org.gfg;

import com.gfg.Lecture;

public class ChildLecture extends Lecture {
    public String details(){
        return super.lectureDetailsProtected();
    }
}
