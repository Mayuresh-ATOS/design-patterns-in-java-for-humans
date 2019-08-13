package com.pmareke.interfaces;

import com.pmareke.models.Dolphin;
import com.pmareke.models.Lion;
import com.pmareke.models.Monkey;

public interface AnimalOperation {
    String visitMonkey(Monkey monkey);

    String visitLion(Lion lion);

    String visitDolphin(Dolphin dolphin);
}
